<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.search.SearchEngineUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.search.BooleanClauseOccur"%>
<%@page import="com.liferay.portal.model.GroupConstants"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Conjunction"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.mysql.jdbc.StringUtils"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Disjunction"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.JavaConstants" %>
<%@ page import="com.liferay.portal.model.LayoutSet" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanQuery" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%-- <%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %> --%>
<!-- <liferay-theme:defineObjects /> -->

<%

String palabraClave = StringUtil.extractLast(PortalUtil.getCurrentURL(request), "/");
System.out.println("KEY:"+palabraClave);

long companyId,groupId;
companyId = PortalUtil.getCompanyId(request);
Group guestGroup = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST);

/*En reemplazo del ThemeDisplay*/
groupId = guestGroup.getGroupId();

System.out.println("companyId "+companyId);
System.out.println("groupId " + groupId);

String categoriasExcluidas[]={"Banners Promocionales"/*,"Productos"*/};

List<Long> admitidos=null;
	try{
	  DynamicQuery queryCategoria =DynamicQueryFactoryUtil.forClass(AssetCategory.class, PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
	  
	  List<AssetCategory> categorias =AssetCategoryLocalServiceUtil.dynamicQuery(queryCategoria);
		for (AssetCategory categoria : categorias) {
			boolean isActive=true;
			
			for (String excluidos : categoriasExcluidas) {
				if(excluidos.equalsIgnoreCase(categoria.getName())){
					isActive=false;
					break;
				}
			}
			
			/*Agrego y hago break al for de excluidos*/
			if(isActive){
				if(admitidos==null){admitidos=new ArrayList<Long>();}
				admitidos.add(categoria.getCategoryId());
			}
		}
	}catch(Exception e){
	// 	  _log.error("Error al filtrar las Categorias:"+e.toString());
	}

	List<Document> documentos=null;
	Hits  resultados;
		SearchContext searchContext = new SearchContext();
				// Query que busca en el portal que deseemos
				BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
				contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
				contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);
		
				// Query que busca que la cadena introducida por el usuairo está en uno de los campos principales
				BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
				searchQuery.addTerm(Field.TITLE, palabraClave);
				//searchQuery.addTerm(Field.DESCRIPTION, palabraClave);
				searchQuery.addTerm(Field.CONTENT, palabraClave);
				//searchQuery.addTerm(Field.PROPERTIES, palabraClave);
				
				// Querypara buscador solo JournalContents
				BooleanQuery JCQuery = BooleanQueryFactoryUtil.create(searchContext);
				JCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
				JCQuery.addRequiredTerm(Field.STATUS,0 );
				  
				// Querypara buscador solo Ciertas categorias
				BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
				for (long categoria : admitidos) {
					categoriaQuery.addTerm(Field.ASSET_CATEGORY_IDS,categoria+"",false,BooleanClauseOccur.SHOULD);
				}
				
				//Query expandoQuery=StringQueryFactoryUtil.create("expando/custom_fields/destacado:si");
				// Creamos query completa para enlazar las demás obligando a que
				// el enlace sea un AND [MUST] en lugar de un OR[SHOULD]
				BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
				fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
				fullQuery.add(JCQuery , BooleanClauseOccur.MUST);
				fullQuery.add(categoriaQuery , BooleanClauseOccur.MUST);
				//fullQuery.add(expandoQuery , BooleanClauseOccur.MUST);
				
				// Añadimos ordenación (nombre descendente)
				Sort sort = new Sort();
				sort.setFieldName(Field.TITLE);
				sort.setType(Sort.STRING_TYPE);
				sort.setReverse(true);  
				
				resultados=SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(),companyId, fullQuery,sort,-1,-1);
				
				documentos = resultados.toList();
				
// 				if (documentos != null && !documentos.isEmpty()) {
// 					 for(Document doc : documentos) {
// 						Long classPK;
// 						AssetEntry assetEntry ;

// 					    classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
// 					    assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), classPK);	
// 					    System.out.println(assetEntry.getTitle(Locale.getDefault()));
					    
					    
					    
// // 					    BuscadorBean aux=BuscadorUtil.visualizarAsset( themeDisplay, assetEntry);
// // 						if(aux!=null){
// // 							if(resultados==null){resultados=new ArrayList<BuscadorBean>();}
// // 							aux.setResumen(StringUtil.highlight(aux.getResumen(), new String[]{keywords}));
// // 							aux.setTitulo(StringUtil.highlight(aux.getTitulo(), new String[]{keywords}));
// // 							resultados.add(aux);
// // 						}
						
// 					 }
// 					}

				
				
%>

<!--CONT-MEDIO-->
    <div id="content-medio">
      <div class="error-cont">
        <div class="error-dialog"> <img src="/halcon-theme/images/halcon/error-img-00.jpg" border="0" align="middle"  alt="Ups..."/>
          <div class="float-left">
            <h2>¡Lo sentimos!</h2>
            <p>pero la página que buscas no ha sido encontrada.</p>
            <p class="mg13">No te preocupes, le pasa al mejor de nosotros.</p>
            <p class="mg16">Tal vez te interese:</p>
            <ul class="bluelist">
	            <% for(Document doc : documentos) {
					Long classPK;
					AssetEntry assetEntry ;
				    classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
				    assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), classPK);	
				 %>
				 <li><%=assetEntry.getTitle(Locale.getDefault()) %></li>
	            <%} %>
            </ul>
          </div>
          <div class="both"></div>
        </div>
        <div class="cntr"> <a href="#" title="Página anterior" class="ant" ><em></em>Página anterior</a> <a href="#" title="Ir al Home" class="home" ><em></em>Ir al Home</a> <div  class="both"></div></div>
      </div>
    </div>
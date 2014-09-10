<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@page import="com.liferay.portal.kernel.xml.Node"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.model.GroupConstants"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<%
String ruta =  request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

  	String op= request.getParameter("op");
    String gi= request.getParameter("gi");
    
    long companyId =PortalUtil.getDefaultCompanyId();
    Group guestGroup = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST);
    
    /*En reemplazo del ThemeDisplay*/
  	long groupId = guestGroup.getGroupId();
    
   // System.out.println("OP:"+op);
   // System.out.println("GroupId "+groupId);
    JournalArticle articulo=null;
    String contenido="";
    String languageID = new Locale("es","ES").toString();
  	try {
  		articulo=JournalArticleLocalServiceUtil.getLatestArticle(groupId,op);
  		if(articulo!=null && articulo.isApproved()){
  			String urlRuta;
  			if(articulo.getStructureId().equals("")) {
  				urlRuta = "/root/static-content";
  			} else {
  				urlRuta = "/root/dynamic-element[@name='html']/dynamic-content"; 
  			}
  			String localeContent =articulo.getContentByLocale(languageID);
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(localeContent);
			Node node = document.selectSingleNode(urlRuta);
			contenido = node.getText();
  			
			
  			//System.out.println("CC: "+contenido);
  			response.setContentType("text/html");
  			PrintWriter writer = response.getWriter();
  			
  			writer.write("<link rel='stylesheet' type='text/css' href='"+ruta+"/halcon-theme/css/lightbox.css'  />");
  			
  			writer.write(contenido);
  			writer.flush();
  			writer.close();
  		}
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  %>



  
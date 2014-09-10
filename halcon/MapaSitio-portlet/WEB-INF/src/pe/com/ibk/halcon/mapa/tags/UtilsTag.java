package pe.com.ibk.halcon.mapa.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class UtilsTag.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class UtilsTag extends TagSupport{
    
    /** The pagina actual. */
    private Layout paginaActual=null;


    /**
     * Establece el pagina actual.
     *
     * @param p el new pagina actual
     */
    public void setPaginaActual(Layout p) { paginaActual = p; }


    /* (non-Javadoc)
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag() throws JspException {
        try{
             
             String s="";
             
             if(paginaActual.isTypeLinkToLayout()){
            	String idPaginaVerdadera=paginaActual.getLayoutType().getTypeSettingsProperty("linkToLayoutId");
            	Layout pagina=LayoutLocalServiceUtil.getLayout(paginaActual.getGroupId(), false, Long.parseLong(idPaginaVerdadera));
            	s=pagina.getFriendlyURL();
             }else{
            	 s=paginaActual.getFriendlyURL();
             }
    
             
             pageContext.getOut().print( s );

        } catch (Exception e) {
             throw new JspException ("Error: IOException" + e.getMessage());
         }

        return SKIP_BODY;
     }

    /* (non-Javadoc)
     * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
     */
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
     }
}

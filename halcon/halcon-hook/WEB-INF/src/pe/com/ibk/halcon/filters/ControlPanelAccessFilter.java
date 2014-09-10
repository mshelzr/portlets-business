package pe.com.ibk.halcon.filters;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.HttpUtil;

public class ControlPanelAccessFilter implements Filter {

	public ControlPanelAccessFilter() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
				  String clientIp = arg0.getRemoteAddr();
				  String geoIPLocationServiceURL = "http://geoip.wtanaka.com/cc/"+ clientIp;
				  String geoIPLocationResponse = HttpUtil.URLtoString(geoIPLocationServiceURL);
				  
				  System.out.println("IP:"+clientIp+" -- PAIS:"+geoIPLocationResponse);
				  System.out.println("HOST:"+arg0.getRemoteHost());
				  
				  
				  HttpServletRequest request = (HttpServletRequest) arg0;
			      String requestURI = request.getRequestURI();
			      System.out.println("URL ACTUAL:"+requestURI);
				  /*if(geoIPLocationResponse.equalsIgnoreCase("zz")){
				   Writer writer = arg1.getWriter();
				   writer.write("This website is not accessible from your Location");
				  }else{
				   
				  }*/
				  if(requestURI.equalsIgnoreCase("/group/control_panel") && (!clientIp.equalsIgnoreCase("192.168.1.79") || !geoIPLocationResponse.equalsIgnoreCase("zz") )){	  
					  Writer writer = arg1.getWriter();
					  writer.write("No esta autorizado para entrar a esta URL.");
				  }else{
					  arg2.doFilter(arg0, arg1);
				  }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

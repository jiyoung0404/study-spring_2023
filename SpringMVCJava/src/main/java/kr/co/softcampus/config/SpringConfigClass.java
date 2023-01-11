package kr.co.softcampus.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 상속받아서 SpringConfigClass이 web.xml 파일 역할을 한다
//public class SpringConfigClass implements WebApplicationInitializer {
//
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		//		   <!-- Spring MVC에서 제공하고 있는 기본 서블릿을 지정한다. -->
//		//	        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//		// Spring MVC 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다
//		// 방금 만든 ServletAppContext를 Spring 설정을 위한 클래스로 지정한다
//		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
//		servletAppContext.register(ServletAppContext.class);
//	
////			요청 발생 시 요청을 처리하는 서블릿을 DispaatcherServlet으로 설정해준다
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//
//// 부가 설정
////		 <!-- Spring MVC 설정을 위한 xml 파일을 지정한 -->
////	        <init-param>
////	        	<param-name>contextConfigLocation</param-name>
////	        	<param-value>/WEB-INF/config/servlet-context.xml</param-value>
////	        </init-param>
////	        <load-on-startup>1</load-on-startup>
////	        </servlet>
////	    
//		servlet.setLoadOnStartup(1); // 가장 먼저 로딩
//		servlet.addMapping("/");
//		
//		
//		//Bean을 정의하는 클래스를 지정한다
//		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//		rootAppContext.register(RootAppContext.class);
//		
//		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
//		servletContext.addListener(listener);
//		
//		// 파라미터 인코딩 설정
//		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//		filter.setInitParameter("encoding", "UTF-8");
//		filter.addMappingForServletNames(null, false, "dispatcher"); // dispatcher 위에 받아들인 정보들을 인코딩 필터를 통과시키겠다
//	}
//}


/* 위 코는 일일이 코드를 적은것, 위 코드보다 더 간단한 방법은 아래방법
 * 간단하지만 코드의 자율성이 떨어짐, 정해져있는대로...
 * 간단한 대신 확장성이 떨어짐
 * */

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer {

	// DispatcherServlet에 매핑할 요청 주소를 셋팅한다
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	// Spring MVC 프로젝트 설정을 위한 클래스를 지정한다
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	//프로젝트에서 사용할 Bea들을 정의하기 위한 클래스를 정한다
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
}

 
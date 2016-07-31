package br.loja.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebXMLConfig implements WebApplicationInitializer{

	public void onStartup(ServletContext arg0) throws ServletException {//Método que inicia a aplicação pelo contexto. Ponto inicial da aplicação
		
		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();  //Apartir desse atributo quye dizemos aonde estão as configurações
		annotationConfigWebApplicationContext.register(SpringMvcConfig.class);
		annotationConfigWebApplicationContext.setServletContext(arg0);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext); //Dispache é o que faz a parte de reposta da aplicação
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);//Página de erro. Quando a página não é encontrato e queremos colocar uma página de erro. Estamos habilitando esse recurso
		
		ServletRegistration.Dynamic registrationDynamic= arg0.addServlet("dispacher", dispatcherServlet);
		registrationDynamic.setLoadOnStartup(1);
		registrationDynamic.addMapping("/");//Quando tiver uma / é quando ele irá procurar as páginas
		
		FilterRegistration.Dynamic encondingFilter = arg0.addFilter("encondingFilter", new CharacterEncodingFilter());
		encondingFilter.setInitParameter("enconding", "UTF-8");
		encondingFilter.setInitParameter("forceEnconding", "true");
		encondingFilter.addMappingForUrlPatterns(null, true, "/*");
		
	} //A interface diz ao spring que todos os recursos do web.XML estão configurados em classe (programaticamente)
	
	

}





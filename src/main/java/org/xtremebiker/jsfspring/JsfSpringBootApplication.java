package org.xtremebiker.jsfspring;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class JsfSpringBootApplication implements ServletContextAware {

    public static void main(String[] args) {
        SpringApplication.run(JsfSpringBootApplication.class, args);
    }

//	@Bean
//	public static CustomScopeConfigurer viewScope() {
//		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
//		configurer.setScopes(new ImmutableMap.Builder<String, Object>().put("view", new ViewScope()).build());
//		return configurer;
//	}

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet facesServlet = new FacesServlet();
        List<String> arrlist = new ArrayList<String>();
        arrlist.add("*.xhtml");
//        arrlist.add("*.jsf");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(facesServlet);
        servletRegistrationBean.setUrlMappings(arrlist);
//        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        // Iniciar el contexto de JSF
        // http://stackoverflow.com/a/25509937/1199132
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");

    }

}

package com.udemy.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.udemy.component.RequestTimeInterceptor;


@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	private static final Log LOG = LogFactory.getLog(WebMvcConfiguration.class);
	
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LOG.info("[WebMvcConfiguration} Se va agregar en el Registry el objeto requestTimeInterceptor: "+requestTimeInterceptor);
		registry.addInterceptor(requestTimeInterceptor);
		LOG.info("[WebMvcConfiguration] Se agrego en el Registry con el addInterceptor: "+registry);
	}

}

package com.vcg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.vcg.interceptor.AuthInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Autowired
	AuthInterceptor authInterceptor;
	
	 @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
        .addResourceLocations("classpath:/static/")
        .setCachePeriod(0);
        super.addResourceHandlers(registry);;
        
    }
	 
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
		super.addCorsMappings(registry);
	}

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(authInterceptor).addPathPatterns("/**");
		
		super.addInterceptors(registry);
	}

	 
}

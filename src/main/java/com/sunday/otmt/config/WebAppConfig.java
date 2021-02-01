package com.sunday.otmt.config;

import com.mchange.v2.codegen.bean.Property;
import com.sunday.otmt.converter.StringToDateConverter;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sunday.otmt.converter.StringToUserConverter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.sunday.otmt")
@EnableTransactionManagement
public class WebAppConfig implements WebMvcConfigurer {
	
	@Autowired
	private StringToUserConverter stringToUserConverter;

	@Autowired
	private StringToDateConverter stringToDateConverter;

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(stringToUserConverter);
		registry.addConverter(stringToDateConverter);
	}
	
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}














}

package com.alex.config;

import javax.servlet.ServletRegistration.Dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author AlexZHOU 2017.10.12
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private final static Logger log = LoggerFactory.getLogger(WebAppInitializer.class);

	/**
	 * Spring Ioc 环境配置
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println(log + "::getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return null;
	}

	@Override
	protected String[] getServletMappings() {

		return null;
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
	}

}

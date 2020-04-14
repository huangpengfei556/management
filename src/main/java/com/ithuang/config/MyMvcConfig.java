package com.ithuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ithuang.component.MyLocaleResolver;

/**  
  * ClassName: MyMvcConfig <br/>  
  * Function: TODO ADD FUNCTION. <br/>  
  * Reason: TODO ADD REASON(可选). <br/>  
  * date: 2020年4月14日 下午8:50:13 <br/>  
  *  
  * @author Administrator  
  * @version   
  * @since JDK 1.6  
  */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
			}
		};
		return adapter;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
}

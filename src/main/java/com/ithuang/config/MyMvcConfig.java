package com.ithuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ithuang.component.LoginHandlerInterceptor;
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
				registry.addViewController("/main.html").setViewName("dashboard");
			}

			//注册拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				//super.addInterceptors(registry);
				//静态资源；  *.css , *.js
				//SpringBoot已经做好了静态资源映射
				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
						.excludePathPatterns("/index.html", "/", "/user/login");
			}

		};
		return adapter;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
}

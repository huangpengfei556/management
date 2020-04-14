package com.ithuang.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

/**  
  * ClassName: MyLocaleResolver <br/>  
  * Function: TODO ADD FUNCTION. <br/>  
  * Reason: TODO ADD REASON(可选). <br/>  
  * date: 2020年4月14日 下午9:58:25 <br/>  
  *  
  * @author Administrator  
  * @version   
  * @since JDK 1.6  
  */
/**
 * 可以在连接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

	}

	/**  
	  * TODO 简单描述该方法的实现功能（可选）.  
	  * @see org.springframework.web.servlet.LocaleResolver#resolveLocale(javax.servlet.http.HttpServletRequest)  
	  */
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String l = request.getParameter("l");
		Locale locale = Locale.getDefault();
		if (!StringUtils.isEmpty(l)) {
			String[] split = l.split("_");
			locale = new Locale(split[0], split[1]);
		}
		return locale;
	}
}
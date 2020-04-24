package com.ithuang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.ithuang.common.ManagerException;
import com.ithuang.common.Result;

import lombok.extern.slf4j.Slf4j;

/**  
  * ClassName: ControllerAop <br/>  
  * Function: 切面类，做日志和异常处理 <br/>  
  * date: 2019年12月16日 上午8:13:04 <br/>  
  *  
  * @author Administrator  
  * @version   
  * @since JDK 1.6  
  */
@Aspect
@Component
@Slf4j
public class ControllerAop{

	@Pointcut("execution(* com.ithuang.controller..*.*(..))")
	public void executePackage() {
	}

	@Around(value = "executePackage()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		String args = proceedingJoinPoint.getArgs().length > 0 ? proceedingJoinPoint.getArgs()[0].toString() : "";
		log.info("Method：" + proceedingJoinPoint.getSignature().getName() + " parameters：[" + args + "]");

		try {
			Result result = (Result) proceedingJoinPoint.proceed();
			log.info("output：" + result);
			if (result.get("data") instanceof PageImpl) {
				Page<?> page = (Page<?>) result.get("data");
				log.info("Page：" + page.getContent());
			}
			return result;
		} catch (ManagerException e) {
			Result error = Result.error(e.getErrorCode(), e.getMessage());
			log.info("output：" + error);
			return error;
		} catch (Throwable throwable) {
			Result error = Result.error("系统异常");
			log.info("output:" + error);
			log.info(throwable.getMessage());
			return error;
		}
	}
}

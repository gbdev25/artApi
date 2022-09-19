package com.revature.facepaint.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static Logger log = LoggerFactory.getLogger(LoggingAspect.class); 
	
	@Before("within(com.revature.facepaint.exceptions.GlobalExceptionHandler)")
	public void logException(JoinPoint jp) {
		log.error(jp.getTarget() + "was invoked" + jp.getSignature());
		
		
	}

}

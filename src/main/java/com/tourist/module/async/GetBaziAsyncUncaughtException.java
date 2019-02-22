package com.tourist.module.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class GetBaziAsyncUncaughtException implements AsyncUncaughtExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GetBaziAsyncUncaughtException.class);
	
	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		logger.info("async method name : {}", method.getName());
		for(Object param : params) {
			logger.info("async method param name : {}", param);
		}
		ex.printStackTrace();
	}

}

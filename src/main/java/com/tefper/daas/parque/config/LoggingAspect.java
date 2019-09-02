package com.tefper.daas.parque.config;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.tefper.daas.parque.util.UtilLog;

@Aspect
@Configuration
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("within(com.tefper.daas.parque.operation.*)")
	public void allOperation() {}

	@Before("allOperation() && args(..,request)")
	public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {

		UtilLog.generateTracking();
		StringBuilder sb = new StringBuilder();
		sb.append("Entering in Method :  " + (joinPoint.getSignature().getName()));
		sb.append("\n");
		sb.append("Class Name :  " + (joinPoint.getSignature().getDeclaringTypeName()));
		sb.append("\n");
		sb.append("Arguments :  " + (Arrays.toString(joinPoint.getArgs())));
		sb.append("\n");
		sb.append("Target class : " + (joinPoint.getTarget().getClass().getName()));
		sb.append("\n");
		sb.append("TrackingId: " + (UtilLog.getTracking()));
		sb.append("\n");

		if (request != null) {

			sb.append("Start Header Section of request ");
			sb.append("\n");
			sb.append("Method Type : " + (request.getMethod()));
			sb.append("\n");
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement();
				String headerValue = request.getHeader(headerName);
				sb.append("Header Name: " + headerName + " Header Value : " + headerValue);
				sb.append("\n");
				sb.append("Method Type : " + (request.getMethod()));
				sb.append("\n");
			}
			sb.append("Request Path info :" + request.getServletPath());
			sb.append("\n");
			sb.append("End Header Section of request ");
			sb.append("\n");

		}
		LOGGER.info(sb.toString());
	}

}

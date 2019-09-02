package com.tefper.daas.parque.exception;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tefper.daas.parque.model.ExceptionType;
import com.tefper.daas.parque.util.Constant;
import com.tefper.daas.parque.util.UtilLog;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		ExceptionType error = new ExceptionType();
		error.setExceptionId(Constant.SVC1003_CODE);
		error.setExceptionText(Constant.SVC1003_DESCRIPTION);
		error.setMoreInfo(Constant.SVC1003_EXCEPTION);
		error.setUserMessage(Constant.SVC1003_TEXT);

		Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
		if (!CollectionUtils.isEmpty(supportedMethods)) {
			headers.setAllow(supportedMethods);
		}
		LOGGER.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);

	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionType error = new ExceptionType();
		error.setExceptionId(Constant.SVC1000_CODE);
		error.setExceptionText(Constant.SVC1000_DESCRIPTION);
		error.setMoreInfo(Constant.SVC1000_EXCEPTION);
		error.setUserMessage(Constant.SVC1000_TEXT.concat(ex.getVariableName()));
		LOGGER.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		ExceptionType error = new ExceptionType();
		error.setExceptionId(Constant.SVC1000_CODE);
		error.setExceptionText(Constant.SVC1000_DESCRIPTION);
		error.setMoreInfo(Constant.SVC1000_EXCEPTION);
		error.setUserMessage(Constant.SVC1000_TEXT.concat(ex.getParameterName()));
		LOGGER.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		ex.getConstraintViolations().parallelStream().forEach(cv -> {
			errors.add(cv.getRootBeanClass().getName().concat(": ").concat(cv.getMessage()));
		});
		StringJoiner joiner = new StringJoiner(",", "[", "]");
		errors.forEach(joiner::add);

		ExceptionType error = new ExceptionType();
		error.setExceptionId(Constant.SVC1001_CODE);
		error.setExceptionText(Constant.SVC1001_DESCRIPTION);
		error.setMoreInfo(Constant.SVC1001_EXCEPTION);
		error.setUserMessage(Constant.SVC1001_TEXT.concat(joiner.toString()));
		LOGGER.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		ExceptionType error = new ExceptionType();
		error.setExceptionId(Constant.SVR1000_CODE);
		error.setExceptionText(Constant.SVR1000_DESCRIPTION);
		error.setMoreInfo(Constant.SVR1000_EXCEPTION);
		error.setUserMessage(Constant.SVR1000_TEXT);
		LOGGER.error("TrackingId: ".concat(UtilLog.getTracking()));
		LOGGER.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		ExceptionType error = new ExceptionType();
		error.setExceptionId(Constant.SVC1001_CODE);
		error.setExceptionText(Constant.SVC1001_DESCRIPTION);
		error.setMoreInfo(Constant.SVC1001_EXCEPTION);
		error.setUserMessage(Constant.SVC1001_TEXT);
		LOGGER.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<Object> handleBusinessException(Exception ex) {

		ExceptionType error = new ExceptionType();
		error.setExceptionId(Constant.SVC1006_CODE);
		error.setExceptionText(Constant.SVC1006_EXCEPTION);
		error.setMoreInfo(MessageFormat.format(Constant.SVC1006_DESCRIPTION, ex.getMessage()));
		error.setUserMessage(Constant.SVC1006_TEXT);
		LOGGER.error("TrackingId: ".concat(UtilLog.getTracking()));
		LOGGER.error(ExceptionUtils.getStackTrace(ex));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}

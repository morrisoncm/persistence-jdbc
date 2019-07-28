package com.demo.jdbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Demo User already exist!")
public class DemoUserFoundException extends RuntimeException {

	private static final long serialVersionUID = -1243983916098837764L;

	public DemoUserFoundException() {
		super();
	}
}
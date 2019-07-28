package com.demo.jdbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Demo User does not exist!")
public class DemoUserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1930618664658063212L;

	public DemoUserNotFoundException() {
		super();
	}
}

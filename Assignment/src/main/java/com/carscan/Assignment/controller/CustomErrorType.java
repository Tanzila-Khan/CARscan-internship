package com.carscan.Assignment.controller;

import com.carscan.Assignment.entity.Assignment;

public class CustomErrorType extends Assignment {
	private String errorMessage;
	public CustomErrorType(final String errorMessage){
	this.errorMessage = errorMessage;
	}
//	@Override
//	public String getErrorMessage() {
//	return errorMessage;
//	}
}

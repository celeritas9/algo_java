package com.exception;

public class SampleException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public SampleException(String message_)
	{
		message = message_;
	}
}

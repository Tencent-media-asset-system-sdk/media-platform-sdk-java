package com.tencent.aimedia;

public class ResponseErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	private String requestId;
	private String code;
	private String message;
	
	public ResponseErrorException(String code, String message, String requestId) {
		this.requestId = requestId;
		this.code = code;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "response return err, code: " + code + ", msg: " + message + ", requestId: " + requestId;
	}

}

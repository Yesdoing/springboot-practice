package net.yesdoing.domain;

public class Result {
	private boolean valid;
	private String errorMessage;
	
	private Result(boolean valid, String errorMessage) {
		this.valid = valid;
		this.errorMessage = errorMessage;
	}
	
	public static Result ok() {
		return new Result(true, "");
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public static Result fail(String errorMessage) {
		return new Result(false, errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}

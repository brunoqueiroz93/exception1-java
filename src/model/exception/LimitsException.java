package model.exception;

public class LimitsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public LimitsException(String msg) {
		super(msg);
	}
}

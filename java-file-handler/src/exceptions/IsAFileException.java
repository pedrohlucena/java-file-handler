package exceptions;

public class IsAFileException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IsAFileException(String errorMessage) {
		super(errorMessage);
	}
}

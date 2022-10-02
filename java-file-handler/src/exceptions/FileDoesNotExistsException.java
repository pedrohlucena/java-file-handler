package exceptions;

public class FileDoesNotExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FileDoesNotExistsException(String errorMessage) {
		super(errorMessage);
	}
}

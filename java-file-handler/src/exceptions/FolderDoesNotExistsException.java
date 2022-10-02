package exceptions;

public class FolderDoesNotExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FolderDoesNotExistsException(String errorMessage) {
		super(errorMessage);
	}
}

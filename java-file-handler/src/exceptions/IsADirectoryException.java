package exceptions;

public class IsADirectoryException extends Exception {
	private static final long serialVersionUID = 1L;

	public IsADirectoryException(String errorMessage) {
		super(errorMessage);
	}
}

//package exceptions;
//
//public class FileDoesNotExistsException extends Exception {
//	
//}
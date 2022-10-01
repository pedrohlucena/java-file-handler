package utils;
public class HandleError {
	public static void handleError(Exception e) {
		System.err.println("ERRO: " + e.getMessage());
		e.printStackTrace();
	}
}

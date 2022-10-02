package utils;

public class ClearTerminal {
	public static void clearTerminal() {
		final String os = System.getProperty("os.name");
        
        try {
        	if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
            	Runtime.getRuntime().exec("clear");
            }
		} catch (Exception e) {
			HandleError.handleError(e);
		}
	}
}

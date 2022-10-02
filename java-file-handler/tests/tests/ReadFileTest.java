package tests;
import java.io.Serializable;
import java.util.Locale;
import java.util.Scanner;

import business.FileHandler;
import utils.HandleError;

public class ReadFileTest implements Serializable {
	private static final long serialVersionUID = 1L;

	public ReadFileTest() {}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in).useLocale(Locale.US);) {
			System.out.print(
					"Digite o caminho para o arquivo que você deseja ler..." + "\n\n" + 
					"Exemplos de formatos a ser seguidos: " + "\n" + 
					"/home/pedro/file.txt" + "\n" + 
					"C:\\Users\\pedro" + "\n\n" + 
					"Digite o nome do arquivo: "
			);
			String path = sc.next();
			
			FileHandler fileHandler = new FileHandler();
			
			fileHandler.read(path);
		} catch (Exception e) {
			HandleError.handleError(e);
		}
	}

}

package tests;

import java.util.Locale;
import java.util.Scanner;

import business.FileHandler;
import utils.ClearTerminal;
import utils.HandleError;

public class ShowDirectoryInfoTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in).useLocale(Locale.US);) {
			System.out.print(
					"Digite o caminho para a pasta que você deseja ver informações..." + "\n\n" + 
							"Exemplos de formatos a ser seguidos: " + "\n" + 
							"/home/pedro" + "\n" + 
							"C:\\Users\\pedro" + "\n\n" + 
							"Digite o caminho para a pasta: "
					);
			String path = sc.next();
			ClearTerminal.clearTerminal();
			FileHandler.showDirectoryInfo(path);
		} catch (Exception e) {
			HandleError.handleError(e);
		}
	}
}

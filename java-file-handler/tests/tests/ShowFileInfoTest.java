package tests;

import java.util.Locale;
import java.util.Scanner;

import business.FileHandler;
import utils.HandleError;

public class ShowFileInfoTest {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in).useLocale(Locale.US);) {
			System.out.print(
					"Digite o caminho para o arquivo que você deseja ver informações..." + "\n\n" + 
							"Exemplos de formatos a ser seguidos: " + "\n" + 
							"/home/pedro/file.txt" + "\n" + 
							"C:\\Users\\pedro\\file.txt" + "\n\n" + 
							"Digite o nome do arquivo: "
					);
			String path = sc.next();
			FileHandler.showFileInfo(path);
		} catch (Exception e) {
			HandleError.handleError(e);
		}
	}
}
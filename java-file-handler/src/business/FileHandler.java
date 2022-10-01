package business;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import utils.HandleError;

public class FileHandler implements Serializable {
	private static final long serialVersionUID = 1L;

	public FileHandler() {}
	
	public void write(String fileName, String path, List<String> content) {
		try (PrintWriter print = new PrintWriter(new FileWriter(path))) {
			for(String row: content) {
				print.println(row);
			}
			
			System.out.println("O arquivo " + fileName + " foi salvo em " + path);
		} catch (IOException e) {
			HandleError.handleError(e);
		}
	}
	
	public void read(String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
		
			String linha = reader.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = reader.readLine();
			}
		} catch (IOException e) {
			HandleError.handleError(e);
		}
	}
	
	// mostrar informações sobre um arquivo
	// mostrar informações sobre pastas
}

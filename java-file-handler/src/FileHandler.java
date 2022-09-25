import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileHandler {
	public FileHandler() {}
	
	public void write(String fileName, String path, List<String> content) {
		try (PrintWriter print = new PrintWriter(new FileWriter(path))) {
			for(String row: content) {
				print.println(row);
			}
			
			System.out.println("O arquivo " + fileName + " foi salvo em " + path);
		} catch (IOException e) {
			handleError(e);
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
			handleError(e);
		}
	}
	
	public void handleError(Exception e) {
		System.err.println("ERRO: " + e.getMessage());
		e.printStackTrace();
	}
}

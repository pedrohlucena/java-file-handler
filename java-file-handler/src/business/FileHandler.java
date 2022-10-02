package business;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import exceptions.FileDoesNotExistsException;
import exceptions.FolderDoesNotExistsException;
import exceptions.IsADirectoryException;
import exceptions.IsAFileException;
import utils.HandleError;

public class FileHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static void write(String fileName, String path, List<String> content) {
		try (PrintWriter print = new PrintWriter(new FileWriter(path))) {
			for(String row: content) {
				print.println(row);
			}
			
			System.out.println("O arquivo " + fileName + " foi salvo em " + path);
		} catch (IOException e) {
			HandleError.handleError(e);
		}
	}
	
	public static void read(String path) {
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
	
	public static void showFileInfo(String path) {
		File file = new File(path);
		try {
			if(!file.exists()) { throw new FileDoesNotExistsException("O arquivo informado não existe!"); }
			if(file.isDirectory()) { throw new IsADirectoryException("O path informado é de uma pasta e não de um arquivo."); }
		
			String message = (
					file.getName() + "\n" +
					file.getPath() + "\n" +
					"O arquivo pode ser lido? " + file.canRead() + "\n" +
					"O arquivo pode ser gravado? " + file.canWrite() + "\n" +
					"Tamanho do arquivo: " + file.length()
			)
					.replace("true", "Sim")
					.replace("false", "Não");
			
			System.out.print(message);
		} catch (FileDoesNotExistsException e) {
			HandleError.handleError(e);
		} catch (IsADirectoryException e) {
			HandleError.handleError(e);
		} catch (Exception e) {
			HandleError.handleError(e);
		}
	}
	
	public static void showDirectoryInfo(String path) {
		File dir = new File(path);
		try {
			if(!dir.exists()) { throw new FolderDoesNotExistsException("A pasta informada não existe!"); }
			if(dir.isFile()) { throw new IsAFileException("O path informado é de um arquivo e não de uma pasta."); }
		
			File[] listOfFiles = dir.listFiles();
			
			String message = (
					dir.getName() + "\n" +
					dir.getPath() + "\n" +
					"Quantidade de arquivos na pasta: " + dir.list().length + "\n" +
					"Conteúdo do diretório: "
			);
			
			for (int i = 0; i < listOfFiles.length; i++) {
				message += "\n- " + listOfFiles[i].getName();
			}
			
			System.out.print(message);
		} catch (Exception e) {
			HandleError.handleError(e);
		}
	}
	
	// criar arquivo
	// criar pasta
}

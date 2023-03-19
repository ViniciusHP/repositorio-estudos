package br.com.cod3r.composite.folders;

import br.com.cod3r.composite.folders.model.Arquivo;
import br.com.cod3r.composite.folders.model.FileSystemItem;
import br.com.cod3r.composite.folders.model.Pasta;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

	public static void main(String[] args) {

		Arquivo f = new Arquivo("file.txt");
		Arquivo f1 = new Arquivo("file_1.txt");
		Arquivo f2 = new Arquivo("file_2.txt");
		Arquivo f3 = new Arquivo("file_3.txt");
		Arquivo f4 = new Arquivo("file_4.txt");

		Pasta folder_2 = new Pasta("folder_2", f);
		Pasta folder_3 = new Pasta("folder_4", f3);
		Pasta folder_4 = new Pasta("folder_3", f1, f2, folder_3);
		Pasta folder = new Pasta("folder", folder_2, folder_4, f4);

		folder.print("");

		System.out.println();

		String dir = System.getProperty("user.dir");
		FileSystemItem compositeFromFile = createCompositeFromFile(new File(dir));
		compositeFromFile.print(">>>");
	}

	private static FileSystemItem createCompositeFromFile(File file) {
		if(!file.isDirectory()) return new Arquivo(file.getName());
		List<FileSystemItem> children = Arrays.asList(file.listFiles())
				.stream()
				.map((f) -> createCompositeFromFile(f))
				.collect(Collectors.toList());
		return new Pasta(file.getName(), children);
	}
}

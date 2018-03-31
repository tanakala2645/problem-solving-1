package org.ww.testproject.questions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		String path = "file/file.txt";
		try {
			doesFileExist(path);
			Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(path).toURI()));
			list = stream.collect(Collectors.toList());
			for (String line : list) {
				String[] output = line.split("-")[1].split(",");
				System.out.println(line.split("-")[0]);
				Arrays.stream(output).map(String::trim).forEach(System.out::println);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private static void doesFileExist(String path) throws FileNotFoundException {
		if (ClassLoader.getSystemResourceAsStream(path) == null) {
			throw new FileNotFoundException("File not found");
		}
	}

}

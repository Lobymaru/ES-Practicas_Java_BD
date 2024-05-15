package file_curator;

import java.io.*;

public class FileCurator {

	final static File file = new File("src/Files/listado-general.txt");
	
	
	private static Integer sizeForArray(Integer minSize, Integer maxSize) throws IOException{
		if (maxSize == null) {
			maxSize = minSize;
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		String control;
		Integer arraySize = 0;
		while ((control = br.readLine()) != null) {
			if (minSize != maxSize ) {
				if (control.length() >= minSize && control.length() <= maxSize && control.matches("[a-zA-Z]*")) {
					arraySize++;
				}
			}else {
				if (control.length() == minSize) {
					arraySize++;
				}
			}
		}
		br.close();
		System.out.println(arraySize);
		return arraySize;
	}
	
	public static String[] arrayOfWords(Integer arraySize, Integer minSize, Integer maxSize) throws IOException {
		String[] arrayStrings = new String[arraySize];
		BufferedReader br = new BufferedReader(new FileReader(file));
		String word;
		Integer i = 0;
		while ((word = br.readLine()) != null) {
			if (minSize != maxSize ) {
				if (word.length() >= minSize && word.length() <= maxSize && word.matches("[a-zA-Z]*")) {
					arrayStrings[i] = word;
					i++;
				}
			}else {
				if (word.length() == minSize) {
					arrayStrings[i] = word;
					i++;
				}
			}
		}
		br.close();
		return arrayStrings;
	}
	
	public static void createFile(String fileName, String[] wordArray) throws IOException {
		File file = new File("src/Files/"+fileName+".txt");
		if(!file.exists()) {
			file.createNewFile();
			}
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < wordArray.length; i++) {
			outputWriter.write(wordArray[i]);
			outputWriter.newLine();
		}
		outputWriter.flush();
		outputWriter.close();
		System.out.println("File "+ fileName+ " created successfully");
	}
	
	public static void main(String[] args) throws IOException {
		createFile("easy", arrayOfWords(sizeForArray(4,6),4,6));
		createFile("medium", arrayOfWords(sizeForArray(7,9),7,9));
		createFile("hard", arrayOfWords(sizeForArray(10,12),10,12));
		createFile("hardcore", arrayOfWords(sizeForArray(13,18),13,18));
	}

}
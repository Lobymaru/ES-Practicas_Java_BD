package Ahorcado;

import java.io.*;
import java.util.Random;

public class WordSelector {

	private Integer size;
	private String[] wordArray;
	
	public Integer getSize() {
		return size;
	}
	
	private void setSize(Integer number) {
		size = number;
	}
	
	private String[] getWordArray() {
		return wordArray;
	}
	
	private void setWordArray(String[] array) {
		wordArray = array;
	}
	
	public WordSelector(String dificulty) throws IOException {
		this.setSize(calculateSize(dificulty));
		this.setWordArray(createArray(dificulty));
	}
	
	private String[] createArray (String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/Files/"+fileName+".txt"));
		String[] arrayString = new String[this.getSize()];
		String word;
		Integer i = 0;
		while ((word = br.readLine()) != null) {
			arrayString[i] = word;
			i++;
		}
		br.close();
		return arrayString;
	}
	
	@SuppressWarnings("unused")
	private Integer calculateSize(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/Files/"+fileName+".txt"));
		String control;
		Integer sizeCounter = 0;
		while ((control = br.readLine()) != null) {
			sizeCounter++;
		}
		br.close();
		return sizeCounter;
	}
	
	public String getRandomWord() {
		Random rand = new Random();
		String returningWord = this.getWordArray()[rand.nextInt(this.getSize())];		
		return returningWord;
	}
	
}

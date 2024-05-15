package Ahorcado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreboardHandler {
	
	final static int scoreboardSize = 10;
	final static String scoreboardFilePath= "src/Files/Scoreboard.txt";
	final static String[] defaultScoreboard = {
			"Franco@Harcore@1000",
			"Loby@Hardcore@900",
			"Lobymaru@Hard@800",
			"Rashmur@Hard@700",
			"Fedas@Hard@600",
			"Veter@Normal@500",
			"Gosth@Normal@400",
			"Joker@Normal@300",
			"Tsk@Easy@200",
			"Tru@Easy@100"
	};
	
	public int getScoreboardSize () {
		return scoreboardSize;
	}
 	private static void createFile(File file) throws IOException {
		file.createNewFile();
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < defaultScoreboard.length; i++) {
			outputWriter.write(defaultScoreboard[i]);
			outputWriter.newLine();
		}
		outputWriter.flush();
		outputWriter.close();
	}

	private static File getFile() throws IOException {
		File file = new File(scoreboardFilePath);
		if(!file.exists()) {
			createFile(file);
			}
		return file;
	}
	
	public  String[] getScoreboard() throws IOException {
		File file = getFile();
		String[] scoreboard = new String[scoreboardSize];
		BufferedReader br = new BufferedReader(new FileReader(file));
		for (int i = 0; i < scoreboardSize; i++) {
			scoreboard[i] = br.readLine();
		}
		br.close();
		return scoreboard;
	}
	
	public void replaceScoreboard(String[] newScoreboard) throws IOException {
		File file = new File(scoreboardFilePath);
		if(!file.exists()) {
			file.createNewFile();
			}
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < newScoreboard.length; i++) {
			outputWriter.write(newScoreboard[i]);
			outputWriter.newLine();
		}
		outputWriter.flush();
		outputWriter.close();
	}
	
}

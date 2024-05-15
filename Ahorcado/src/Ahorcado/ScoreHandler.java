package Ahorcado;

import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("resource")
public class ScoreHandler {

	private static Integer score;
	private static Integer combo;
	private static Integer multiplier;
	
	public Integer getScore() {
		return score;
	}
	public Integer getCombo() {
		return combo;
	}
	public Integer getMultiplier() {
		return multiplier;
	}
	
	private static void setScore(int number) {
		score = number;
	}
	private static void setCombo(int number) {
		combo = number;
	}
	private static void setMultiplier(int number) {
		multiplier = number;
	}
	
	public void reseteScore(int mult) {
		setScore(0);
		setCombo(1);
		setMultiplier(mult);
	}
	public void increaseScore() {
		setScore(getScore() + (15 * getMultiplier() * getCombo()));
		setCombo(getCombo()+1);
	}
	public void decreaseScore() {
		setScore(getScore() - 7);
		setCombo(1);
	}
	public void checkHiScore(String dificulty) throws IOException {
		//Si el puntaje ingresado es una "alta puntuacion", solicita un nombre String y registra los datos
		int index = newHiScore(getScore());
		if ( index != -1 ) {
			System.out.println("Felicidades! Logro una alta puntiacion! por favor ingrese su nombre para inmortalizarlo: ");
			Scanner scan = new Scanner(System.in); 
			String name = scan.nextLine();
			registerHiScore(name, getScore(), dificulty ,index);
			}
		}
	private static int newHiScore(int score) throws IOException {
		//Devuelve la posision en la que encontro el primer puntaje en la coleccion 
		//que sea menor al puntaje ingresado. Devuelve -1 si no lo encuentra
		ScoreboardHandler scoreHand = new ScoreboardHandler();
		String[] scoreboard = scoreHand.getScoreboard();
		for (int i = 0; i < scoreboard.length; i++) {
			String[] dataScore = scoreboard[i].split("@");
			if (Integer.valueOf(dataScore[2]) < score) {
				return i;
			}
		}
		return -1;
	}
	private static void registerHiScore(String newName, int newScore, String dificultyName, int position ) throws IOException {
		//Registra una puntuacion en el archivo "Scoreboard" con la informacion ingresada
		ScoreboardHandler scoreHand = new ScoreboardHandler();
		String[] scoreboard = scoreHand.getScoreboard();
		String auxHolder = newName+"@"+dificultyName+"@"+newScore, auxMidleStep;
		for (int i = position; i < scoreboard.length; i++) {
			auxMidleStep = scoreboard[i];
			scoreboard[i] = auxHolder;
			auxHolder = auxMidleStep;
		}
		scoreHand.replaceScoreboard(scoreboard);
	}

}

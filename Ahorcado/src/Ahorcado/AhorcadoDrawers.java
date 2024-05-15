package Ahorcado;

import java.io.IOException;

public class AhorcadoDrawers {
	
	final static int whiteSpace = 40; 

	public void clearScreen() {
 	    try {
 	        if (System.getProperty("os.name").contains("Windows")) {
 	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
 	        }
 	        else {
 	            System.out.print("\033\143");
 	        }
 	    } catch (IOException | InterruptedException ex) {}
 	}
	
	public void drawDificultyList() {
		System.out.println("Por favor elija una dificultad : \n"
				+ "1: Easy \n"
				+ "2: Medium \n"
				+ "3: Hard \n"
				+ "4: Hardcore");
	}
	
	private static void drawGallow(int lifes, int score) {
		switch(lifes) {
			case 0:
				System.out.println(
						    " _____  \n"
						  + "   |     |     Score:" + score+ "\n"
						  + "   |     O     Lifes:" + lifes + "\n"
						  + "   |    /|\\\n"
						  + "   |     | \n"
						  + "   |    / \\\n"
						  + "   |       \n"
						  + "___|___    \n");
				break;
			case 1:
				System.out.println(
					    " _____  \n"
					  + "   |     |     Score:" + score+ "\n"
					  + "   |     O     Lifes:" + lifes + "\n"
					  + "   |    /|\\\n"
					  + "   |     | \n"
					  + "   |      \\\n"
					  + "   |       \n"
					  + "___|___    \n");
				break;
			case 2:
				System.out.println(
					    " _____  \n"
					  + "   |     |     Score:" + score+ "\n"
					  + "   |     O     Lifes:" + lifes + "\n"
					  + "   |    /|\\\n"
					  + "   |     | \n"
					  + "   |       \n"
					  + "   |       \n"
					  + "___|___    \n");
				break;
			case 3:
				System.out.println(
					    " _____  \n"
					  + "   |     |     Score:" + score+ "\n"
					  + "   |     O     Lifes:" + lifes + "\n"
					  + "   |     |\\\n"
					  + "   |     | \n"
					  + "   |       \n"
					  + "   |       \n"
					  + "___|___    ");
				break;
			case 4:
				System.out.println(
					    " _____  \n"
					  + "   |     |     Score:" + score+ "\n"
					  + "   |     O     Lifes:" + lifes + "\n"
					  + "   |     | \n"
					  + "   |     | \n"
					  + "   |       \n"
					  + "   |       \n"
					  + "___|___    \n");
				break;
			case 5:
				System.out.println(
					    " _____  \n"
					  + "   |     |     Score:" + score+ "\n"
					  + "   |     O     Lifes:" + lifes + "\n"
					  + "   |       \n"
					  + "   |       \n"
					  + "   |       \n"
					  + "   |       \n"
					  + "___|___    \n");
				break;
			default:
				System.out.println(
					    " _____  \n"
					  + "   |     |     Score:" + score+ "\n"
					  + "   |           Lifes:" + lifes + "\n"
					  + "   |       \n"
					  + "   |       \n"
					  + "   |       \n"
					  + "   |       \n"
					  + "___|___    \n");
		}
	}
	
	private static void drawCharactersInBox(int from, char[] guessedChars) {
		System.out.print("|");
		for (int i=from; i<(from+8); i++) {
			int chara =guessedChars[i] ;
			if (chara >= 65 && chara <=90 ) {
				System.out.print(guessedChars[i]);
			}else {
				System.out.print(" ");
			}
		}
		System.out.print("|\n");
	}
	
	private static void drawBlankSpace() {
		for (int i = 0; i < whiteSpace; i++) {
			System.out.print(" ");
		}
	}
	
	private static void drawIncompleteWord(char[] selectedWord, char[] incompleteWord) {
		int start = (int)((whiteSpace-selectedWord.length)/2);
		for (int i = 0; i < whiteSpace; i++) {
			if ( i >= start & i < start+incompleteWord.length ) {
				System.out.print(incompleteWord[i-start]);
			}else {
				System.out.print(" ");
			}
		}
		
	}

	private static void drawGuessedChars(char[] guessedChars, char[] selectedWord, char[] incompleteWord) {
		drawBlankSpace();
		System.out.print(" ________\n");
		drawBlankSpace();
		drawCharactersInBox(0, guessedChars);
		drawIncompleteWord(selectedWord, incompleteWord);
		drawCharactersInBox(8, guessedChars);
		drawBlankSpace();
		drawCharactersInBox(16, guessedChars);
		drawBlankSpace();
		System.out.print("|________|\n");
	}
	
	public  void drawNextRound(int lifes, int score, char[] guessedChars, char[] selectedWord,  char[] incompleteWord) {
		clearScreen();
		drawGallow(lifes, score);
		drawGuessedChars(guessedChars, selectedWord, incompleteWord);
	}
	
	public  void drawMainMenu() {
		clearScreen();
		System.out.print("Bienvenido a 'Mi Ahorcadito', por favaor elije una de las siguientes opciones ingresando su valor numerico: \n"
				+ "1_Juego nuevo \n"
				+ "2_Tabla de Puntajes (en construccion) \n"
				+ "3_Salir \n");
	}
	
	public void drawScoreboard() throws IOException {
		ScoreboardHandler scoreHand = new ScoreboardHandler();
		String[] scoreBoard = scoreHand.getScoreboard();
		clearScreen();
		for (int i = 0; i < scoreBoard.length; i++) {
			String[] scoreInfo = scoreBoard[i].split("@");
			System.out.println((i+1) +": " + scoreInfo[0] + " " + scoreInfo[2] + " Dificultad: " + scoreInfo[1]);
		}
		System.out.println("\n"
				+ "Presione 'Enter' para continuar");
	}
}

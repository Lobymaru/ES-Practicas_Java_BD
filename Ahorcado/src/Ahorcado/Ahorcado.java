package Ahorcado;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Ahorcado {
	
	//atributos
	private static char[] selectedWord;
	private static char[] incompleteWord;
	private static char[] guessedChars;
	private static Integer lifes;
	private static AhorcadoDrawers drawer = new AhorcadoDrawers();
	private static ScoreHandler score = new ScoreHandler(); 
	
	//getters
	public static Integer getLifes() {
		return lifes;
	}	
	public static char[] getSelectedWord() {
		return selectedWord;
	}
	public static char[] getIncompleteWord() {
		return incompleteWord;
	}
	public static char[] getGuessedChars() {
		return guessedChars;
	}
	public static AhorcadoDrawers getDrawer() {
		return drawer;
	}
	public static ScoreHandler getScoreHand() {
		return score;
	}
	
	//setters
   	private static void setSelectedWord(String word) {
		selectedWord = word.toCharArray();
	}
	private static void setLifes(int number) {
		lifes = number;
	}
	private static void setIncompleteWord(char[] word) {
		incompleteWord = word;
	}
	private static void setGuessedChars(char[] charArray) {
		guessedChars = charArray;
	}
	
	
	private static String randomWord(String dificulty) throws IOException {
		//Devuelve una palabra aleatoria tipo String que toma de una lista de palabras en base a la dificultad ingresada
		WordSelector word =  new WordSelector(dificulty);
		String uppercaseWord = word.getRandomWord().toUpperCase();
		return uppercaseWord;
	}
	
	private static String getDificulty(int number) {
		switch (number) {
			case 1:
				return "Easy";
			case 2:
				return "Medium";
			case 3:
				return "Hard";
			case 4:
				return "Hardcore";
			default:
				return null;
		}
	}
	
 	
	private static void newGame() throws IOException {
		gameStartConfigurationPhase();
		gameStart();
	}

	private static void gameStartConfigurationPhase() throws IOException {
		//Pide al usuario la dificultad con la que jugar y configura el juego en base a esa dificultad
		String YN = "N", dificultyControl;
		Integer dificulty = 0;
		do {
			getDrawer().clearScreen();
			getDrawer().drawDificultyList();
			getDrawer().clearScreen();
			Scanner dificultyScan = new Scanner(System.in);
			Scanner scan = new Scanner(System.in);
			try {										//Controla que lo que se ingrese a continuacion es un numero entero
				dificulty = dificultyScan.nextInt();
				if ((dificultyControl = getDificulty(dificulty)) != null) {
					System.out.println("Su dificultad es '" + dificultyControl + "'. Es esto correcto? (Y/N) ");
					YN = scan.nextLine();
					while (!YN.toUpperCase().equals("N") & !YN.toUpperCase().equals("Y")){
							System.out.println("ERROR: '" + YN +"' no es una opcion valida, por favor ingrese (Y/N)");
							YN = scan.nextLine();
						}
				}else {
					System.out.println("'"+dificulty+"' no es una opcion valida");
				}
			} catch (Exception e) {
				System.out.println("ERROR: El valor ingresado no es apropiado, por favor ingrese un numero entre 1 y 4");
			}
		}while(!YN.toUpperCase().equals("Y"));
		configureGame(dificulty);
	}
	private static void configureGame(int dificulty) throws IOException {
		//Ingresa los valores correspondientes para iniciar el juego en base a la dificultad ingresada
		getScoreHand().reseteScore(dificulty);
		setSelectedWord(randomWord(getDificulty(dificulty)));
		setLifes(6);
		setGuessedChars(new char[27]);
		char[] underScore = new char[getSelectedWord().length];
		Arrays.fill(underScore, '_');
		setIncompleteWord(underScore);
	}

	private static void gameStart() throws IOException { 
		//Pide una letra al usuario hasta que la palabra sea adivinada o las vidas lleguen a 0
		//Luego envia el puntaje final para revisar si debe ser guardado
		Scanner scan = new Scanner(System.in);
			char selectedCharacter;
			while (!Arrays.equals(getIncompleteWord(), getSelectedWord()) && getLifes() != 0 ) {    //Mientras el juego no finalice
					getDrawer().drawNextRound(getLifes(), getScoreHand().getScore(), getGuessedChars(), getSelectedWord(), getIncompleteWord());
					System.out.println("Ingrese la siguiente letra");
					selectedCharacter = scan.next().charAt(0);
					while (Character.toUpperCase(selectedCharacter) < 'A' || Character.toUpperCase(selectedCharacter) > 'Z') {
						System.out.println("ERROR: Solo se admiten caracteres de la 'A' a la 'Z' \n"
								+ "Por favor ingrese nuevamente una letra: ");
						selectedCharacter = scan.next().charAt(0);
					}
					processPlayerInput(Character.toUpperCase(selectedCharacter));
			}
			getDrawer().drawNextRound(getLifes(), getScoreHand().getScore(), getGuessedChars(), getSelectedWord(), getIncompleteWord());
			if (getLifes() == 0) {
				System.out.println("FIN DEL JUEGO!\n"
						+ "La palabra era: " + new String(getSelectedWord()));
			}else {
				System.out.println("ADIVINO!!! USTED GANA!");
			}
			System.out.println("Su puntaje final es de: " + getScoreHand().getScore());
			getScoreHand().checkHiScore(getDificulty(getScoreHand().getMultiplier()));
			System.out.println("Gracias por jugar!\n"
					+ "Presione 'Enter' para continuar");
			scan.nextLine();
		}
 	private static void processPlayerInput (Character selectedChar) {
		Boolean found = false;
		char[] auxChar = getIncompleteWord();
		for(int i=0; i<getSelectedWord().length;i++) {
			if ( getSelectedWord()[i] == selectedChar ) {
				auxChar[i] = selectedChar;
				found = true;
			}
		}
		for (int i = 0; i < getGuessedChars().length; i++) {
			if (getGuessedChars()[i] == selectedChar) {
				break;
			}
			if (getGuessedChars()[i] == 0) {
				char[] charAux = getGuessedChars();
				charAux[i] = selectedChar;
				setGuessedChars(charAux);
				break;
			}
		}
		if (found == true) {
			setIncompleteWord(auxChar);
			getScoreHand().increaseScore();
		}else {
			int aux = getLifes()-1;
			setLifes(aux);
			getScoreHand().decreaseScore();
		}
		
	}
	
	private static void showScoreboard() throws IOException {
		getDrawer().drawScoreboard();
		try (Scanner scan = new Scanner(System.in)) {
			scan.next();
		}
	}
	
 	public static void main(String[] args) throws IOException {
 		//El menú principal. Solicita una entrada numerica al usuario para acceder a las funciones del programa
		while(true) {
			getDrawer().drawMainMenu();
			Scanner scan = new Scanner(System.in);           
			int option = scan.nextInt();				 
			switch(option) {									
				case 1:
					newGame();
					break;
				case 2:
					showScoreboard();
					break;
				case 3:
					System.out.println("Adios! Gracias por jugar!");
					System.exit(0);
					break;
				default:
			}
		}
	}
}
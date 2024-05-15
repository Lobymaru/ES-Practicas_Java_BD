package branchManager;

import java.io.IOException;
import java.util.Scanner;

import conexion.Conexion;

public class MenuManager {

	private static Drawer draw = new Drawer();
	private static QueryHandler queryHandler = new QueryHandler();
	
	public static void mainMenu() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		draw.mainMenu();
		int option = scan.nextInt();
		switch (option) {
		case 1:
			anomaliasMenu();
			break;
		case 2:
			empleadosMenu();
			break;
		case 3:
			reportesMenu();
			break;
		case 4:
			asignacionesMenu();
			break;
		case 5:
			draw.mensajeFinal();
			scan.nextLine();
			System.exit(0);
			break;
		default:
			draw.opcionIncorrecta();
			scan.nextLine();
			mainMenu();
		}
	}
	
	public static void anomaliasMenu() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		draw.anomaliasMenu();
		int option = scan.nextInt();
		switch(option) {
			case 1:
				queryHandler.verListaCompletaSCP("1");
				anomaliasMenu();
				break;
			case 2:
				queryHandler.inputRegistroSCP();
				anomaliasMenu();
				break;
			case 3:
				queryHandler.editarRegistroSCP();
				anomaliasMenu();
				break;
			case 4:
				queryHandler.eliminarRegistroSCP();
				anomaliasMenu();
				break;
			case 5:
				mainMenu();
				break;
			default:
				draw.opcionIncorrecta();
				scan.nextLine();
				anomaliasMenu();
		}
	}
	
	public static void empleadosMenu() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		draw.empleadosMenu();
		int option = scan.nextInt();
		switch(option) {
			case 1:
				queryHandler.verListaCompletaEmpleado("1");
				empleadosMenu();
				break;
			case 2:
				queryHandler.inputRegistroEmpleado();
				empleadosMenu();
				break;
			case 3:
				queryHandler.editarRegistroEmpleado();
				empleadosMenu();
				break;
			case 4:
				queryHandler.asignarSuperior();
				empleadosMenu();
				break;
			case 5:
				queryHandler.eliminarRegistroEmpleado();
				empleadosMenu();
				break;
			case 6:
				mainMenu();
				break;
			default:
				draw.opcionIncorrecta();
				scan.nextLine();
				empleadosMenu();
		}
	}
	
	public static void asignacionesMenu() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		draw.asignacionesMenu();
		int option = scan.nextInt();
		switch(option) {
			case 1:
				queryHandler.verAsignaciones();
				asignacionesMenu();
				break;
			case 2:
				queryHandler.asignarAnomalia();
				asignacionesMenu();
				break;
			case 3:
				queryHandler.eliminarAsignacion();
				asignacionesMenu();
				break;
			case 4:
				mainMenu();
				break;
			default:
				draw.opcionIncorrecta();
				scan.hasNextLine();
				anomaliasMenu();
		}
	}
	
	public static void reportesMenu() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		draw.reportesMenu();
		int option = scan.nextInt();
		switch(option) {
			case 1:
				queryHandler.verReporte();
				reportesMenu();
				break;
			case 2:
				queryHandler.inputReporte();
				reportesMenu();
				break;
			case 3:
				queryHandler.eliminarReporte();
				reportesMenu();
				break;
			case 4:
				mainMenu();
				break;
			default:
				draw.opcionIncorrecta();
				scan.nextLine();
				reportesMenu();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		mainMenu();
	}
	
}

package branchManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import conexion.Conexion;

public class Employee {

	private static Drawer draw = new Drawer();
	
	private static int id;
	private static String nombre;
	private static String apellido;
	private static String clase;
	private static String nivelSeguridad;
	private static void setId(int id) {
		Employee.id = id;
	}
	private static void setNombre(String nombre) {
		Employee.nombre = nombre;
	}
	private static void setApellido(String apellido) {
		Employee.apellido = apellido;
	}
	private static void setClase(String clase) {
		Employee.clase = clase;
	}
	private static void setNivelSeguridad(String nivelSeguridad) {
		Employee.nivelSeguridad = nivelSeguridad;
	}
	public static int getId() {
		return id;
	}
	public static String getNombre() {
		return nombre;
	}
	public static String getApellido() {
		return apellido;
	}
	public static String getClase() {
		return clase;
	}
	public static String getNivelSeguridad() {
		return nivelSeguridad;
	}

	public Employee() {
		Scanner scanLine = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		
		System.out.print("Ingrese el codigo del nuevo empleado: \n" );
		this.setId(scanInt.nextInt());
		
		System.out.print("Ingrese el nombre para el empleado " + this.getId() + ": \n" );
		this.setNombre(scanLine.nextLine());
		
		System.out.print("Ingrese el apellido para el empleado " + this.getId() + ": \n" );
		this.setApellido(scanLine.nextLine());
		
		int claseElegida = 0;
		String clase = "";
		while (claseElegida <1 || claseElegida >7) {
			draw.seleccionClaseEmpleado(this.getId());
			claseElegida = scanInt.nextInt();
			switch(claseElegida){
				case 1:
					clase = "A";
					break;
				case 2:
					clase = "B";
					break;
				case 3:
					clase = "C";
					break;
				case 4:
					clase = "D";
					break;
				case 5:
					clase = "E";
					break;
				default:
					draw.opcionIncorrecta();
			}
		}
		this.setClase(clase);
		
		int nivelSeguridadElegido = 0;
		while (nivelSeguridadElegido <1 || nivelSeguridadElegido >5) {
			draw.seleccionNivelSeguridadEmpleado(this.getId());
			nivelSeguridadElegido = scanInt.nextInt();
			if (nivelSeguridadElegido <1 || nivelSeguridadElegido >5 ) {
					draw.opcionIncorrecta();
			}
		}
		this.setNivelSeguridad(Integer.toString(nivelSeguridadElegido));
	}

	public Employee(int idEmpleado) {
		Conexion conexion = new Conexion();	
		String query = "SELECT * FROM `employee` WHERE Id = " + Integer.toString(idEmpleado) + "";
		Scanner scanLine = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			resultado.first();
			this.setId(idEmpleado);
			
			System.out.print("\n"
					+ "-Nombre-  \n"
					+ "Actual: " + resultado.getString("Nombre") + "  (Presione ENTER para omitir) \n"
					+ "Nuevo: ");
			
			String nombre = scanLine.nextLine();
			if (nombre.replaceAll("\\s+", "").isEmpty() ) {
				nombre = resultado.getString("Nombre");
			}
			
			this.setNombre(nombre);
			
			System.out.print("\n"
					+ "-Apellido-  \n"
					+ "Actual: " + resultado.getString("Apellido") + "  (Presione ENTER para omitir) \n"
					+ "Nuevo: ");
			
			String apellido = scanLine.nextLine();
			if (apellido.replaceAll("\\s+", "").isEmpty() ) {
				apellido = resultado.getString("Apellido");
			}
			
			this.setApellido(apellido);
			
			System.out.println("\n"
					+ "-Clase- \n"
					+ "Actual: " + resultado.getString("Clase") + " (Presione ENTER para omitir) \n"
					+ "Nueva:");
			
			String claseElegida = "0";
			String clase = "";
			Boolean exit = false;
			while ((!exit && !claseElegida.replaceAll("\\s+", "").isEmpty()) && (Integer.parseInt(claseElegida) <1 || Integer.parseInt(claseElegida) >7)) {
				draw.seleccionClaseEmpleado(resultado.getInt("Id"));
				claseElegida = scanLine.nextLine();
				if (claseElegida.replaceAll("\\s+", "").isEmpty() ) {
					exit = true;
					clase = (resultado.getString("Clase"));
				} 
				else{
					switch(Integer.parseInt(claseElegida)){
						case 1:
							clase = "A";
							break;
						case 2:
							clase = "B";
							break;
						case 3:
							clase = "C";
							break;
						case 4:
							clase = "D";
							break;
						case 5:
							clase = "E";
							break;
						default:
							draw.opcionIncorrecta();
					}
				}
			}
			
			this.setClase(clase);
			
			System.out.println("\n"
					+ "-Nivel de Seguridad- \n"
					+ "Actual: " + resultado.getString("Nivel_Seguridad") + " (Presione ENTER para omitir) \n"
					+ "Nueva:");
			
			String nivelSeguridadElegido = scanLine.nextLine();
			if (nivelSeguridadElegido.replaceAll("\\s+", "").isEmpty() ) {
				nivelSeguridadElegido = resultado.getString("Nivel_Seguridad");
			}else {
				while (Integer.valueOf(nivelSeguridadElegido) <1 || Integer.valueOf(nivelSeguridadElegido) >5) {
					draw.seleccionNivelSeguridadEmpleado(this.getId());
					nivelSeguridadElegido = scanLine.nextLine();
					if (Integer.valueOf(nivelSeguridadElegido) <1 || Integer.valueOf(nivelSeguridadElegido) >5 ) {
							draw.opcionIncorrecta();
					}
				}
			}
			this.setNivelSeguridad(nivelSeguridadElegido);

			
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}

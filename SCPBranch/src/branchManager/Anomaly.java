package branchManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

import conexion.Conexion;

public class Anomaly {
	
	private static Drawer draw = new Drawer();
	
	private static int id;
	private static String apodo;
	private static String clase;
	private static String subclase;
	private static String descripcion;
	private static String contencion;
	
	public static int getId() {
		return id;
	}
	public static String getApodo() {
		return apodo;
	}
	public static String getClase() {
		return clase;
	}
	public static String getSubclase() {
		return subclase;
	}
	public static String getDescripcion() {
		return descripcion;
	}
	public static String getContencion() {
		return contencion;
	}
	
	private static void setId(int id) {
		Anomaly.id = id;
	}
	private static void setApodo(String apodo) {
		Anomaly.apodo = apodo;
	}
	private static void setClase(String clase) {
		Anomaly.clase = clase;
	}
	private static void setSubclase(String subclase) {
		Anomaly.subclase = subclase;
	}
	private static void setDescripcion(String descripcion) {
		Anomaly.descripcion = descripcion;
	}
	private static void setContencion(String contencion) {
		Anomaly.contencion = contencion;
	}
	
	public Anomaly (int idSCP) {
		
		Conexion conexion = new Conexion();	
		String query = "SELECT * FROM `scp` WHERE Id = " + Integer.toString(idSCP) + "";
		Scanner scanInt = new Scanner(System.in);
		Scanner scanLine = new Scanner(System.in);
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			resultado.first();
			this.setId(idSCP);
			
			System.out.print("\n"
					+ "-Apodo-  \n"
					+ "Actual: " + resultado.getString("Apodo") + "  (Presione ENTER para omitir) \n"
					+ "Nuevo: ");
			
			String apodo = scanLine.nextLine();
			if (apodo.replaceAll("\\s+", "").isEmpty() ) {
				apodo = resultado.getString("Apodo");
			}
			
			this.setApodo(apodo);
			
			System.out.println("\n"
					+ "-Clase- \n"
					+ "Actual: " + resultado.getString("Clase") + " (Presione ENTER para omitir) \n"
					+ "Nueva:");
			
			String claseElegida = "0";
			String clase = "";
			Boolean exit = false;
			while ((!exit && !claseElegida.replaceAll("\\s+", "").isEmpty()) && (Integer.parseInt(claseElegida) <1 || Integer.parseInt(claseElegida) >7)) {
				draw.seleccionClaseSCP(resultado.getInt("Id"));
				claseElegida = scanLine.nextLine();
				if (claseElegida.replaceAll("\\s+", "").isEmpty() ) {
					exit = true;
					clase = (resultado.getString("Clase"));
				} 
				else{
					switch(Integer.parseInt(claseElegida)){
						case 1:
							clase = "Seguro";
							break;
						case 2:
							clase = "Euclid";
							break;
						case 3:
							clase = "Keter";
							break;
						case 4:
							clase = "Taumiel";
							break;
						case 5:
							clase = "Neutralizado";
							break;
						case 6:
							clase = "Apollyon";
							break;
						case 7:
							clase = "Archon";
							break;
						default:
							draw.opcionIncorrecta();
					}
				}
			}
			
			this.setClase(clase);
			
			System.out.println("\n"
					+ "-Subclase- \n"
					+ "Actual: " + resultado.getString("Subclase") + " (Presione ENTER para omitir) \n"
					+ "Nueva:");
			
			String subClaseElegida = "0";
			String subClase = "";
			exit = false;
			while ((!exit && !subClaseElegida.replaceAll("\\s+", "").isEmpty()) && (Integer.parseInt(subClaseElegida) <1 || Integer.parseInt(subClaseElegida) >3)) {
				draw.seleccionSubClaseSCP(resultado.getInt("Id"));
				subClaseElegida = scanLine.nextLine();
				if (claseElegida.replaceAll("\\s+", "").equals("") ) {
					exit = true;
					subClase = (resultado.getString("Subclase"));
				}else {
					switch(Integer.parseInt(subClaseElegida)) {
						case 1:
							subClase = "Explicado";
							break;
						case 2:
							subClase = "Esoterico";
							break;
						case 3:
							subClase = "Desmantelado";
							break;
						default:
							draw.opcionIncorrecta();
					}
				}
			}
			
			this.setSubclase(subClase);
			
			System.out.println("\n"
					+ "-Descripcion- \n"
					+ "Actual:\n" + resultado.getString("Descripcion") + "\n(Presione ENTER para omitir) \n"
					+ "Nueva:");
			String descripcion = scanLine.nextLine();
			if (descripcion.replaceAll("\\s+", "").equals("") ) {
				this.setDescripcion(resultado.getString("Descripcion"));
			}else {
				this.setDescripcion(descripcion);
			}
			
			
			System.out.println("\n"
					+ "-Instruciones de contencion- \n"
					+ "Actual:\n" + resultado.getString("Instrucciones-contencion") + "\n(Presione ENTER para omitir) \n"
					+ "Nueva:");
			String instruccionesContencion = scanLine.nextLine();	
			if (instruccionesContencion.replaceAll("\\s+", "").equals("") ) {
				this.setDescripcion(resultado.getString("Instrucciones-contencion"));
			}else {
				this.setContencion(instruccionesContencion);
			}
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	public Anomaly() {
		
		Scanner scanInt = new Scanner(System.in);
		Scanner scanLine = new Scanner(System.in);
		System.out.print("Ingrese el codigo del SCP: \n" );
		this.setId(scanInt.nextInt());
		
		System.out.print("Ingrese el apodo del SCP-" + this.getId() + ": \n" );
		String apodo = scanLine.nextLine();
		
		
		int claseElegida = 0;
		String clase = "";
		while (claseElegida <1 || claseElegida >7) {
			draw.seleccionClaseSCP(this.getId());
			claseElegida = scanInt.nextInt();
			switch(claseElegida){
				case 1:
					clase = "Seguro";
					break;
				case 2:
					clase = "Euclid";
					break;
				case 3:
					clase = "Keter";
					break;
				case 4:
					clase = "Taumiel";
					break;
				case 5:
					clase = "Neutralizado";
					break;
				case 6:
					clase = "Apollyon";
					break;
				case 7:
					clase = "Archon";
					break;
				default:
					draw.opcionIncorrecta();
			}
		}
		this.setClase(clase);
		
		int subClaseElegida = 0;
		String subClase = "";
		while (subClaseElegida <1 || subClaseElegida >3) {
			draw.seleccionSubClaseSCP(this.getId());
			subClaseElegida = scanInt.nextInt();
			switch(subClaseElegida) {
				case 1:
					subClase = "Explicado";
					break;
				case 2:
					subClase = "Esoterico";
					break;
				case 3:
					subClase = "Desmantelado";
					break;
				default:
					draw.opcionIncorrecta();
			}
		}
		this.setSubclase(subClase);
		
		System.out.print("Ingrese la descripcion del SCP-" + this.getId() + ": \n");
		this.setDescripcion(scanLine.nextLine());
		
		System.out.print("Ingrese las instrucciones de contencion del SCP-" + this.getId() + ": \n");
		this.setContencion(scanLine.nextLine());	
	}
}

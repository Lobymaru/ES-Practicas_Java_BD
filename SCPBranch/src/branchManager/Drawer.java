package branchManager;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class Drawer {
	
	public void seleccionClaseSCP(int codigo) {
		System.out.println("Seleccione la clase del SCP-"+codigo+": \n"
				+ "1_Seguro \n"
				+ "2_Euclid \n"
				+ "3_Keter \n"
				+ "4_Taumiel \n"
				+ "5_Neutralizado \n"
				+ "6_Apollyon \n"
				+ "7_Archon");
	}
	
	public void seleccionSubClaseSCP(int codigo) {
		System.out.println("Seleccione la sub clase del SCP-"+codigo+": \n"
				+ "1_Explicado \n"
				+ "2_Esoterico \n"
				+ "3_Desmantelado");
	}
	
	public void seleccionClaseEmpleado(int codigo) {
		System.out.println("Seleccione la clase para el empleado "+codigo+": \n"
				+ "1_A \n"
				+ "2_B \n"
				+ "3_C \n"
				+ "4_D \n"
				+ "5_E \n");
	}
	
	public void seleccionNivelSeguridadEmpleado(int codigo) {
		System.out.println("Ingrese el nivel de seguridad para el empleado "+codigo+" \n"
				+ "Siendo 1 el mas bajo y 5 el mas alto");
	}
	
	public void opcionIncorrecta() {
		System.out.println("La opcion elegida no es correcta \n"
				+ "presione ENTER para continuar");
	}
	
	public void presioneEnter() {
		System.out.println("\n"
				+ "presione ENTER para regresar al menu anterior");
	}
	
	
	// ------------------Menus-----------------------
	
	public void mainMenu() {
		System.out.println();
		System.out.println("Menu principal \n"
				+ "Ingrese una de las siguientes opciones: \n \n"
				+ "1) Anomalias \n"
				+ "2) Empleados \n"
				+ "3) Reportes \n"
				+ "4) Asignaciones \n"
				+ "5) Salir");
	}
	
	public void anomaliasMenu() {
		System.out.println();
		System.out.println("Menu Anomalias \n"
				+ "Ingrese una de las siguientes opciones: \n \n"
				+ "1) Ver anomalias \n"
				+ "2) Ingresar nueva anomalia \n"
				+ "3) Editar anomalia existente \n"
				+ "4) Borrar anomalia \n"
				+ "5) Regresar al menu principal");		
	}
	
	public void empleadosMenu() {
		System.out.println();
		System.out.println("Menu registro de empleados \n"
				+ "Ingrese una de las siguientes opciones: \n \n"
				+ "1) Ver empleados \n"
				+ "2) Ingresar nuevo empleado \n"
				+ "3) Editar datos de empleado existente \n"
				+ "4) Asignar superior \n"
				+ "5) Borrar registro de empleado \n"
				+ "6) Regresar al menu principal");		
	}
	
	public void reportesMenu() {
		System.out.println();
		System.out.println("Menu Reportes \n"
				+ "Ingrese una de las siguientes opciones: \n \n"
				+ "1) Ver reporte \n"
				+ "2) Redactar nuevo reporte \n"
				+ "3) Eliminar reporte \n"
				+ "4) Regresar al menu principal");		
	}
	
	public void asignacionesMenu() {
		System.out.println();
		System.out.println("Menu Asignaciones \n"
				+ "Ingrese una de las siguientes opciones:  \n \n"
				+ "1)Ver lista de asignaciones \n"
				+ "2)Asignar empleado a anomalia \n"
				+ "3)Eliminar asignacion \n"
				+ "4)Regresar al menu principal");
	}
	
	//---------------Listas y encabezados--------------

	/*  Soy conciente de que hay longitudesd que estan "hardcodeadas" y son malas practicas por cuestiones de mantenibilidad */
	
	public void imprimirEncabezadoListaEmpleados() {
		System.out.println();
		System.out.println("       |       Nombre       |      Apellido      | Clase | Nivel de Seguridad |                 Superior                 | \n"
				+ "--------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void imprimirEncabezadoListaSCP() {
		System.out.println();
		System.out.println("          |        Apodo       |     Clase    |   Subclase   | \n"
				+ "--------------------------------------------------------------");
	}
	
	public void imprimirEncabezadoListaAsignaciones() {
		System.out.println("                       Empleado                       |               SCP               | \n"
				         + "------------------------------------------------------|---------------------------------|");
	}
	
	public void imprimirSiguienteSCP(int id, String apodo, String clase, String subclase) {
		String aImprimir = "";
		String scpId="SCP-" + Integer.toString(id);
		for (int i = 0; i < Math.round( ( 10 - scpId.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += scpId;
		for (int i = 0; i < Math.round( ( 10 - scpId.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		for (int i = 0; i < Math.round( ( 21 - apodo.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += apodo;
		for (int i = 0; i < Math.round( ( 20 - apodo.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		for (int i = 0; i < Math.round( ( 15 - clase.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += clase;
		for (int i = 0; i < Math.round( ( 14 - clase.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		for (int i = 0; i < Math.round( ( 15 - subclase.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += subclase;
		for (int i = 0; i < Math.round( ( 14 - subclase.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		System.out.println(aImprimir);
	}
	
	public void imprimirSiguienteEmpleado(int id, String nombre, String apellido, String clase, String nivelSeguridad, Integer jefe) {
		String aImprimir = "";
		String scpId=Integer.toString(id);
		for (int i = 0; i < Math.round( ( 8 - scpId.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += scpId;
		for (int i = 0; i < Math.round( ( 7 - scpId.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		for (int i = 0; i < Math.round( ( 21 - nombre.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += nombre;
		for (int i = 0; i < Math.round( ( 20 - nombre.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		for (int i = 0; i < Math.round( ( 21 - apellido.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += apellido;
		for (int i = 0; i < Math.round( ( 20 - apellido.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		for (int i = 0; i < Math.round( ( 8 - clase.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += clase;
		for (int i = 0; i < Math.round( ( 7 - clase.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		for (int i = 0; i < Math.round( ( 21 - nivelSeguridad.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += nivelSeguridad;
		for (int i = 0; i < Math.round( ( 20 - nivelSeguridad.length() ) /2 ); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		
		if (!jefe.equals(null)) {
			for (int i = 0; i < Math.round( ( 43 - Integer.toString(jefe).length()) /2 ); i++) {
				aImprimir += " ";
			}
			aImprimir += jefe;
			for (int i = 0; i < Math.round( ( 42 - Integer.toString(jefe).length()) /2 ); i++) {
				aImprimir += " ";
			}	
		}else { System.out.print("                                        "); }
		
		aImprimir += "|";
		
		System.out.println(aImprimir);
	}
	
	public void imprimirSiguienteSCPReducido(int index, int id, String apodo, String clase) {
		String aImprimir = Integer.toString(index) + ") " + "SCP-" + Integer.toString(id) + " " + apodo + " - Clase: " + clase;
		System.out.println(aImprimir);

	}
	
	public void imprimirSiguienteEmpleadoReducido(int index, int id, String nombre, String apellido) {
		String aImprimir = Integer.toString(index) + ") Id: " + Integer.toString(id) + " - Nombre: " + apellido + " " + nombre;
		System.out.println(aImprimir);
	}

	public void imprimirSiguienteAsignacion(int idSCP, String apodoSCP, int idEmpleado, String nombreEmpleado, String apellidoEmpleado) {
		String aImprimir = "";
		String scp = "SCP-" + Integer.toString(idSCP) + " - "+ apodoSCP;
		String empleado = apellidoEmpleado + " " + nombreEmpleado + " - ID: " + Integer.toString(idEmpleado);
		aImprimir += empleado;
		
		for (int i = 0;i < (54 - empleado.length()); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		aImprimir += scp;
		for (int i = 0;i < (33 - scp.length()); i++) {
			aImprimir += " ";
		}
		aImprimir += "|";
		System.out.println(aImprimir);
	}
	
	public void imprimirEncabezadoReporte(String idReporte, Date fecha) {
		System.out.println("Reporte: " + idReporte);
		System.out.println("Fecha: " + fecha);
	}
	
	public void imprimirIncidente(String incidente) throws InterruptedException {
		System.out.println("Incidente: \n");
		typingString(incidente);
		System.out.println("\n");
	}
	
	public void imprimirResolucion(String resolucion) throws InterruptedException {
		System.out.println("Resolucion: \n");
		typingString(resolucion);
		System.out.println();
	}
	
	public void imprimirReporteReducido(int index, String id, Date fecha) {
		String aImprimir = Integer.toString(index) + ") " + "Reporte : " + id + " - Fecha : " + fecha;
		System.out.println(aImprimir);
	}
	
	//--------------Cierre programa--------------------
	
	public void puntosSuspensivos() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			TimeUnit.SECONDS.sleep(1);
			System.out.print(".");
		}
		TimeUnit.SECONDS.sleep(1);
		System.out.println();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("HECHO \n");
		TimeUnit.SECONDS.sleep(1);
	}
	
	public void typingString(String oracion) throws InterruptedException {
		for (int i = 0; i < oracion.length(); i++) {
			System.out.print(oracion.charAt(i));
			TimeUnit.MILLISECONDS.sleep(50);
		}
	}
	
	public void mensajeFinal() throws InterruptedException {
		System.out.println();
		typingString("Finalizando conexion");
		puntosSuspensivos();

		typingString("Reactivando protocolos de seguridad");
		puntosSuspensivos();
		typingString("Gracias por su continuos servicios con la fundacion SCP \n");
		TimeUnit.SECONDS.sleep(1);
		typingString("Presione ENTER para salir");
	}
}

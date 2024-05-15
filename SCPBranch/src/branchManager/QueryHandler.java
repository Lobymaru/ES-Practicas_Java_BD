package branchManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import conexion.Conexion;

public class QueryHandler {

	Connection con;
	private static Drawer draw = new Drawer();
	
	
	//----------------SCP------------------
	
	
	public static void inputRegistroSCP() {
		Conexion conexion = new Conexion();
		Scanner scp = new Scanner(System.in);
		
		Anomaly anomalia = new Anomaly();
		
		Statement consulta;
		ResultSet resultado;
		String consultaSQL = "INSERT INTO `scp`(`Id`, `Apodo`, `Clase`, `Subclase`, `Descripcion`, `Instrucciones-contencion`) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setInt(1, anomalia.getId());
			consultaPreparada.setString(2, anomalia.getApodo());
			consultaPreparada.setString(3, anomalia.getClase());
			consultaPreparada.setString(4, anomalia.getSubclase());
			consultaPreparada.setString(5, anomalia.getDescripcion());
			consultaPreparada.setString(6, anomalia.getContencion());
			consultaPreparada.execute();
			
			System.out.print("Datos Ingresados Correctamente");
			conexion.con.close();
		} catch (SQLException e) {
				System.err.print(e);
		}
		
	}
	
	public static void editarRegistroSCP() {
		Conexion conexion = new Conexion();
		int idSCP = seleccionAnomalia();
		
		Anomaly anomalia = new Anomaly(idSCP);
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "UPDATE scp SET Apodo = ?, Clase = ?, Subclase = ?, Descripcion = ?, `Instrucciones-contencion` = ? WHERE Id = " + idSCP;
		
		
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setString(1, anomalia.getApodo());
			consultaPreparada.setString(2, anomalia.getClase());
			consultaPreparada.setString(3, anomalia.getSubclase());
			consultaPreparada.setString(4, anomalia.getDescripcion());
			consultaPreparada.setString(5, anomalia.getContencion());
			consultaPreparada.execute();
			
			System.out.print("Datos modificados correctamente");
			conexion.con.close();
		} catch (SQLException e) {
				System.err.print(e);
		}
	}
	
	public static void eliminarRegistroSCP() {
		Conexion conexion = new Conexion();
		int idSCP = seleccionAnomalia();
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "DELETE FROM `scp` WHERE Id =" + idSCP + "";
		
		try {
			PreparedStatement consul = conexion.con.prepareStatement(consultaSQL);
			consul.execute();
			
			System.out.println("La anomalia SCP-" + idSCP + " ha sido borrada exitosamente");
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public static void verListaParcialSCPs(String filter) {
		Conexion conexion = new Conexion();
		String query = "select * from SCP WHERE " + filter +"";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			int i = 0;
			
			while(resultado.next()) {
				i++;
				System.out.println(Integer.toString(i) + ") SCP-" + Integer.toString(resultado.getInt("Id")) + "  Alias: " + resultado.getString("Apodo"));
			}
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		
	}
		
	public static void verListaCompletaSCP(String filter) {
		Conexion conexion = new Conexion();
		String query = "select * from SCP WHERE " + filter +" ORDER BY 'Id' ASC";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			draw.imprimirEncabezadoListaSCP();
			while (resultado.next()) {
				draw.imprimirSiguienteSCP(resultado.getInt("Id"), resultado.getString("Apodo"), resultado.getString("Clase"), resultado.getString("Subclase"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		draw.presioneEnter();
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
	}
	
	
	//---------------EMPLEADOS----------------
	
	public static void inputRegistroEmpleado() {
		Conexion conexion = new Conexion();
		
		Employee empleado = new Employee();
		
		Statement consulta;
		ResultSet resultado;
		String consultaSQL = "INSERT INTO `employee`(`Id`, `Nombre`, `Apellido`, `Clase`, `Nivel_Seguridad`) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setInt(1, empleado.getId());
			consultaPreparada.setString(2, empleado.getNombre());
			consultaPreparada.setString(3, empleado.getApellido());
			consultaPreparada.setString(4, empleado.getClase());
			consultaPreparada.setString(5, empleado.getNivelSeguridad());
			consultaPreparada.execute();
			
			System.out.print("Datos Ingresados Correctamente");
			conexion.con.close();
		} catch (SQLException e) {
				System.err.print(e);
		}
	}
	
	public static void editarRegistroEmpleado() {
		Conexion conexion = new Conexion();
		int idEmpleado = seleccionEmpleado();
		
		Employee empleado = new Employee(idEmpleado);
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "UPDATE employee SET Nombre = ?, Apellido = ?, Clase = ?, `Nivel_Seguridad` = ?  WHERE Id = " + idEmpleado;
		
		
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setString(1, empleado.getNombre());
			consultaPreparada.setString(2, empleado.getApellido());
			consultaPreparada.setString(3, empleado.getClase());
			consultaPreparada.setString(4, empleado.getNivelSeguridad());
			consultaPreparada.execute();
			
			System.out.print("Datos modificados correctamente");
			conexion.con.close();
		} catch (SQLException e) {
				System.err.print(e);
		}
	}
	
	public static void asignarSuperior() {
		Conexion conexion = new Conexion();
		Scanner scan = new Scanner(System.in);
		System.out.println("Seleccione un empleado al que se le asignara un superior \n"
				+ "presione ENTER para ver la lista");
		scan.nextLine();
		Integer idEmpleado = seleccionEmpleado();
		System.out.println("\n Seleccione el superior para el empleado " + idEmpleado +"\n"
				+ "presione ENTER para ver la lista");
		scan.nextLine();
		Integer superior = seleccionEmpleado();
		while (idEmpleado.equals(superior)) {
			System.out.println("El empleado no puede ser su propio superior, por favor elija otra opcion \n"
					+ "presione Enter para ver la lista");
			superior = seleccionEmpleado();
		}
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "UPDATE employee SET Jefe = ? WHERE Id = " + idEmpleado;
	
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setInt(1, superior);
			consultaPreparada.execute();
			
			System.out.print("Jefe asignado Correctamente");
			conexion.con.close();
		} catch (SQLException e) {
				System.err.print(e);
		}
	}
	
	public static void eliminarRegistroEmpleado() {
		Conexion conexion = new Conexion();
		int idEmpleado = seleccionEmpleado();
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "DELETE FROM `employee` WHERE Id =" + idEmpleado + "";
		
		try {
			PreparedStatement consul = conexion.con.prepareStatement(consultaSQL);
			consul.execute();
			
			System.out.println("El empleado " + idEmpleado + " ha sido borrada exitosamente");
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public static void verListaCompletaEmpleado(String filter) {
		Conexion conexion = new Conexion();
		String query = "select * from Employee WHERE " + filter +" ORDER BY 'Id' ASC";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			draw.imprimirEncabezadoListaEmpleados();
			while (resultado.next()) {
				draw.imprimirSiguienteEmpleado(resultado.getInt("Id"), resultado.getString("Nombre"), resultado.getString("Apellido"), resultado.getString("Clase"), resultado.getString("Nivel_Seguridad"), resultado.getInt("Jefe"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		draw.presioneEnter();
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
	}
	
	public static void verListaParcialEmpleado(String filter) {
		Conexion conexion = new Conexion();
		String query = "select * from Employee WHERE " + filter +"";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			int i = 0;	
			while(resultado.next()) {
				i++;
				draw.imprimirSiguienteEmpleadoReducido(i, resultado.getInt("Id"), resultado.getString("Apellido"), resultado.getString("Nombre"));
			}
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		
	}
	
	
	//---------------ASIGNACIONES--------------
	
	public static void verAsignaciones() {
		Conexion conexion = new Conexion();
		String query = "SELECT scp.Id, scp.Apodo, employee.Id AS idEmpleado, employee.Nombre, employee.Apellido "
				+ "FROM assignments "
				+ "INNER JOIN employee ON employee.Id = assignments.Empleado "
				+ "INNER JOIN scp ON scp.Id = assignments.SCP "
				+ "ORDER BY Id ASC";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			draw.imprimirEncabezadoListaAsignaciones();
			
			while(resultado.next()) {
				draw.imprimirSiguienteAsignacion(resultado.getInt("Id"), resultado.getString("Apodo"), resultado.getInt("idEmpleado"), resultado.getString("Nombre"), resultado.getString("Apellido"));
			}
		}
		catch (SQLException e){
			System.err.println(e);
		}
	}
	
	public static void asignarAnomalia() {
		
		int empleadoElegido = 0;
		Scanner scan = new Scanner(System.in);
		
		while (empleadoElegido == 0) {
			empleadoElegido = seleccionEmpleado();
			if (empleadoElegido == -1) {
				System.err.println("Parece que no hay empleados registrados, de ser un error pongase en contacto con el administrador \n"
						+ "Presione Enter para regresar");
				scan.nextLine();
				return;
			}
		}
		
		Conexion conexion = new Conexion();
		Dictionary listaOpcionesSCP = new Hashtable<>();
		String query = "SELECT scp.Id, scp.Apodo, scp.Clase FROM scp "
					  +"LEFT OUTER JOIN assignments ON scp.Id = assignments.scp AND assignments.Empleado = "+ empleadoElegido +" "
					  +"WHERE assignments.Empleado IS NULL ORDER BY 'Id' ASC";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			if (resultado.first()) {
				resultado.previous();
				int i = 1;
				while(resultado.next()) {
					draw.imprimirSiguienteSCPReducido(i, resultado.getInt("Id"), resultado.getString("Apodo"), resultado.getString("Clase"));
					listaOpcionesSCP.put(i, resultado.getInt("Id"));
					i++;
				}
				System.out.println("Seleccione la anomalia a asignar al empleado "+empleadoElegido);
				int scpElegido=scan.nextInt();
				inputAsignacionAnomalia((Integer) (listaOpcionesSCP.get(scpElegido)), empleadoElegido);
			}
			else {
				System.err.println("No se han encontrado anomalias asignables para el empleado " + Integer.toString(empleadoElegido) + "\n"
						+ "De tratarse de un error, pongase en contacto con el administrador \n"
						+ "Persione ENTER para regresar");
				scan.nextLine();
				return;
			}
		} catch (SQLException e) {
		System.err.println(e);
		}
		
		draw.presioneEnter();
		scan.nextLine();
		
	}
	
	public static void inputAsignacionAnomalia(int IdSCP, int IdEmpleado) {
		
		Conexion conexion = new Conexion();
		Scanner scan = new Scanner(System.in);
		
		Statement consulta;
		ResultSet resultado;
		String consultaSQL = "INSERT INTO `assignments`(`SCP`, `Empleado`) VALUES (?,?)";
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setInt(1, IdSCP);
			consultaPreparada.setInt(2, IdEmpleado);
			consultaPreparada.execute();
			
			System.out.print("Datos Ingresados Correctamente");
			conexion.con.close();
		} catch (SQLException e) {
				System.err.print(e);
		}
		
		draw.presioneEnter();
		scan.nextLine();
	}
	
	public static void deleteAsignacionAnomalia(int IdSCP, int IdEmpleado) {
		Conexion conexion = new Conexion();
		Scanner scan = new Scanner(System.in);
		
		Statement consulta;
		ResultSet resultado;
		String consultaSQL = "DELETE FROM `assignments` WHERE SCP = '" + IdSCP + "' AND Empleado = '"+ IdEmpleado + "'";
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			consultaPreparada.execute();
			
			System.out.print("Asignacion eliminada Correctamente");
			conexion.con.close();
		} catch (SQLException e) {
				System.err.print(e);
		}
		
		draw.presioneEnter();
		scan.nextLine();
	}
	
	public static void eliminarAsignacion() {
		int empleadoElegido = 0;
		Scanner scan = new Scanner(System.in);
		
		while (empleadoElegido == 0) {
			empleadoElegido = seleccionEmpleado();
			if (empleadoElegido == -1) {
				System.err.println("Parece que no hay empleados registrados, de ser un error pongase en contacto con el administrador \n"
						+ "Presione Enter para regresar");
				scan.nextLine();
				return;
			}
		}
		
		Conexion conexion = new Conexion();
		Dictionary listaOpcionesSCP = new Hashtable<>();
		String query = "SELECT scp.Id, scp.Apodo, scp.Clase FROM scp "
					  +"INNER JOIN assignments ON scp.Id = assignments.scp AND assignments.Empleado = "+ empleadoElegido +" "
					  +"ORDER BY 'Id' ASC";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			if (resultado.first()) {
				resultado.previous();
				int i = 1;
				while(resultado.next()) {
					draw.imprimirSiguienteSCPReducido(i, resultado.getInt("Id"), resultado.getString("Apodo"), resultado.getString("Clase"));
					listaOpcionesSCP.put(i, resultado.getInt("Id"));
					i++;
				}
				System.out.println("Seleccione la anomalia a eliminar del empleado "+empleadoElegido);
				int scpElegido=scan.nextInt();
				deleteAsignacionAnomalia((Integer) (listaOpcionesSCP.get(scpElegido)), empleadoElegido);
			}
			else {
				System.err.println("No se han encontrado anomalias asignables para el empleado " + Integer.toString(empleadoElegido) + "\n"
						+ "De tratarse de un error, pongase en contacto con el administrador \n"
						+ "Persione ENTER para regresar");
				scan.nextLine();
				return;
			}
		} catch (SQLException e) {
		System.err.println(e);
		}
		
		draw.presioneEnter();
		scan.nextLine();
		
	}
	
	
	//---------------REPORTES-----------------
	
	public static void verReporte() throws InterruptedException {
		Conexion conexion = new Conexion();
		String reporte = seleccionarReporte();
		reporte = "\"" + reporte + "\"";
		String query ="SELECT * FROM report WHERE Id = " + reporte + "";
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			resultado.next();
			draw.imprimirEncabezadoReporte(reporte, resultado.getDate("Fecha"));
			actoresInvolucrados(reporte);
			draw.imprimirIncidente(resultado.getString("Incidente"));
			draw.imprimirResolucion(resultado.getString("Resolucion"));
		}
		catch (SQLException e){
			System.err.println(e);
		}
		
	}
	
	public static void inputReporte() {
		Conexion conexion = new Conexion();
		
		Report reporte = new Report();
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "INSERT INTO `Report`(`Id`, `Incidente`, `Resolucion`) VALUES (?,?,?)";
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setString(1, reporte.getId());
			consultaPreparada.setString(2, reporte.getIncidente());
			consultaPreparada.setString(3, reporte.getResolucion());
			consultaPreparada.execute();
			
			conexion.con.close();
		} catch (SQLException e) {
				System.err.print(e);
		}
		
		pedirActores(reporte.getId());
		
		System.out.print("Datos Ingresados Correctamente \n");
	}

	public static void eliminarReporte() {
		Conexion conexion = new Conexion();
		String reporteElegido = seleccionarReporte();
		reporteElegido = "\"" + reporteElegido + "\"";
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "DELETE FROM `report` WHERE Id =" + reporteElegido + "";
		
		try {
			PreparedStatement consul = conexion.con.prepareStatement(consultaSQL);
			consul.execute();
			
			eliminarActoresSCP(reporteElegido);
			eliminarActoresEmpleados(reporteElegido);
			
			System.out.println("El reporte " + reporteElegido + " ha sido borrada exitosamente");
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	//---------------ACTORES------------------
	
	private static void actoresInvolucrados(String idReporte) {
		System.out.print("Anomalias Involucradas: ");
		actoresSCPInvolucrados(idReporte);
		System.out.print("Empleados Involucrados: ");
		actoresEmpleadosInvolucrados(idReporte);
	}
	
	private static void actoresSCPInvolucrados(String idReporte) {
		Conexion conexion = new Conexion();
		
		String query = "SELECT * FROM `scp_actor` WHERE `Id-reporte` = " + idReporte + "";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			if(resultado.first()) {
				resultado.previous();
				while (resultado.next()) {
					System.out.print( "SCP-" + Integer.toString(resultado.getInt("Id-spc")));
					if (resultado.next()) {
						System.out.print(", ");
					}
					resultado.previous();
				}
			}else {
				System.out.print("Ninguno");
			}
			System.out.println();
		}
		catch (SQLException e){
			System.err.println(e);
		}
	}
	
	private static void actoresEmpleadosInvolucrados(String idReporte) {
		Conexion conexion = new Conexion();
		
		String query = "SELECT * FROM `employee_actor` WHERE `Id-reporte` = " + idReporte + "";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			if(resultado.first()) {
				resultado.previous();
				while (resultado.next()) {
					System.out.print( resultado.getInt("Id-empleado"));
					if (resultado.next()) {
						System.out.print(", ");
					}
					resultado.previous();
				}
			}else {
				System.out.print("Ninguno");
			}
			System.out.println();
		}
		catch (SQLException e){
			System.err.println(e);
		}
	}
	
	private static void pedirActores(String idReporte) {
		Scanner scanLine = new Scanner(System.in);
		Scanner scanChar = new Scanner(System.in);
		Boolean exit = false;
		
		System.out.print("actores");
		while (!exit) {
			System.out.println("Desea asociar un empleado al reporte " + idReporte + " ? (Y/N)");
			String respuesta = scanChar.nextLine();
			respuesta = respuesta.toUpperCase(); 
			if (respuesta.equals(new String("Y"))) {
				seleccionListaActoresEmpleadoDisponible(idReporte);
			}
			if (respuesta.equals(new String("N"))) {
				exit = true;
			}else if(!respuesta.equals(new String("Y"))) {
				draw.opcionIncorrecta();
				scanLine.nextLine();
			}
		}
		
		exit = false;
		
		while (!exit) {
			System.out.println("Desea asociar una anomalia al reporte " + idReporte + " ? (Y/N)");
			String respuesta = scanChar.nextLine();
			respuesta = respuesta.toUpperCase();
			if (respuesta.equals(new String("Y"))) {
				seleccionListaActoresSCPDisponible(idReporte);
			}
			if (respuesta.equals(new String("N")) && !respuesta.equals("Y")) {
				exit = true;
			}else if(!respuesta.equals(new String("Y"))){
				draw.opcionIncorrecta();
				scanLine.nextLine();
			}
		}
	}
	
	private static void seleccionListaActoresEmpleadoDisponible(String idReporte) {
		Conexion conexion = new Conexion();
		Scanner scanInt = new Scanner(System.in);
		String query = "SELECT employee.Id, employee.Nombre, employee.Apellido FROM employee "
				+ "LEFT OUTER JOIN employee_actor "
				+ "ON employee.Id = 'employee_actor.Id-empleado' AND 'employee_actor.Id-reporte' = \"" + idReporte + "\""
				+ " ORDER BY Id ASC";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			if (resultado.first()) {
				resultado.previous();
				int i = 1;
				while(resultado.next()) {
					draw.imprimirSiguienteEmpleadoReducido(i, resultado.getInt("Id"), resultado.getString("Nombre"), resultado.getString("Apellido"));
					i ++;
				}
			}
			System.out.println("Seleccione el empleado a asignar al reporte "+idReporte);
			int empleado = scanInt.nextInt();
			
			conexion.con.close();
			inputActorEmpleado( idReporte, empleado);
		}
		catch (SQLException e) {
			System.err.println(e);
		}

	}
	
	private static void seleccionListaActoresSCPDisponible(String idReporte) {
		Conexion conexion = new Conexion();
		Scanner scanInt = new Scanner(System.in);
		String query = "SELECT scp.Id, scp.Apodo, scp.Clase FROM scp "
				+ "LEFT OUTER JOIN `scp_actor` "
				+ "ON scp.Id = 'scp_actor.Id-scp' AND 'scp_actor.Id-reporte' = \"" + idReporte + "\""
				+  "ORDER BY Id ASC";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			System.out.println("Triyng");
			if (resultado.first()) {
				resultado.previous();
				int i = 1;
				while(resultado.next()) {
					draw.imprimirSiguienteSCPReducido(i, resultado.getInt("Id"), resultado.getString("Apodo"), resultado.getString("Clase"));
					i++;
				}
			}
			System.out.println("Seleccione el empleado a asignar al reporte "+idReporte);
			int scp = scanInt.nextInt();

			conexion.con.close();
			inputActorSCP( idReporte, scp);
		}
		catch (SQLException e) {
			System.err.println(e);
		}

	}
	
	private static void inputActorEmpleado(String idReporte, int idEmpleado) {
		
		Conexion conexion = new Conexion();
		
		Statement consulta;
		ResultSet resultado;
		String consultaSQL = "INSERT INTO `employee_actor`(`Id-empleado`, `Id-reporte`) VALUES (?,?)";
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setInt(1, idEmpleado);
			consultaPreparada.setString(2, idReporte);
			consultaPreparada.execute();
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.print(e);
		}
	}
	
	private static void inputActorSCP(String idReporte, int idSCP) {
		
		Conexion conexion = new Conexion();
		
		Statement consulta;
		ResultSet resultado;
		String consultaSQL = "INSERT INTO `scp_actor`(`Id-scp`, `Id-reporte`) VALUES (?,?)";
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setInt(1, idSCP);
			consultaPreparada.setString(2, idReporte);
			consultaPreparada.execute();
			
			conexion.con.close();
		} catch (SQLException e) {
			System.err.print(e);
		}
	}
	
	private static void eliminarActoresSCP(String idReporte) {
		Conexion conexion = new Conexion();
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "DELETE FROM `scp_actor` WHERE Id =" + idReporte + "";
		
		try {
			
			PreparedStatement consul = conexion.con.prepareStatement(consultaSQL);
			consul.execute();
			conexion.con.close();
		
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	private static void eliminarActoresEmpleados(String idReporte) {
		Conexion conexion = new Conexion();
		
		Statement consulta;
		ResultSet resultado;
		
		String consultaSQL = "DELETE FROM `employee_actor` WHERE Id =" + idReporte + "";
		
		try {
			
			PreparedStatement consul = conexion.con.prepareStatement(consultaSQL);
			consul.execute();
			conexion.con.close();
		
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	// ---------------UTILS-------------------
	
	private static Integer seleccionEmpleado() {
		
		Conexion conexion = new Conexion();
		String query = "SELECT * FROM employee ORDER BY 'Apellido' ASC";
		Dictionary listaOpcionesEmpleado = new Hashtable<>();
		Scanner scan = new Scanner(System.in);
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			if (resultado.first() ) {
				int i = 1;
				resultado.previous();
				while(resultado.next()) {
					draw.imprimirSiguienteEmpleadoReducido(i, resultado.getInt("Id"), resultado.getString("Nombre"), resultado.getString("Apellido"));
					listaOpcionesEmpleado.put(i, resultado.getInt("Id"));
					i ++;
				}
				System.out.println("Seleccione un empleado");
				int opcionElegida = scan.nextInt();
				return (Integer) (listaOpcionesEmpleado.get(opcionElegida));
			}
			else {
				return(-1);
			}
		} catch (SQLException e) {
			System.err.println(e);			
		}
		return(0);
	}
	
	private static Integer seleccionEmpleadoConAsignacion () {
		Conexion conexion = new Conexion();
		String query = "SELECT employee.Id, employee.Nombre, employee.apellido FROM employee INNER JOIN assignments ON employee.ID = assignments.empleado  ORDER BY 'Apellido' ASC";
		Dictionary listaOpcionesEmpleado = new Hashtable<>();
		Scanner scan = new Scanner(System.in);
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			if (resultado.first() ) {
				int i = 1;
				resultado.previous();
				while(resultado.next()) {
					draw.imprimirSiguienteEmpleadoReducido(i, resultado.getInt("Id"), resultado.getString("Nombre"), resultado.getString("Apellido"));
					listaOpcionesEmpleado.put(i, resultado.getInt("Id"));
					i ++;
				}
				System.out.println("Seleccione el empleado al que se le eliminará una anomalia");
				int opcionElegida = scan.nextInt();
				return (Integer) (listaOpcionesEmpleado.get(opcionElegida));
			}
			else {
				return(-1);
			}
		} catch (SQLException e) {
			System.err.println(e);			
		}
		return(0);
	}

	private static Integer seleccionAnomalia() {
		Conexion conexion = new Conexion();
		String query = "SELECT * FROM scp ORDER BY 'Id' ASC";
		Dictionary listaOpcionesAnomalia = new Hashtable<>();
		Scanner scan = new Scanner(System.in);
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			if (resultado.first() ) {
				int i = 1;
				resultado.previous();
				while(resultado.next()) {
					draw.imprimirSiguienteSCPReducido(i, resultado.getInt("Id"), resultado.getString("Apodo"), resultado.getString("Clase"));
					listaOpcionesAnomalia.put(i, resultado.getInt("Id"));
					i ++;
				}
				System.out.println("\n"
						+ "Seleccione la anomalia");
				int opcionElegida = scan.nextInt();
				return (Integer) (listaOpcionesAnomalia.get(opcionElegida));
			}
			else {
				return(-1);
			}
		} catch (SQLException e) {
			System.err.println(e);			
		}
		return(0);	
	}

	private static String seleccionarReporte() {
		Conexion conexion = new Conexion();
		Scanner scan = new Scanner(System.in);
		Dictionary listaOpcionesReportes = new Hashtable<>();
		
		String query = "SELECT * FROM report ORDER BY 'Id' ASC";
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			int i = 1;
			while(resultado.next()) {
				draw.imprimirReporteReducido(i, resultado.getString("Id"), resultado.getDate("Fecha"));
				listaOpcionesReportes.put(i, resultado.getString("Id"));
				i++;
			}
			System.out.println("Seleccione un reporte");
			int opcionElegida = scan.nextInt();
			return (String) (listaOpcionesReportes.get(opcionElegida));
		}
		catch (SQLException e){
			System.err.println(e);
		}
		return("");
	}
	
}

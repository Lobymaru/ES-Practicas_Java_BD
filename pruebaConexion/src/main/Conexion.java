package main;

import java.sql.*;
import java.util.Scanner;

public class Conexion {
	Connection con;
	public Conexion(){
		
		String tabla = "test";
		String usuario = "root";
		String contrasena = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+tabla,usuario,contrasena);
		} catch (Exception error) {
			System.err.println(error);
		}
		
	}
	
	public static void inputRegistro(){
		Conexion conexion = new Conexion(); //creamos la conexion
		Scanner user = new Scanner(System.in); //creamos el escaner
		
		System.out.println("ingresar el nombre del perfil: ");
		
		String nombre = user.next();
		
		System.out.println("ingresar el apellido del perfil: ");
		String apellido = user.next();
		
		System.out.println("ingresar el dni del perfil: ");
		String dni = user.next();
		
		Statement consulta;
		ResultSet resultado;
	
		String consultaSQL = "insert into usuarios (`nombre`, `apellido`, `dni`) values (?, ?, ?)";
		
		try {
			PreparedStatement consultaPreparada = conexion.con.prepareStatement(consultaSQL);
			
			consultaPreparada.setString(1, nombre);
			consultaPreparada.setString(2, apellido);
			consultaPreparada.setString(3, dni);
			consultaPreparada.execute();
			
			System.out.println("Datos ingresados correctamente");
			menu();
			conexion.con.close();
		} catch (SQLException error) {
			System.err.println(error);
		}
	}
	
	private static void borrarRegistro() {
		Conexion conexion = new Conexion(); //creamos la conexion
		Scanner user = new Scanner(System.in);
		System.out.println("Por favor ingrese la id del usuario a borrar: ");
		String id = user.next();
		Statement consulta;
		ResultSet resultado;
		
		//String consultaSQL = "select dni, nombre from usuarios"; //escribimos la consulta para enviar
		
		String consultaSQL = "delete from usuarios where id ="+id+"";
		
		try {
			PreparedStatement consul = conexion.con.prepareStatement(consultaSQL);
			consul.execute();
			
			System.out.println("el usuario con el id: "+id+" ha sido borrado");
			
			conexion.con.close();
			menu();
		} catch (SQLException e) {
			System.err.println(e);
		}
	
	}
	
	private static void verRegistros() {
		Conexion conexion = new Conexion();
		String query = "select * from usuarios";
		
		try {
			Statement consulta = conexion.con.prepareStatement(query);
			ResultSet resultado = consulta.executeQuery(query);
			
			while(resultado.next()) {
				System.out.println(resultado.getString("id")+" "+resultado.getString("nombre")+" "+resultado.getString("apellido")+" "+resultado.getString("dni"));
			}
			
			conexion.con.close();
			menu();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public static void menu(){
		Scanner user = new Scanner(System.in);
		
		System.out.println("1. Insercion de Usuarios");
		System.out.println("2. Borrado de Usuarios");
		System.out.println("3. Ver la lista de Usuarios");
		System.out.println("");
		System.out.println("ingrese la opcion: ");
		String usuario = user.next();
		switch (usuario) {
			case "1":
				inputRegistro();
			break;
			
			case "2":
				borrarRegistro();
			break;
			
			case "3":
				verRegistros();
			break;
			
			default:
				System.err.println("opcion invalida, reinicie el sistema");
			break;
		}
	}
	
	public static void main(String[] args) {
		
		menu();
		
	}
}

package conexion;

import java.sql.*;
import java.util.Scanner;

import branchManager.Drawer;

public class Conexion {
	
	public Connection con;   // si, ya se, está horrible que sea publico
	public Conexion(){
		
		String tabla = "scp_branch";
		String usuario = "root";
		String contrasena = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+tabla,usuario,contrasena);
		} catch (Exception error) {
			System.err.println(error);
		}
		
	}

	
}

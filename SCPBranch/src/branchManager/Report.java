package branchManager;

import java.sql.Date;
import java.util.Scanner;

public class Report {
	
	private static Drawer draw = new Drawer();
	
	private static String id;
	private static String incidente;
	private static String resolucion;
	public static Drawer getDraw() {
		return draw;
	}
	public static String getId() {
		return id;
	}
	public static String getIncidente() {
		return incidente;
	}
	public static String getResolucion() {
		return resolucion;
	}
	private static void setDraw(Drawer draw) {
		Report.draw = draw;
	}
	private static void setId(String id) {
		Report.id = id;
	}
	private static void setIncidente(String incidente) {
		Report.incidente = incidente;
	}
	private static void setResolucion(String resolucion) {
		Report.resolucion = resolucion;
	}
	
	public Report() {
		Scanner scanLine = new Scanner(System.in);
		
		System.out.print("Ingrese el codigo del nuevo reporte: \n" );
		this.setId(scanLine.nextLine());
		
		System.out.print("Redacte el incidente ocurrido: \n");
		this.setIncidente(scanLine.nextLine());
		
		System.out.print("Redacte la resolucion del incidente: \n");
		this.setResolucion(scanLine.nextLine());
	}
	
}

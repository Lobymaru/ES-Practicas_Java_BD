package ejercicios;
import java.util.Scanner;

public class EjerciciosClase4 {

	public static void sumadorVentas() {
		System.out.println("Ingrese la cantidad de ventas que se quiere sumar:");
		Scanner scan = new Scanner(System.in);
		int cantVentas = scan.nextInt(), acumulador = 0;
		for (int i=0; i < cantVentas; i++) {
			System.out.println("Ingrese la venta Nro"+(i+1)+": ");
			acumulador += scan.nextInt();
		}
		System.out.println("La suma de sus ventas es de: "+acumulador);
	}
	
	public static void comparadorMayorACero() {
		int numero;
		do {
			System.out.print("Ingrese un numero: ");
			Scanner scan = new Scanner(System.in);
			numero = scan.nextInt();
		}while (numero >= 0);
		System.out.println("Su numero es: "+numero);
	}
	
	public static void analizadorDiaSemanal() {
		System.out.print("Ingrese un dia de la semana: ");
		Scanner scan = new Scanner(System.in);
		String dia = scan.nextLine();
		switch (dia.toLowerCase()) {
			case "lunes":case "martes":case "miercoles":case "jueves":case "viernes":
				System.out.println("El dia " + dia + " es un dia laboral");
				break;
			case "sabado":case "domingo":
				System.out.println("El dia "+ dia + " no es un dia laboral");
				break;
			default:
				System.out.println(dia+ " no es un dia de la semana");
			}
		}
	
	public static void ingresoNumeros() {
		Scanner scan = new Scanner(System.in);
		int numero, contador = 0;
		do {
			System.out.print("Ingrese un numero (Recuerde que el programa finalizara si ingresa -1) : ");
			numero = scan.nextInt();
			contador++;
		} while (numero != -1);
		System.out.println("Usted ingreso un total de " + contador + " numeros");
	}
	
	public static void separadorDeFrases() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese una frase");
		String frase = scan.nextLine();
		String[] palabras = frase.split(" ");
		for (String p: palabras) {
			System.out.println(p);
		}
	}
	
	public static void calculadorCuotas() {
		int valorCuota = 10, acumulador = 10;
		for (int i = 0; i < 20; i++) {
			System.out.println("En el mes " +(i+1)+ " el valor de la cuota es de " + valorCuota);
			valorCuota += valorCuota;
			acumulador += valorCuota;
		}
		System.out.println("El total pagado al finalizar la ultima cuota es de " + acumulador);
	}
	
	public static void crazyTaxi() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese la hora en que se subio al taxi en el formato hh:mm : ");
		String tiempo = scan.nextLine();
		System.out.print("Ingrese la distancia recorrida en km: ");
		int distancia = scan.nextInt();
		String[] horas = tiempo.split(":");
		int hora = Integer.parseInt(horas[0]);
		float precioInicial = 7f, exeso = 0f;
		if (hora < 24 && hora >= 5 & hora <= 21) {
			precioInicial = 6f;
		}
		if (distancia > 2) {
			exeso = (distancia -2)* 1.5f; 
		}
		System.out.println("Su tarifa es de: "+ (precioInicial + exeso + 1f) + " yenes");
	}
	
	public static void arbolDeNavidad() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese la altura del arbol de navidad: ");
		int altura = scan.nextInt();
		int anchoFinal = (altura*2)-1;
		for (int i = 0; i < altura; i++) {
			String ramaArbol = "";
			int cantAsteriscos = ((i+1)*2)-1;
			for (int j = 0; j <anchoFinal; j++) {
				int comienzoAsteriscos = ((anchoFinal-cantAsteriscos)/2);
				if (j >= comienzoAsteriscos & j < (comienzoAsteriscos + cantAsteriscos) ) {
					ramaArbol += "*";
				}
				else {
					ramaArbol += " ";
				}
			}
			System.out.println(ramaArbol);
		}
	}
	
	public static void main(String[] args) {
		arbolDeNavidad();
	}
}

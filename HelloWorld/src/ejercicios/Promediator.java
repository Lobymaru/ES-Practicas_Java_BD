package ejercicios;

public class Promediator {
	public static void main(String[] args) {
		int [] numeros = {2,4,6,8,12};
		int acum = 0;
		for (int i = 0; i < numeros.length; i++)
			acum = acum + numeros[i];
		float result = acum/5f;
		System.out.println("el promedio es " + result);
	}
}

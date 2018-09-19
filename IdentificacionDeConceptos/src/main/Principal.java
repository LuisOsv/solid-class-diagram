package main;
import java.util.Scanner;

import triangulos.Equilatero;
import triangulos.Escaleno;
import triangulos.Isoceles;
/**
 * Clase pricipal que sirve para que el usuario introduzca los lados del triangulo.
 * @author Osmar
 *
 */
public class Principal {

	public static void main(String[] args) {
		boolean salir = false;
		Scanner reader = new Scanner(System.in);
		while (salir==false){
			System.out.println("TIPO DE TRIANGULO");
			double ladoA = Principal.enterNumber(reader, "Introduzca el lado A del triangulo:");
			double ladoB = Principal.enterNumber(reader, "Introduzca el lado B del triangulo:");
			double ladoC = Principal.enterNumber(reader, "Introduzca el lado C del triangulo:");
			
			Isoceles trianguloIsoceles = new Isoceles(ladoA, ladoB, ladoC);
            Escaleno trianguloEscaleno = new Escaleno(ladoA, ladoB, ladoC);
            Equilatero trianguloEquilatero = new Equilatero(ladoA, ladoB, ladoC);
            
            if(trianguloIsoceles.propiedadDesigualdadTriangular()){
            	if (trianguloIsoceles.verificarIsoceles())
            		System.out.println("El triangulo es Isosceles");
            	else if (trianguloEscaleno.verificarEscaleno())
            		System.out.println("El triangulo es Escaleno");
            	else if (trianguloEquilatero.verificarEquilatero())
            		System.out.println("El triangulo es Equilatero");
            	else
            		System.out.println("No se puede definir el tipo de triangulo que es");
            }
            else
            	System.out.println("Los datos ingresados no cumplen con la propiedad de desigualdad "
            			+ "triangular. Por favor, introduzca un triangulo valido.");
            
            System.out.println("Introduzca 'Q' para salir y cualquier otra tecla para continuar");
            String valor= reader.next();
            if (valor.equalsIgnoreCase("q"))
            	salir=true;
            
		}

	}
	/**
	 * Metodo para hacer que el usario introduzca los lados del triangulo por consola
	 * @param reader	leer valor introducido en consola
	 * @param text	Mensaje que se muestra al usuario antes de que se introduzca un valor
	 * @return Retorna el valor introducido convertido a decimal
	 */
	
	public static double enterNumber(Scanner reader,String text){
		try {
			System.out.println(text);
			String ladoX = reader.next();
			double resp = Double.valueOf(ladoX);
			if (resp > 0)
				return resp;
			else{
				System.out.println("Error: Porfavor introduzca un valor numerico que sea mayor a 0");
				enterNumber(reader,text);
			}
		} catch (Exception e) {
			System.out.println("Error: Porfavor introduzca un valor numerico que sea mayor a 0");
			enterNumber(reader,text);
		}
		return 0;
		
	}

}

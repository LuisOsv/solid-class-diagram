package main;

import behaviors.EquilateralTriangleType;
import behaviors.IsoscelesTriangleType;
import behaviors.ScaleneTriangleType;
import triangles.TriangleShape;

public class Principal {

	public static void main(String[] args) {
		boolean salir = false;
		ReadCommandLine readLine = new ReadCommandLine();
		while (salir==false){
			readLine.printMessage("TIPO DE TRIANGULO");
			
			double ladoA = readLine.readDoubleValueGreaterThanZero("Introduzca el lado A del triangulo:");
			double ladoB = readLine.readDoubleValueGreaterThanZero("Introduzca el lado B del triangulo:");
			double ladoC = readLine.readDoubleValueGreaterThanZero("Introduzca el lado C del triangulo:");
			
			TriangleShape equilateralTriangle = new EquilateralTriangleType(ladoA, 
					ladoB, ladoC);
			TriangleShape isoscelesTriangle = new IsoscelesTriangleType(ladoA, 
					ladoB, ladoC);
			TriangleShape scaleneTriangle = new ScaleneTriangleType(ladoA, 
					ladoB, ladoC);
			if(equilateralTriangle.accomplishPropertyOfTriangularInequality(ladoA, ladoB, ladoC)){
				equilateralTriangle.defineTriangleType();
				isoscelesTriangle.defineTriangleType();
				scaleneTriangle.defineTriangleType();
			}
			else
				System.out.println("Los lados introducidos no pertenecen a un triangulo");
			
			
		
            
            System.out.println("Introduzca 'Q' para salir y cualquier otra tecla para continuar");
            if (readLine.readStringValue().equalsIgnoreCase("q"))
            	salir=true;
            
		}

	}

}

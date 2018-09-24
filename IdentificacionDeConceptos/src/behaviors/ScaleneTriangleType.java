package behaviors;

import triangles.TriangleShape;

public class ScaleneTriangleType implements TriangleShape{
	
	private double ladoA;
	private double ladoB;
	private double ladoC;
	
	public ScaleneTriangleType(double ladoA, double ladoB, double ladoC) {
		this.ladoA = ladoA;
	    this.ladoB = ladoB;
	    this.ladoC = ladoC;
	}

	@Override
	public void defineTriangleType() {
		if ((ladoA != ladoB) && (ladoA != ladoC) && (ladoB != ladoC)) 
			System.out.println("Triangulo Escaleno");
	}

}

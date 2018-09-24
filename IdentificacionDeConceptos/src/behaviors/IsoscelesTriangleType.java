package behaviors;

import triangles.TriangleShape;

public class IsoscelesTriangleType implements TriangleShape {

	private double ladoA;
	private double ladoB;
	private double ladoC;

	public IsoscelesTriangleType(double ladoA, double ladoB, double ladoC) {
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	@Override
	public void defineTriangleType() {
		if ((ladoA == ladoB) && (ladoA != ladoC))
			System.out.println("Triangulo Isosceles");
		else if ((ladoA == ladoC) && (ladoA != ladoB))
			System.out.println("Triangulo Isosceles");
		else if ((ladoB == ladoC) && (ladoA != ladoB))
			System.out.println("Triangulo Isosceles");

	}

}

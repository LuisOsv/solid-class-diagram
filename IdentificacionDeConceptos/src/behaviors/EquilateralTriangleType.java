package behaviors;

import triangles.TriangleShape;

public class EquilateralTriangleType implements TriangleShape {

	private double ladoA;
	private double ladoB;
	private double ladoC;

	public EquilateralTriangleType(double ladoA, double ladoB, double ladoC) {
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	@Override
	public void defineTriangleType() {
		if ((ladoA == ladoB) && (ladoB == ladoC))
			System.out.println("Triangulo Equilatero");

	}

}

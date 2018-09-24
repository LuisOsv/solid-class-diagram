package triangles;

public interface TriangleShape {
	
	default boolean accomplishPropertyOfTriangularInequality(double ladoA, double ladoB,
			double ladoC){
		if ((ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA))
	    	return true;
	    else
	    	return false;
	}
	
	void defineTriangleType();
	
}

package triangles;

public class Triangle {
	private TriangleShape triangle;
	
	public Triangle(TriangleShape triangle){
		this.triangle = triangle;	
	}
	
	public void typeOfTriangle(){
		this.triangle.defineTriangleType();
	}

}

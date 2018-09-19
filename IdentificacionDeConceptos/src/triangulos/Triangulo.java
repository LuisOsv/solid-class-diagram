package triangulos;
/**
 * Clase que define un triangulo de manera general.
 * @author Osmar
 *
 */
public class Triangulo {
	  private double ladoA;
	  private double ladoB;
	  private double ladoC;
	  
	  /**
	   * Constructor del triangulo
	   * @param ladoA 	valor decimal que define la longitud del lado A
	   * @param ladoB	valor decimal que define la longitud del lado B
	   * @param ladoC	valor decimal que define la longitud del lado C
	   */
	  public Triangulo(double ladoA, double ladoB, double ladoC) { 
		this.ladoA = ladoA;
	    this.ladoB = ladoB;
	    this.ladoC = ladoC;
	  }
	  /**
	   * Metodo que verifica que se cumpla con la propeidad de desigualdad
	   * @return	retorna true si los valores introducidos cumplen con la propiedad de desigualdad
	   */
	  public boolean propiedadDesigualdadTriangular() {
	    if ((ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA)) {
	    	return true;
	    }
	    else
	    	return false;
	  }
	  /**
	   * Metodo para obtener la longitud del lado A.
	   * @return	la longitud del lado A
	   */
	  public double getLadoA() {
	    return ladoA;
	  }
	  /**
	   * Metodo para dar un nuevo valor a la longitud del lado A
	   * @param ladoA nuevo valor de la longitud del lado A
	   */
	  public void setLadoA(double ladoA) {
	    this.ladoA = ladoA;
	  }
	  /**
	   * Metodo para obtener la longitud del lado B.
	   * @return	la longitud del lado B
	   */
	  public double getLadoB() {
	    return ladoB;
	  }
	  /**
	   * Metodo para dar un nuevo valor a la longitud del lado B
	   * @param ladoA nuevo valor de la longitud del lado B
	   */
	  public void setLadoB(double ladoB) {
	    this.ladoB = ladoB;
	  }
	  /**
	   * Metodo para obtener la longitud del lado C.
	   * @return	la longitud del lado C
	   */
	  public double getLadoC() {
	    return ladoC;
	  }
	  /**
	   * Metodo para dar un nuevo valor a la longitud del lado C
	   * @param ladoA nuevo valor de la longitud del lado C
	   */
	  public void setLadoC(double ladoC) {
	    this.ladoC = ladoC;
	  }
	}

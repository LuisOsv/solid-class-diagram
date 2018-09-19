package triangulos;
/**
 * Clase que define un triangulo Escaleno
 * @author Osmar
 *
 */
public class Equilatero extends Triangulo {
	/**
	* Constructor del triangulo Equilatero
	* @param ladoA 	valor decimal que define la longitud del lado A
	* @param ladoB	valor decimal que define la longitud del lado B
	* @param ladoC	valor decimal que define la longitud del lado C
	*/	
	public Equilatero(double ladoA, double ladoB, double ladoC) { 
		super(ladoA, ladoB, ladoC); 
	}
	/**
	 * Metodo que verifica si los lados introducidos pertenecen a un triangulo Equilatero
	 * @return	true si es Equilatero y false si no lo es
	 */		
	public boolean verificarEquilatero() {
	  if ((getLadoA() == getLadoB()) && (getLadoB() == getLadoC())) {
		  return true;
	  }
	  else
	  	  return false;
	}
}

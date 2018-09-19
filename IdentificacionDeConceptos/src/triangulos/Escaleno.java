package triangulos;
/**
 * Clase que define un triangulo Escaleno
 * @author Osmar
 *
 */
public class Escaleno extends Triangulo
{
	/**
	* Constructor del triangulo Escaleno
	* @param ladoA 	valor decimal que define la longitud del lado A
	* @param ladoB	valor decimal que define la longitud del lado B
	* @param ladoC	valor decimal que define la longitud del lado C
	*/
	public Escaleno(double ladoA, double ladoB, double ladoC) { 
		super(ladoA, ladoB, ladoC);
	}
	/**
	 * Metodo que verifica si los lados introducidos pertenecen a un triangulo Escaleno
	 * @return	true si es escaleno y false si no lo es
	 */
	public boolean verificarEscaleno() {
	  if ((getLadoA() != getLadoB()) && (getLadoA() != getLadoC()) && (getLadoB() != getLadoC())) {
		  return true;
	  }
	  else
		  return false;
	}
}

package triangulos;
/**
 * Clase que define un triangulo Escaleno
 * @author Osmar
 *
 */
public class Isoceles extends Triangulo
{
	/**
	* Constructor del triangulo Isosceles
	* @param ladoA 	valor decimal que define la longitud del lado A
	* @param ladoB	valor decimal que define la longitud del lado B
	* @param ladoC	valor decimal que define la longitud del lado C
	*/	
	public Isoceles(double ladoA, double ladoB, double ladoC) { 
		super(ladoA, ladoB, ladoC); 
	}
	/**
	 * Metodo que verifica si los lados introducidos pertenecen a un triangulo Isosceles
	 * @return	true si es Isosceles y false si no lo es
	 */	
	public boolean verificarIsoceles() {
	  if ((getLadoA() == getLadoB()) && (getLadoA() != getLadoC()))
		  return true;
	  else if ((getLadoA() == getLadoC()) && (getLadoA() != getLadoB()))
		  return true;
	  else if ((getLadoB() == getLadoC()) && (getLadoA() != getLadoB())) {
		  return true;
	  }
	  else
		  return false;
	}
}

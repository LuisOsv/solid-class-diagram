package concepts;

/*
 * Generic code write for a simple function that should print "hola mundo".
 * A lot of code that is not needed was written.
 */
public class CodigoGenerico {
	public String saludo;
	public String texto;
	public CodigoGenerico(String saludo, String texto){
		this.saludo = saludo;
		this.texto = texto;
	}
	

	public String getSaludo() {
		return saludo;
	}


	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void printSaludo(){
		System.out.println(saludo + " " + texto);
	}


	public static void main(String[] args) {
		CodigoGenerico x = new CodigoGenerico("hola", "mundo");
		x.printSaludo();

	}

}

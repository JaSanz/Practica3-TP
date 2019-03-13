package tp.pr3.mw.exceptions;

public class ArrayException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayException(String mensaje) {
		super(mensaje);
	}
	
	public String toString() {
		return "ArrayException: ";
	}
	
}

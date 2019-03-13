package tp.pr3.mw.exceptions;

public class BadFormatByteCodeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadFormatByteCodeException(String mensaje) {
		super(mensaje);
	}
	
	public String toString() {
		return "BadFormatByteCodeException: ";
	}
	
}

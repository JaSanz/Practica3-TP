package tp.pr3.mw.exceptions;

public class DivisionByZeroException extends ExecutionErrorException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DivisionByZeroException(String mensaje) {
		super(mensaje);
	}
	
	public String toString() {
		return "DivisionByZeroException: ";
	}
	
}

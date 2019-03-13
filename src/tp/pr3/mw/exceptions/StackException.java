package tp.pr3.mw.exceptions;

public class StackException extends ExecutionErrorException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackException(String mensaje) {
		super(mensaje);
	}
	
	public String toString() {
		return "StackException: ";
	}
	
}

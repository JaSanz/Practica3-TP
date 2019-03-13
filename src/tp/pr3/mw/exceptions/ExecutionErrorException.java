package tp.pr3.mw.exceptions;

public class ExecutionErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExecutionErrorException(String mensaje) {
		super(mensaje);
	}
	
	public String toString() {
		return "ExecutionErrorException " + "";
	}
	
}

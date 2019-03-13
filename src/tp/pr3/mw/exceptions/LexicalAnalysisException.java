package tp.pr3.mw.exceptions;

public class LexicalAnalysisException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LexicalAnalysisException(String mensaje) {
		super(mensaje);
	}
	
	public String toString() {
		return "LexicalAnalysisException: ";
	}
	
}

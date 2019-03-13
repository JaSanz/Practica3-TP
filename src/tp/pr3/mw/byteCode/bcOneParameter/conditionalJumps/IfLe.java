package tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.bcOneParameter.ConditionalJumps;

public class IfLe extends ConditionalJumps {

	
	public IfLe() {}
	
	/**
	 * Constructora
	 */
	public IfLe(int param) {
		super(param);
	}
	
	
	/**
	 * Comprueba si "n1" es menor que "n2"
	 */
	public boolean compare(int n1, int n2) {
		if (n1 > n2) return true;
		else return false;
	}

	/**
	 * Parsea el bytecode IFLE y su número
	 */	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IFLE")) {
			return new IfLEq(Integer.parseInt(string2));
		}
		else return null;
	}

	/**
	 * Muestra el nombre del bytecode
	 */
	@Override
	protected String toStringAux() {
		return "IFLE";
	}
	
}

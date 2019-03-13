package tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.bcOneParameter.ConditionalJumps;

public class IfLEq extends ConditionalJumps {

	
	public IfLEq () {}
	
	/**
	 * Constructora
	 */
	public IfLEq(int param) {
		super(param);
	}
	
	/**
	 * Comprueba si "n1" es menor o igual que "n2"
	 */
	public boolean compare(int n1, int n2) {
		if (n1 >= n2) return true;
		else return false;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IFLEQ")) {
			return new IfLEq(Integer.parseInt(string2));
		}
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	@Override
	protected String toStringAux() {
		return "IFLEQ";
	}
}

package tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.bcOneParameter.ConditionalJumps;

public class IfNEq extends ConditionalJumps {

	
	public IfNEq() {}
	
	/**
	 * Constructora
	 */
	public IfNEq(int param) {
		super(param);
	}
	
	/**
	 * Comprueba si "n1" y "n2" son distintos entre sí
	 */
	public boolean compare(int n1, int n2) {
		if (n1 != n2) return true;
		else return false;
	}

	/**
	 * Parsea el bytecode IFNEQ y su número
	 */
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IFNEQ")) {
			return new IfLEq(Integer.parseInt(string2));
		}
		else return null;
	}

	/**
	 * Muestra el nombre del bytecode
	 */
	@Override
	protected String toStringAux() {
		return "IFNEQ";
	}
	
}

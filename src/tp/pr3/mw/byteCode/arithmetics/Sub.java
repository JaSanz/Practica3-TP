package tp.pr3.mw.byteCode.arithmetics;

import tp.pr3.mw.byteCode.Arithmetics;
import tp.pr3.mw.byteCode.ByteCode;

public class Sub extends Arithmetics {

	/**
	 * Resta la subcima de la cima
	 */
	public Integer operation(int n1, int n2) {
		return n2 - n1;
	}
	
	/**
	 * Parsea el bytecode SUB
	 */
	public ByteCode parse(String[] words) {
		if (words.length == 1 && words[0].equalsIgnoreCase("SUB")) return new Sub();
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	public String toString() {
		return "SUB" + "";
	}
	
}

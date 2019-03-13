package tp.pr3.mw.byteCode.arithmetics;

import tp.pr3.mw.byteCode.Arithmetics;
import tp.pr3.mw.byteCode.ByteCode;

public class Add extends Arithmetics {
	
	/**
	 * Suma la cima con la subcima
	 */
	public Integer operation(int n1, int n2) {
		return n1 + n2;
	}
	
	/**
	 * Parsea el bytecode ADD
	 */
	public ByteCode parse(String[] words) {
		if (words.length == 1 && words[0].equalsIgnoreCase("ADD")) return new Add();
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	public String toString() {
		return "ADD" + "";
	}
	
}

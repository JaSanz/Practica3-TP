package tp.pr3.mw.byteCode.arithmetics;

import tp.pr3.mw.byteCode.Arithmetics;
import tp.pr3.mw.byteCode.ByteCode;

public class Mul extends Arithmetics {

	/**
	 * Multiplica la cima con la subcima
	 */
	public Integer operation(int n1, int n2) {
		return n1 * n2;
	}

	/**
	 * Parsea el bytecode MUL
	 */
	public ByteCode parse(String[] words) {
		if (words.length == 1 && words[0].equalsIgnoreCase("MUL")) return new Mul();
		else return null;
	}

	/**
	 * Muestra el nombre del bytecode
	 */
	public String toString() {
		return "MUL" + "";
	}
	
}

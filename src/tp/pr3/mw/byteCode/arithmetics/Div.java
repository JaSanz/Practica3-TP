package tp.pr3.mw.byteCode.arithmetics;

import tp.pr3.mw.byteCode.Arithmetics;
import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.exceptions.DivisionByZeroException;

public class Div extends Arithmetics {

	/**
	 * Divide la subcima con la cima
	 */
	public Integer operation(int n1, int n2) {
		try {
			if (n1 == 0) throw new DivisionByZeroException("Excepción: No se puede dividir entre cero");
			return n2 / n1;
		}
		catch (DivisionByZeroException divEx) {
			System.out.println(divEx.getMessage());
			return null;
		}
	}
	
	/**
	 * Parsea el bytecode DIV
	 */
	public ByteCode parse(String[] words) {
		if (words.length == 1 && words[0].equalsIgnoreCase("DIV")) return new Div();
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	public String toString() {
		return "DIV" + "";
	}
	
}

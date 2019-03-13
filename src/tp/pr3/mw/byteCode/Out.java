package tp.pr3.mw.byteCode;

import tp.pr3.mw.elements.CPU;
import tp.pr3.mw.exceptions.StackException;

public class Out implements ByteCode {

	/**
	 * Muestra el último elemento de la pila
	 */
	public boolean execute(CPU cpu) throws StackException {
		try {
			if (!cpu.out()) throw new StackException("Excepción: No se puede mostrar el elemento");
			return true;
		}
		catch (StackException stEx) {
			System.out.println(stEx.getMessage());
			return false;
		}
	}
	
	/**
	 * Parsea el bytecode ADD
	 */
	public ByteCode parse(String[] words) {
		if (words.length == 1 && words[0].equalsIgnoreCase("OUT")) return new Out();
		else return null;
	}

	/**
	 * Muestra el nombre del bytecode
	 */
	public String toString(){
		return "OUT";
	}
	
}

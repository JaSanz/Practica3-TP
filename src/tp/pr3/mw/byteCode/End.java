package tp.pr3.mw.byteCode;

import tp.pr3.mw.elements.CPU;

public class End implements ByteCode {

	/**
	 * Permite finalizar la introducción de bytecodes
	 */
	@Override
	public boolean execute(CPU cpu) {
		return true;
	}
	
	/**
	 * Parsea el bytecode END
	 */
	@Override
	public ByteCode parse(String[] words) {
		if (words.length == 1 && words[0].equalsIgnoreCase("END")) return new End();
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	public String toString(){
		return "END";
	}

}

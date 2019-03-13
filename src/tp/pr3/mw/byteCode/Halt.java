package tp.pr3.mw.byteCode;

import tp.pr3.mw.elements.CPU;

public class Halt implements ByteCode {

	/**
	 * Coloca halt a verdadero para parar la ejecución
	 */
	public boolean execute(CPU cpu) {
		cpu.halt();
		return true;
	}
	
	/**
	 * Parsea el bytecode HALT
	 */
	public ByteCode parse(String[] words) {
		if (words.length == 1 && words[0].equalsIgnoreCase("HALT")) return new Halt();
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	public String toString(){
		return "HALT";
	}
	
}

package tp.pr3.mw.byteCode;

import tp.pr3.mw.exceptions.ArrayException;

public class ByteCodeProgram {

	private static final int MAX_INSTR = 100; //Número máximo de instrucciones a introducir
	private static ByteCode[] bcprogram; //Array de instrucciones
	private static int numBc; //Posición del array
	
	/**
	 * Constructora
	 */
	public ByteCodeProgram(){
		ByteCodeProgram.bcprogram = new ByteCode[ByteCodeProgram.MAX_INSTR];
		ByteCodeProgram.numBc = 0;
	}
	
	/**
	 * Añade una instrucción bytecode
	 * @param instr: Instrucción a meter en el array
	 * @return: Devuelve verdadero si la instrucción se ha almacenado correctamente en el array; falso en caso contrario
	 */
	public boolean addBCInstruction(ByteCode instr) throws ArrayException {
		if (ByteCodeProgram.numBc == ByteCodeProgram.MAX_INSTR) throw new ArrayException("Excepción: Se ha excedido el tamaño límite del programa");
		if (numBc < MAX_INSTR) {
			bcprogram[numBc] = instr;
			++numBc;
			return true;
		}
		else return false;
	}
	
	/**
	 * Coge el número de bytecodes del array
	 * @return: Devuelve el número de bytecodes
	 */
	public int getNumberOfByteCodes() {
		return numBc;
	}
	
	/**
	 * Coge el bytecode del número introducido
	 * @param i: Posición del bytecode que se desea coger
	 * @return: Devuelve el bytecode en la posición
	 */
	public ByteCode getByteCode(int i) throws ArrayException {
		if (i >= numBc) throw new ArrayException("Excepción: No se puede acceder a la posición indicada");
		return ByteCodeProgram.bcprogram[i];
	}
	
	/**
	 * Devuelve el programa almacenado en el array
	 */
	public String toString(){
		String s = "Programa almacenado:" + System.getProperty("line.separator");
		for (int i = 0; i < numBc; ++i) {
			s = s + i + ": " + bcprogram[i] + System.getProperty("line.separator");
		}
		return s;
	}
	
	/**
	 * Resetea la posición
	 */
	public void reset() {
		numBc = 0;
	}
	
	/**
	 * Reemplaza una instrucción bytecode por otra
	 * @param replace: Posición a reemplazar
	 * @param bc: Bytecode para reemplazar en la posición introducida
	 */
	public void replace(int replace, ByteCode bc) {
		bcprogram[replace] = bc;
	}
	
}

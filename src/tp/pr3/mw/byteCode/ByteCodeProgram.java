package tp.pr3.mw.byteCode;

import tp.pr3.mw.exceptions.ArrayException;

public class ByteCodeProgram {

	private static final int MAX_INSTR = 100; //N�mero m�ximo de instrucciones a introducir
	private static ByteCode[] bcprogram; //Array de instrucciones
	private static int numBc; //Posici�n del array
	
	/**
	 * Constructora
	 */
	public ByteCodeProgram(){
		ByteCodeProgram.bcprogram = new ByteCode[ByteCodeProgram.MAX_INSTR];
		ByteCodeProgram.numBc = 0;
	}
	
	/**
	 * A�ade una instrucci�n bytecode
	 * @param instr: Instrucci�n a meter en el array
	 * @return: Devuelve verdadero si la instrucci�n se ha almacenado correctamente en el array; falso en caso contrario
	 */
	public boolean addBCInstruction(ByteCode instr) throws ArrayException {
		if (ByteCodeProgram.numBc == ByteCodeProgram.MAX_INSTR) throw new ArrayException("Excepci�n: Se ha excedido el tama�o l�mite del programa");
		if (numBc < MAX_INSTR) {
			bcprogram[numBc] = instr;
			++numBc;
			return true;
		}
		else return false;
	}
	
	/**
	 * Coge el n�mero de bytecodes del array
	 * @return: Devuelve el n�mero de bytecodes
	 */
	public int getNumberOfByteCodes() {
		return numBc;
	}
	
	/**
	 * Coge el bytecode del n�mero introducido
	 * @param i: Posici�n del bytecode que se desea coger
	 * @return: Devuelve el bytecode en la posici�n
	 */
	public ByteCode getByteCode(int i) throws ArrayException {
		if (i >= numBc) throw new ArrayException("Excepci�n: No se puede acceder a la posici�n indicada");
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
	 * Resetea la posici�n
	 */
	public void reset() {
		numBc = 0;
	}
	
	/**
	 * Reemplaza una instrucci�n bytecode por otra
	 * @param replace: Posici�n a reemplazar
	 * @param bc: Bytecode para reemplazar en la posici�n introducida
	 */
	public void replace(int replace, ByteCode bc) {
		bcprogram[replace] = bc;
	}
	
}

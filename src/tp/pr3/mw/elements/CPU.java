package tp.pr3.mw.elements;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.ByteCodeProgram;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.DivisionByZeroException;
import tp.pr3.mw.exceptions.ExecutionErrorException;
import tp.pr3.mw.exceptions.StackException;

public class CPU {
	
	private Memory memory = new Memory();
	private OperandStack stack = new OperandStack();
	private ByteCodeProgram bcProgram = new ByteCodeProgram();
	
	private boolean halt = false; //Controla si se ha ejecutado la instrucci�n HALT
	private int programCounter = 0;
	
	public CPU() {}
	
	/**
	 * Constructora de un par�metro
	 * @param program: Par�metro a asignar a una instrucci�n bytecode
	 */
	public CPU(ByteCodeProgram program) {
		this.bcProgram = program;
	}
	
	/**
	 * Comprueba el valor del atributo halt
	 * @return: Devuelve verdadero si el atributo halt es verdadero; falso en caso contrario
	 */
	public boolean isHalted() {
		return halt;
	}

	/**
	 * Cambia el valor de halt a verdadero cuando se ejecuta dicha intrucci�n
	 */
	public void halt() {
		this.halt = true;
	}
	
	/**
	 * Coge el n�mero de elementos que hay en la pila
	 * @return: Devuelve el n�mero de elementos de la pila
	 */
	public int getSizeStack() {
		return stack.getNumElems();
	}
	
	public int getSizeMemory() {
		return memory.getSizeMemory();
	}
	
	/**
	 * Coge el �ltimo elemento de la pila
	 * @return: Devuelve el valor del �ltimo elemento de la pila
	 * @throws StackException 
	 */
	public int pop() throws StackException {
		return this.stack.pop();
	}
	
	/**
	 * Permite introducir un elemento en la pila
	 * @param i: Par�metro a introducir en la pila
	 * @return: Devuelve el valor introducido en la pila
	 * @throws StackException 
	 */
	public boolean push(int i) throws StackException {
		return stack.push(i);
	}
	
	/**
	 * Comprueba si la posici�n de la memoria existe o es null
	 * @param param: Par�metro que indica la posici�n de la memoria a leer
	 * @return: Devuelve verdadero si el valor no es null; falso en caso contrario
	 */
	public boolean read(int param) {
		if (memory.read(param) != null) return true;
		else return false;
	}
	
	/**
	 * Escribe un n�mero "value" en la posici�n "param" de la memoria
	 * @param param: Posici�n donde se va a escribir
	 * @param value: Valor a introducir en la posici�n "param"
	 */
	public void write(int param, int value) {
		memory.write(param, value);
	}
	
	/**
	 * Pone el contador a un valor "jump"
	 * @param jump: Valor al que se quiere incrementar o decrementar el contador
	 */
	public void setProgramCounter(int jump) {
		programCounter = jump;
	}
	
	/**
	 * Incrementa en uno el contador
	 */
	public void increaseProgramCounter() {
		++programCounter;
	}
	
	/**
	 * Lee el valor de la memoria en la posici�n "param"
	 * @param param: Posici�n de la memoria que se desea leer
	 * @return: Devuelve null si no existe; el valor en caso contrario
	 */
	public int load(int param) {
		return memory.read(param);
	}
	
	/**
	 * Escribe el valor de la cima de la pila
	 * @return: Devuelve verdadero si hay elementos en la pila; falso en caso contrario
	 */
	public boolean out() throws StackException {
		if (stack.numElems > 0) {
			System.out.println("El n�mero almacenado en la cima de la pila es: " + stack.getNumStack());
			stack.pop();
			return true;
		}
		else return false;
	}
	
	/**
	 * Ejecuta los bytecodes
	 * @return: Devuelve verdadero si la operaci�n se ha ejecutado correctamente; falso en caso contrario
	 * @throws StackException 
	 * @throws DivisionByZeroException 
	 * @throws ArrayException 
	 */
	public void run() throws ArrayException, ExecutionErrorException {
		try {
			this.programCounter = 0;
			while (this.programCounter < this.bcProgram.getNumberOfByteCodes() && !isHalted()) {
				ByteCode bc = bcProgram.getByteCode(this.programCounter);
				if (!bc.execute(this)) throw new ExecutionErrorException("Excepci�n: Error en la ejecuci�n del ByteCode");
				increaseProgramCounter();
			}
		}
		catch (ExecutionErrorException exEx) {
			System.out.println(exEx.getMessage() + " " + programCounter);
		}
	}
	
	/**
	 * Reseta la CPU
	 */
	public void reset() {
		this.memory.reset();
		this.stack.reset();
		this.halt = false;
	}
	
	/**
	 * Devuelve el estado de la CPU
	 */
	public String toString(){
		String s = System.getProperty("line.separator") +
		"Estado de la CPU: " + System.getProperty("line.separator") +
		" Memoria: " + this.memory + System.getProperty("line.separator") +
		" Pila: " + this.stack + System.getProperty("line.separator");
		return s;
	}
	
}

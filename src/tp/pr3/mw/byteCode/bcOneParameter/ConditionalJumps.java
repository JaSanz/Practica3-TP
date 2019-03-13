package tp.pr3.mw.byteCode.bcOneParameter;

import tp.pr3.mw.byteCode.ByteCodeOneParameter;
import tp.pr3.mw.elements.CPU;
import tp.pr3.mw.exceptions.StackException;

public abstract class ConditionalJumps extends ByteCodeOneParameter {
	
	/**
	 * Constructora
	 */
	public ConditionalJumps(){}
	
	/**
	 * Constructora de un par�metro
	 * @param j: Par�metro para la clase padre
	 */
	public ConditionalJumps(int param) {
		super(param);
	}
	
	/**
	 * Coge la cima y la subcima y realiza la operaci�n correspondiente con ellas
	 * Devuelve verdadero si la operaci�n se ha ejecutado correctamente. Falso en caso contrario
	 * @throws StackException 
	 */
	@Override
	public boolean execute(CPU cpu) throws StackException {
		try {
			if (cpu.getSizeStack() < 2) throw new StackException("Excepci�n: Tama�o de la pila insuficiente");
			if (!compare(cpu.pop(), cpu.pop())) cpu.setProgramCounter(this.param - 1);
			return true;
		}
		catch (StackException stEx) {
			System.out.println(stEx.getMessage());
			return false;
		}
	 }
	
	public void setN(int n) {
		this.param = n;
	}
	
	 abstract protected boolean compare(int n1, int n2);
	
}

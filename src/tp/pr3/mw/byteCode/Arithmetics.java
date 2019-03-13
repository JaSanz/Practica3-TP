package tp.pr3.mw.byteCode;

import tp.pr3.mw.elements.CPU;
import tp.pr3.mw.exceptions.DivisionByZeroException;
import tp.pr3.mw.exceptions.StackException;

public abstract class Arithmetics implements ByteCode {
	
	/**
	 * Coge la cima y la subcima y ejecuta la operación correspondiente con ellas
	 * Devuelve verdadero si la operación se ha ejecutado correctamente. Falso en caso contrario
	 */
	public boolean execute(CPU cpu) throws StackException, DivisionByZeroException {
		try {
			if (cpu.getSizeStack() < 2) throw new StackException("Excepción: El número de elementos es insuficiente");
			int n1 = cpu.pop(); //Cima
			int n2 = cpu.pop(); //Subcima
			cpu.push(operation(n1, n2));
			return true;
		}
		catch (StackException stEx) {
			System.out.println(stEx.getMessage());
			return false;
		}
	}
	
	abstract protected Integer operation(int n1, int n2);
	
}

package tp.pr3.mw.byteCode.bcOneParameter;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.ByteCodeOneParameter;
import tp.pr3.mw.elements.CPU;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.StackException;

public class Store extends ByteCodeOneParameter {
	
	/**
	 * Constructora
	 */
	public Store() {}
	
	public Store(int param) {
		super(param);
	}
	
	/**
	 * Almacena el �ltimo valor de la pila en la memoria
	 */
	@Override
	public boolean execute(CPU cpu) throws StackException, ArrayException {
		try {
			if (cpu.getSizeStack() <= 0) throw new StackException("Excepci�n: La pila est� vac�a");
			if (param < 0) throw new ArrayException("Excepci�n: No se puede almacenar un valor en una posici�n negativa");
			cpu.write(param, cpu.pop());
			return true;
			}
		catch (StackException stEx) {
			System.out.println(stEx.getMessage());
			return false;
		}
		catch (ArrayException arrEx) {
			System.out.println(arrEx.getMessage());
			return false;
		}
	}
	
	/**
	 * Parsea el bytecode STORE y su n�mero
	 */
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("STORE")) {
			return new Store(Integer.parseInt(string2));
		}
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	@Override
	protected String toStringAux() {
		return "STORE";
	}
	
}

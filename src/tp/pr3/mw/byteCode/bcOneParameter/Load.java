package tp.pr3.mw.byteCode.bcOneParameter;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.ByteCodeOneParameter;
import tp.pr3.mw.elements.CPU;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.StackException;

public class Load extends ByteCodeOneParameter {
	
	/**
	 * Constructora
	 */
	public Load() {}
	
	public Load(int param) {
		super(param);
	}
	
	/**
	 * Coge un valor de la memoria y lo pone en la pila
	 */
	@Override
	public boolean execute(CPU cpu) throws StackException, ArrayException {
		try {
			if (param < 0) throw new ArrayException("Excepción: No se puede acceder a una posición negativa de la memoria");
			if (param > cpu.getSizeMemory()) throw new ArrayException("Excepción: La posición a la que se intenta acceder no existe");
			if (!cpu.read(param)) throw new ArrayException("Excepción: La posición a la que se intenta acceder no tiene ningún valor");
			if (!cpu.push(cpu.load(param))) throw new StackException("Execpción: La pila está llena");
			return true;
		}
		catch (ArrayException arrEx) {
			System.out.println(arrEx.getMessage());
			return false;
		}
		catch (StackException stEx) {
			System.out.println(stEx.getMessage());
			return false;
		}
		
	}
	
	/**
	 * Parsea el bytecode LOAD y su número
	 */
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("LOAD")) {
			return new Load(Integer.parseInt(string2));
		}
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	@Override
	protected String toStringAux() {
		return "LOAD";
	}
	
}

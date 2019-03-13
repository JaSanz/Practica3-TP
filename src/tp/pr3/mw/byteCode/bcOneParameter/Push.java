package tp.pr3.mw.byteCode.bcOneParameter;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.ByteCodeOneParameter;
import tp.pr3.mw.elements.CPU;
import tp.pr3.mw.exceptions.StackException;

public class Push extends ByteCodeOneParameter {

	/**
	 * Constructora
	 */
	public Push() {}
	
	public Push(int param){
		super(param);
	}
	
	/**
	 * Pone un valor "param" en la cima de la pila
	 * @throws StackException 
	 */
	@Override
	public boolean execute(CPU cpu) throws StackException {
		try {
			if (!cpu.push(param)) throw new StackException("Excepción: La pila está llena");
			return true;
		}
		catch (StackException stEx) {
			System.out.println(stEx.getMessage());
			return false;
		}
	}
	
	/**
	 * Parsea el bytecode GOTO y su número
	 */
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("PUSH")) {
			return new Push(Integer.parseInt(string2));
		}
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	@Override
	protected String toStringAux() {
		return "PUSH";
	}

}

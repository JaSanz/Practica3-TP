package tp.pr3.mw.byteCode.bcOneParameter;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.ByteCodeOneParameter;
import tp.pr3.mw.elements.CPU;

public class GoTo extends ByteCodeOneParameter {
	
	/** 
	 * Constructora
	 */
	public GoTo() {}
	
	public GoTo(int param) {
		super(param);
	}
	
	/**
	 * Coloca el contador del programa al valor "param - 1".
	 */
	@Override
	public boolean execute(CPU cpu) {
		cpu.setProgramCounter(param - 1); //Se resta 1 para ejecutar la instrucción del número
		return true;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("GOTO")) {
			return new GoTo(Integer.parseInt(string2));
		}
		else return null;
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	@Override
	public String toStringAux() {
		return "GOTO";
	}
	
}

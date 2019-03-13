package tp.pr3.mw.mv;

import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.inst.Instruction;

public class ParsedProgram {

	private static final int MAX_INSTR = 100;
	private Instruction[] pProgram;
	private int contador;
	
	public ParsedProgram() {
		pProgram = new Instruction[MAX_INSTR];
		contador = 0;
	}
	
	public void addInstr(Instruction instr) throws ArrayException {
		if (this.getSize() == ParsedProgram.MAX_INSTR) throw new ArrayException("Excepción: Se ha excedido el tamaño máximo del programa");
		pProgram[contador] = instr;
		++contador;
	}
	
	public int getSize() {
		return contador;
	}
	
	public Instruction getInstruction(int n) {
		return pProgram[n];
	}
	
	public void reset() {
		for (int i = 0; i < contador; ++i) {
			pProgram[i] = null;
		}
		contador = 0;
	}
	
	public String toString() {
		String s = "Programa parseado:" + System.getProperty("line.separator");
		for (int i = 0; i < contador; ++i) {
			s = s + i + ": " + pProgram[i] + System.getProperty("line.separator");
		}
		return s;
	}
	
}

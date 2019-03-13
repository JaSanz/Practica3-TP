package tp.pr3.mw.mv;

import tp.pr3.mw.exceptions.ArrayException;

public class SourceProgram {

	private static final int MAX_INSTR = 100;
	private String[] sProgram;
	private int contador;
	
	public SourceProgram() {
		sProgram = new String[MAX_INSTR];
		contador = 0;
	}
	
	public int getSize() {
		return contador;
	}
	
	public void addInstr(String instr) throws ArrayException {
		if (this.getSize() == SourceProgram.MAX_INSTR) throw new ArrayException("Excepción: Se ha alcanzdo el tamaño máximo del programa");
		instr.trim();
		sProgram[contador] = instr;
		++contador;
	}
	
	public String getInstr(int n) {
		return sProgram[n];
	}
	
	public void reset() {
		for (int i = 0; i < contador; ++i) {
			sProgram[i] = null;
		}
		contador = 0;
		contador = 0;
	}
	
	public String toString() {
		String s = System.getProperty("line.separator") + "Programa fuente almacenado:" +
			System.getProperty("line.separator");
		for (int i = 0; i < contador; ++i) {
			s = s + i + ": " + sProgram[i] + System.getProperty("line.separator");
		}
		return s;
	}
	
}

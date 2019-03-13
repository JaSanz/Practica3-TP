package tp.pr3.mw.elements;

import java.util.Objects;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.ByteCodeProgram;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.inst.Instruction;
import tp.pr3.mw.mv.ParsedProgram;

public class Compiler {

	private ByteCodeProgram bcProgram;
	private static final int MAX_INSTR = 100;
	private String[] varTable;
	private int numVars;
	
	public Compiler() {
		this.bcProgram = new ByteCodeProgram();
		numVars = 0;
		varTable = new String[MAX_INSTR];
	}
	
	public void compile(ParsedProgram pProgram) throws ArrayException {
		int i = 0;
			while (i < pProgram.getSize()) {
					Instruction instr = pProgram.getInstruction(i);
					instr.compile(this);
					i++;
			}
	}
	
	public void initialize(ByteCodeProgram bcProgram) {
		bcProgram.reset();
	}
	
	public void addByteCode(ByteCode b) throws ArrayException {
		bcProgram.addBCInstruction(b);
	}
	
	public int addVariable(String varName) {
		varTable[numVars] = varName;
		++numVars;
		return numVars - 1;
	}
	
	public int getIndex(String varName) {
		int i = 0;
		while (i < numVars) {
			if (Objects.equals(varTable[i], varName)) return i;
			else ++i;
		}
		addVariable(varName);
		return numVars - 1;
	}
	
	public String get(int i) {
		return varTable[i];
	}

	public int getBcProgramCounter() {
		return bcProgram.getNumberOfByteCodes();
	}
	
	public int getProgramCounter() {
		return numVars;
	}
	
	public void reset() {
		for (int i = 0; i < numVars; ++i) {
			varTable[i] = null;
		}
		this.initialize(bcProgram);
		numVars = 0;
		bcProgram.reset();
	}
	
	public String toString() {
		return "no se lo que hay que devolver";
	}
	
}

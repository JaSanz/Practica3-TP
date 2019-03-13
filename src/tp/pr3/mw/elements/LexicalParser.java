	package tp.pr3.mw.elements;

import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.LexicalAnalysisException;
import tp.pr3.mw.inst.Instruction;
import tp.pr3.mw.inst.InstructionParser;
import tp.pr3.mw.mv.ParsedProgram;
import tp.pr3.mw.mv.SourceProgram;

public class LexicalParser {

	private SourceProgram sProgram;
	private int programCounter;
	
	boolean error;
	
	public LexicalParser() {
		this.sProgram = new SourceProgram();
		programCounter = 0;
		error = false;
	}
	
	public boolean Exception() {
		return error;
	}
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException, ArrayException {
		boolean stop = false;
		try {
			while (this.programCounter < sProgram.getSize() && !stop) {
				String instr = sProgram.getInstr(this.programCounter);
				instr = instr.trim();
				if (instr.equalsIgnoreCase(stopKey)) {
					stop = true;
				}
				else {
					Instruction instruction = InstructionParser.parse(instr,this);
					if (instruction != null) {
						pProgram.addInstr(instruction);
					}
					else throw new LexicalAnalysisException("Excepción: La instrucción \"" + instr + "\" está mal escrita");
				}
			}
			if (!stop) throw new LexicalAnalysisException("Excepción: No se han encontrado las instrucciones de parada");
		}
		catch (LexicalAnalysisException LexEx) {
			error = true;
			System.out.println(LexEx.getMessage());
		}
	}
	
	public void reset() {
		this.programCounter = 0;
	}
	
	public void increaseProgramCounter() {
		this.programCounter++;
	}
	
	public void initialize(SourceProgram sProgram) {
		this.programCounter = 0;
		this.sProgram = sProgram;
	}
	
}

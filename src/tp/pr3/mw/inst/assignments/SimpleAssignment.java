package tp.pr3.mw.inst.assignments;

import tp.pr3.mw.byteCode.bcOneParameter.Store;
import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.inst.Instruction;

public class SimpleAssignment implements Instruction {
	
	private String varName;
	private Term rhs;
	
	public SimpleAssignment() {}
	
	public SimpleAssignment(String varName, Term rhs) {
		this.varName = varName;
		this.rhs = rhs;
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 3) return null;
		else {
			char name = words[0].charAt(0);
			if ('a' > name && name < 'z') return null;
			varName = String.valueOf(name);
			char equal = words[1].charAt(0);
			if (equal != '=') return null;
			rhs = TermParser.parse(words[2]);
			if (rhs == null) return null;
			lexParser.increaseProgramCounter();
			return new SimpleAssignment(varName, rhs);
		}
	}
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		int index = compiler.getIndex(this.varName);
		compiler.addByteCode(this.rhs.compile(compiler));
		compiler.addByteCode(new Store(index));
	}
	
}

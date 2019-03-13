package tp.pr3.mw.inst.conditionals;

import tp.pr3.mw.byteCode.Out;
import tp.pr3.mw.byteCode.bcOneParameter.Load;
import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.inst.Instruction;

public class Write implements Instruction {
	
	private String varName;

	public Write() {}
	
	public Write(String varName) {
		this.varName = varName;
	}
	
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 2) return null;
		else {
			if (!words[0].equalsIgnoreCase("WRITE")) return null;
			char name = words[1].charAt(0);
			if ('a' > name && name < 'z') return null;
			varName = String.valueOf(name);
			lexParser.increaseProgramCounter();
			return new Write(varName);
		}
	}
	
	public void compile(Compiler compiler) throws ArrayException {
		int index = compiler.getIndex(this.varName);
		compiler.addByteCode(new Load(index));
		compiler.addByteCode(new Out());
	}

}

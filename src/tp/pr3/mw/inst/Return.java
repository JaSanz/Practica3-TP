package tp.pr3.mw.inst;

import tp.pr3.mw.byteCode.Halt;
import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;

public class Return implements Instruction {

	public Return() {}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 1) return null;
		else {
			if (!words[0].equalsIgnoreCase("RETURN")) return null;
			lexParser.increaseProgramCounter();
			return new Return();
		}
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}

}

package tp.pr3.mw.inst;

import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;

public interface Instruction {
	
	Instruction lexParse(String[] words, LexicalParser lexParser);
	
	void compile(Compiler compiler) throws ArrayException;
	
}

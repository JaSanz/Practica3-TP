package tp.pr3.mw.inst;

import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.inst.assignments.CompoundAssignment;
import tp.pr3.mw.inst.assignments.SimpleAssignment;
import tp.pr3.mw.inst.conditionals.IfThen;
import tp.pr3.mw.inst.conditionals.Write;

public class InstructionParser {

	private final static Instruction[] instructions= { new SimpleAssignment(), new CompoundAssignment(),
		new Write(), new Return(), new While(), new IfThen()};

	public static Instruction parse(String instr, LexicalParser lexicalParser) {
		boolean found = false;
		int i = 0;
		Instruction ins = null;
		instr = instr.trim();
		String []words = instr.split(" +");
		while (i < instructions.length && !found) {
			ins = instructions[i].lexParse(words, lexicalParser);
			if (ins != null) found = true;
			else ++i;
		}
		if (!found) return null;
		return ins;
	}
	
}

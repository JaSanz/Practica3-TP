package tp.pr3.mw.inst.assignments;

import tp.pr3.mw.byteCode.arithmetics.Add;
import tp.pr3.mw.byteCode.arithmetics.Div;
import tp.pr3.mw.byteCode.arithmetics.Mul;
import tp.pr3.mw.byteCode.arithmetics.Sub;
import tp.pr3.mw.byteCode.bcOneParameter.Load;
import tp.pr3.mw.byteCode.bcOneParameter.Store;
import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.inst.Instruction;

public class CompoundAssignment implements Instruction {
	
	private String varName;
	private char operator;
	private Term t1;
	private Term t2;
	
	public CompoundAssignment() {}
	
	public CompoundAssignment(String varName, char operator, Term t1, Term t2) {
		this.varName = varName;
		this.operator = operator;
		this.t1 = t1;
		this.t2 = t2;
	}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 5) return null;
		else {
			char name = words[0].charAt(0);
			if ('a' > name && name < 'z') return null;
			varName = String.valueOf(name);
			char equal = words[1].charAt(0);
			if (equal != '=') return null;
			t1 = TermParser.parse(words[2]);
			if (t1 == null) return null;
			operator = words[3].charAt(0);
			if (operator == '+' ||operator == '-' || operator == '*' ||operator == '/') {
				t2 = TermParser.parse(words[4]);
				if (t2 == null) return null;
				lexParser.increaseProgramCounter();
				return new CompoundAssignment(varName, operator, t1, t2);
			}
			else return null;
		}
	}
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		int index = compiler.getIndex(this.varName);
		compiler.addByteCode(new Load(index));
		compiler.addByteCode(this.t2.compile(compiler));
		if (operator == '+') compiler.addByteCode(new Add());
		else if (operator == '-') compiler.addByteCode(new Sub());
		else if (operator == '/') compiler.addByteCode(new Div());
		else if (operator == '*') compiler.addByteCode(new Mul());
		compiler.addByteCode(new Store(index));
	}
	
}

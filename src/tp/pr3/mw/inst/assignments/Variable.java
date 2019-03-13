package tp.pr3.mw.inst.assignments;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.bcOneParameter.Load;
import tp.pr3.mw.elements.Compiler;

public class Variable implements Term {

	private String varName;
	
	public Variable(String term) {
		varName = term;
	}

	@Override
	public Term parse(String term) {
		if (term.length() != 1) return null;
		else {
			term = term.trim();
			char name = term.charAt(0);
			if ('a' <= name && name <= 'z') return new Variable(term);
			else return null;
		}
	}
	
	@Override
	public ByteCode compile(Compiler compiler){
		return new Load(compiler.getIndex(varName));
	}
	
	public String toString() {
		return this.varName;
	}
	
}

package tp.pr3.mw.inst.conditionals;

import tp.pr3.mw.byteCode.bcOneParameter.ConditionalJumps;
import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.inst.assignments.Term;
import tp.pr3.mw.inst.assignments.TermParser;

public abstract class Condition {

	private Term t1;
	private Term t2;
	protected String op;
	protected ConditionalJumps condition;
	
	public Condition() {}
	
	public Condition(Term t1, Term t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public Condition parse(String t1, String op, String t2, LexicalParser parser) {
		this.t1 = TermParser.parse(t1);
		this.t2= TermParser.parse(t2);
		if (t1 != null && t2 != null) return parseOp(this.t1, op, this.t2, parser);
		else return null;
	}
	
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.t1.compile(compiler));
		compiler.addByteCode(this.t2.compile(compiler));
		this.condition = this.compileOp();
		compiler.addByteCode(this.condition);
	}
	
	public void setJump(int programCounter) {
		condition.setN(programCounter);
	}
	
	protected abstract Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser);
	
	protected abstract ConditionalJumps compileOp();
	
}

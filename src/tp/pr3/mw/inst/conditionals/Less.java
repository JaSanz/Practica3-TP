package tp.pr3.mw.inst.conditionals;

import java.util.Objects;

import tp.pr3.mw.byteCode.bcOneParameter.ConditionalJumps;
import tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps.IfLe;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.inst.assignments.Term;

public class Less extends Condition {

	public Less() {}
	
	public Less(Term t1, Term t2) {
		super(t1, t2);
	}
	
	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if (Objects.equals(op, "<")) return new Less(t1, t2);
		else return null;
	}

	@Override
	protected ConditionalJumps compileOp() {
		return new IfLe();
	}

}

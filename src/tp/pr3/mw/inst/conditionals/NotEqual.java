package tp.pr3.mw.inst.conditionals;

import java.util.Objects;

import tp.pr3.mw.byteCode.bcOneParameter.ConditionalJumps;
import tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps.IfNEq;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.inst.assignments.Term;

public class NotEqual extends Condition {

	public NotEqual() {}
	
	public NotEqual(Term t1, Term t2) {
		super(t1, t2);
	}
	
	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if (Objects.equals(op, "!=")) return new NotEqual(t1, t2);
		else return null;
	}

	@Override
	protected ConditionalJumps compileOp() {
		return new IfNEq();
	}

}

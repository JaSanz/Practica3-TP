package tp.pr3.mw.inst.conditionals;

import tp.pr3.mw.elements.LexicalParser;

public class ConditionParser {

	private final static Condition[] conditions = {new Less(), new LessEq(), new Equal(), new NotEqual()};
	
	public static Condition parse(String t1, String op, String t2, LexicalParser parser) {
		boolean found = false;
		int i = 0;
		Condition cond = null;
		t1 = t1.trim();
		op = op.trim();
		t2 = t2.trim();
		while (i < conditions.length && !found){
			cond = conditions[i].parse(t1, op, t2, parser);
			if (cond != null) found = true;
			else i++;
		}
		return cond;
	}
	
}

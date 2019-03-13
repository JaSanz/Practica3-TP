package tp.pr3.mw.inst;

import tp.pr3.mw.byteCode.bcOneParameter.GoTo;
import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.LexicalAnalysisException;
import tp.pr3.mw.inst.conditionals.Condition;
import tp.pr3.mw.inst.conditionals.ConditionParser;
import tp.pr3.mw.mv.ParsedProgram;

public class While implements Instruction {

	private Condition condition;
	private ParsedProgram whileBody;
	
	public While() {}
	
	public While(Condition condition2, ParsedProgram whileBody2) {
		condition = condition2;
		whileBody = whileBody2;
	}

	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 4) return null;
		else {
			String name = words[0];
			if (!name.equalsIgnoreCase("WHILE")) return null;
			Condition cond = ConditionParser.parse(words[1],words[2],words[3],lexParser);
			ParsedProgram whileBody = new ParsedProgram();
			try {
				lexParser.increaseProgramCounter();
				lexParser.lexicalParser(whileBody, "ENDWHILE");
				if (lexParser.Exception()) throw new LexicalAnalysisException("");
				lexParser.increaseProgramCounter();
				return new While(cond, whileBody);
			}
			catch (LexicalAnalysisException | ArrayException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
	}

	public void compile(Compiler compiler) throws ArrayException {
		int inicio = compiler.getBcProgramCounter();
		this.condition.compile(compiler);
		compiler.compile(this.whileBody);
		compiler.addByteCode(new GoTo(inicio));
		this.condition.setJump(compiler.getBcProgramCounter());
	}
	
}

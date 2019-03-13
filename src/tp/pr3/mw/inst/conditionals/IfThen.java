package tp.pr3.mw.inst.conditionals;

import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.LexicalAnalysisException;
import tp.pr3.mw.inst.Instruction;
import tp.pr3.mw.mv.ParsedProgram;

public class IfThen implements Instruction {

	private Condition condition;
	private ParsedProgram ifBody;
	
	public IfThen() {}
	
	public IfThen(Condition condition, ParsedProgram ifBody) {
		this.ifBody = ifBody;
		this.condition = condition;
	}
	
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if (words.length != 4) return null;
		else {
			String name = words[0];
			if (!name.equalsIgnoreCase("IF")) return null;
			Condition cond = ConditionParser.parse(words[1],words[2],words[3],lexParser);
			ParsedProgram ifBody = new ParsedProgram();
			try {
				lexParser.increaseProgramCounter();
				lexParser.lexicalParser(ifBody, "ENDIF");
				if (lexParser.Exception()) throw new LexicalAnalysisException("");
				lexParser.increaseProgramCounter();
				return new IfThen(cond, ifBody);
			} 
			catch (LexicalAnalysisException | ArrayException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
	}
	
	public void compile(Compiler compiler) throws ArrayException {
		this.condition.compile(compiler);
		compiler.compile(this.ifBody);
		this.condition.setJump(compiler.getBcProgramCounter());
	}

}

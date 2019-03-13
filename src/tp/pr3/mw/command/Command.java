package tp.pr3.mw.command;

import java.io.FileNotFoundException;

import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.BadFormatByteCodeException;
import tp.pr3.mw.exceptions.DivisionByZeroException;
import tp.pr3.mw.exceptions.ExecutionErrorException;
import tp.pr3.mw.exceptions.LexicalAnalysisException;
import tp.pr3.mw.exceptions.StackException;
import tp.pr3.mw.mv.Engine;

public interface Command {
	
	abstract public Command parse(String[] s);
	
	abstract public String textHelp();
	
	abstract public void execute(Engine engine) throws FileNotFoundException, ArrayException, LexicalAnalysisException, 
	BadFormatByteCodeException, ExecutionErrorException, StackException, DivisionByZeroException;
	
}

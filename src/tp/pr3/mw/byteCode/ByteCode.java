package tp.pr3.mw.byteCode;

import tp.pr3.mw.elements.CPU;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.DivisionByZeroException;
import tp.pr3.mw.exceptions.StackException;

public interface ByteCode {
	
	abstract public boolean execute(CPU cpu) throws DivisionByZeroException, StackException, ArrayException;
	
	abstract public ByteCode parse(String[] words);
	
}

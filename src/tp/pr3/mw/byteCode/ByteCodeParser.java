package tp.pr3.mw.byteCode;

import tp.pr3.mw.byteCode.arithmetics.Add;
import tp.pr3.mw.byteCode.arithmetics.Div;
import tp.pr3.mw.byteCode.arithmetics.Mul;
import tp.pr3.mw.byteCode.arithmetics.Sub;
import tp.pr3.mw.byteCode.bcOneParameter.GoTo;
import tp.pr3.mw.byteCode.bcOneParameter.Load;
import tp.pr3.mw.byteCode.bcOneParameter.Push;
import tp.pr3.mw.byteCode.bcOneParameter.Store;
import tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps.IfEq;
import tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps.IfLEq;
import tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps.IfLe;
import tp.pr3.mw.byteCode.bcOneParameter.conditionalJumps.IfNEq;

public class ByteCodeParser {
	
	private final static ByteCode[] byteCodes = {new Add(), new Sub(), new Mul(), new Div(), new Out(), 
		new Halt(), new Push(), new Store(), new Load(), new IfEq(), new IfLe(), new IfNEq(), new IfLEq(),
		new GoTo(), new End()};
	
	/**
	 * Parsea los diferentes bytecodes
	 * @param line: Linea de texto a parsear
	 * @return: Devuelve el bytecode ya parseado
	 */
	public static ByteCode parse(String line) {
		boolean found = false;
		int i = 0;
		ByteCode c = null;
		line = line.trim();
		String []words = line.split(" +");
		while (i < byteCodes.length && !found){
			c = byteCodes[i].parse(words);
			if (c != null) found = true;
			else i++;
		}
		return c;
	}
	
}

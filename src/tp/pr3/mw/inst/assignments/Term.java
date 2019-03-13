package tp.pr3.mw.inst.assignments;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.elements.Compiler;

public interface Term {

	Term parse(String term);
	
	ByteCode compile(Compiler compiler);
	
}

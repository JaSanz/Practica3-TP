package tp.pr3.mw.inst.assignments;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.bcOneParameter.Push;
import tp.pr3.mw.elements.Compiler;

public class Number implements Term {

	public int number;
	
	public Number(int i) {
		number = i;
	}

	@Override
	public Term parse(String term) {
		try {
			int number = Integer.parseInt(term);
			return new Number(number);
		}
		catch (NumberFormatException numbEx) {
			System.out.println(term + " no es un caracter válido");
			return null;
		}
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		return new Push(number);
	}
	
	public String toString() {
		return " " + number;
	}

}

package tp.pr3.mw.command;

import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.LexicalAnalysisException;
import tp.pr3.mw.mv.Engine;

public class Compile implements Command {
	
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException {
		engine.compile();
	}
	
	/**
	 * Parsea el comando COMPILE
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("COMPILE")) return new Compile();
		else return null;
	}

	/**
	 * Muestra la ayuda del comando
	 */
	public String textHelp() {
		return " COMPILE: Compila el programa ";
	}
	
	/**
	 * Muestra el nombre del comando
	 */
	public String toString() {
		return "COMPILE" + "";
	}
	
}

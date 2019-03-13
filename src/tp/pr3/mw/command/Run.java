package tp.pr3.mw.command;

import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.ExecutionErrorException;
import tp.pr3.mw.mv.Engine;

public class Run implements Command {

	/**
	 * Inicia la ejecución del conjunto de bytecodes
	 */
	public void execute(Engine engine) throws ExecutionErrorException, ArrayException {
		engine.executeCommandRun();
	}
	
	/**
	 * Parsea el comando RUN
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("RUN")) return new Run();
		else return null;
	}
	
	/**
	 * Muestra la ayuda del comando
	 */
	public String textHelp() {
		return " RUN: Ejecuta el programa ";
	}
	
	/**
	 * Muestra el nombre del comando
	 */
	public String toString() {
		return "RUN" + "";
	}
	
}

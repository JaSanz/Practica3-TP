package tp.pr3.mw.command;

import tp.pr3.mw.mv.Engine;

public class Help implements Command {

	/**
	 * Ejecuta el método "showHelp" para mostrar la ayuda
	 */
	public void execute(Engine engine) {
		engine.showHelp();
	}
	
	/**
	 * Parsea el comando HELP
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("HELP")) return new Help();
		else return null;
	}
	
	/**
	 * Muestra la ayuda del comando
	 */
	public String textHelp() {
		return " HELP: Muestra esta ayuda ";
	}
	
	/**
	 * Muestra el nombre del bytecode
	 */
	public String toString() {
		return "HELP" + "";
	}
	
}

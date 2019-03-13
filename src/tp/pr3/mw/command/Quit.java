package tp.pr3.mw.command;

import tp.pr3.mw.mv.Engine;

public class Quit implements Command {

	/**
	 * Permite cerrar la aplicación
	 */
	public void execute(Engine engine) {
		engine.endExecution();
	}
	
	/**
	 * Parsea el comando QUIT
	 */
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("QUIT")) return new Quit();
		else return null;
	}
	
	/**
	 * Muestra la ayuda del comando
	 */
	public String textHelp() {
		return " QUIT: Cierra la aplicacion ";
	}
	
	/**
	 * Muestra el nombre del comando
	 */
	public String toString() {
		return "QUIT" + "";
	}
	
}

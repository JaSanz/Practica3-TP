package tp.pr3.mw.command;

import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.BadFormatByteCodeException;
import tp.pr3.mw.mv.Engine;

public class ReplaceBC implements Command {
	
	private static int replace;
	
	/**
	 * Reemplaza un bytecode por otro en una posición dada
	 */
	public void execute(Engine engine) throws ArrayException, BadFormatByteCodeException {
		engine.replaceByteCode(replace);
	}
	
	/**
	 * Parsea el comando REPLACE y su número
	 */
	public Command parse(String[] s) throws NumberFormatException {
		try {
			if (s.length == 2 && s[0].equalsIgnoreCase("REPLACE")) {
				String replace = s[1];
				ReplaceBC.replace = Integer.parseInt(replace);
				return new ReplaceBC();
			}
		}
		catch (NumberFormatException numEx) {
			System.out.println("Excepción: El número introducido no es correcto");
		}
		return null;
	}
	
	/**
	 * Muestra la ayuda del comando
	 */
	public String textHelp() {
		return " REPLACEBC N: Reemplaza la instruccion N por la solicitada al usuario ";
	}
	
	/**
	 * Muestra el nombre del comando
	 */
	public String toString() {
		return "REPLACE" + "";
	}
	
}

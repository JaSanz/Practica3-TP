package tp.pr3.mw.command;

import java.io.FileNotFoundException;

import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.mv.Engine;

public class Load implements Command {

	private String file;
	
	public Load(){}
	
	public Load(String fich) {
		file = fich;
	}
	
	@Override
	public void execute(Engine engine) throws FileNotFoundException, ArrayException {
		engine.load(file);
	}
	
	/**
	 * Parsea el comando RUN
	 */
	public Command parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD")) {
			String load = s[1];
			return new Load(load);
		}
		else return null;
	}
	
	/**
	 * Muestra la ayuda del comando
	 */
	public String textHelp() {
		return " LOAD FICH: Lee el fichero de nombre \"Fich\" ";
	}
	
	/**
	 * Muestra el nombre del comando
	 */
	public String toString() {
		return "LOAD " + file + ".txt";
	}

}

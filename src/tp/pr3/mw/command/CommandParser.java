package tp.pr3.mw.command;

public class CommandParser {
	
	private final static Command[] commands = {new Help(), new Quit(), new ReplaceBC(), new Run(),
			new Load(),new Compile()};
	
	/**
	 * Parsea los comandos (Controla el número de palabras para cada instrucción)
	 * @param line: Línea de comando introducida
	 * @return: Devuelve verdadero si interpreta el comando correctamente; null si no
	 */
	public static Command parse(String line) {
		boolean found = false;
		int i = 0;
		Command c = null;
		line = line.trim();
		String []words = line.split(" +");
		while (i < commands.length && !found){
			c = commands[i].parse(words);
			if (c != null) found = true;
			else i++;
		}
		return c;
	}

	/**
	 * Recorre el array de comandos para imprimir su ayuda
	 */
	public static void showHelp() {
		for (int i = 0; i < CommandParser.commands.length; i++) {
			System.out.println(CommandParser.commands[i].textHelp());
		}
	 }
	
}

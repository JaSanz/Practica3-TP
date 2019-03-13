package tp.pr3.mw.mv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tp.pr3.mw.byteCode.ByteCode;
import tp.pr3.mw.byteCode.ByteCodeParser;
import tp.pr3.mw.byteCode.ByteCodeProgram;
import tp.pr3.mw.command.Command;
import tp.pr3.mw.command.CommandParser;
import tp.pr3.mw.elements.CPU;
import tp.pr3.mw.elements.Compiler;
import tp.pr3.mw.elements.LexicalParser;
import tp.pr3.mw.exceptions.ArrayException;
import tp.pr3.mw.exceptions.BadFormatByteCodeException;
import tp.pr3.mw.exceptions.ExecutionErrorException;
import tp.pr3.mw.exceptions.LexicalAnalysisException;

public class Engine {
	
	private boolean end; // controla que no se ha ejecutado el comando QUIT
	
	private CPU cpu;
	private ByteCodeProgram bcProgram;
	private SourceProgram sProgram;
	private ParsedProgram pProgram;
	private LexicalParser lexicalParser;
	private Compiler compiler;
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Constructora
	 */
	public Engine(){
		this.bcProgram = new ByteCodeProgram();
		this.end = false;
		this.cpu = new CPU(bcProgram);
		this.sProgram = new SourceProgram();
		this.pProgram = new ParsedProgram();
		this.lexicalParser = new LexicalParser();
		this.compiler = new Compiler();
	}
	
	/**
	 * Se encarga de recibir los comandos hasta que recibe "QUIT", que cierra la aplicación
	 * @throws ExecutionErrorException 
	 */
	public void start() {
		this.end = false;
		String line = "";
		while (!end) {
			System.out.print("> ");
			try {
				Command command = null;
				line = in.nextLine();
				line = line.trim();
				command = CommandParser.parse(line);
				if (command == null) System.out.print("Error: Comando incorrecto" +
					System.getProperty("line.separator") + this.sProgram.toString() +
					this.bcProgram.toString());
				else {
					System.out.println("Comienza la ejecución de " + command.toString());
					if (line.equalsIgnoreCase("BYTECODE")) System.out.println("Introduce el bytecode. " +
					"Una instrucción por línea");
					else if (line.equalsIgnoreCase("BYTECODE")) command.textHelp();
					command.execute(this);
					if (sProgram.getSize() > 0) System.out.println(sProgram.toString());
					if (bcProgram.getNumberOfByteCodes() > 0) System.out.println(bcProgram.toString());
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Fin de la ejecucion....");
		in.close();
		System.exit(0);
		
	}
	
	/**
	 * Ejecuta el comando "RUN"
	 * @return: Devuelve verdadero si "RUN" se ha ejecutado correctamente y falso en el caso contrario
	 */
	public void executeCommandRun() throws ExecutionErrorException, ArrayException {
		this.cpu.reset();
		cpu.run();
		System.out.println(this.cpu.toString());
	}
	
	/**
	 * Lee un bytecode y muestra si es correcto o no
	 * @return: Devuelve verdadero siempre
	 * @throws ArrayException 
	 */
	public boolean readByteCodeProgram() throws ArrayException {
		String line = "";
		while (!line.equalsIgnoreCase("END")) {
			ByteCode byteCode = null;
			line = in.nextLine();
			line = line.trim();
			byteCode = ByteCodeParser.parse(line);
			if (byteCode == null) System.out.println("Error: ByteCode incorrecto");
			else if (!line.equalsIgnoreCase("END")) addByteCodeInstruction(byteCode);
		}
		return true;
	}
	
	/**
	 * LLama al método que muestra la ayuda
	 * @return: Devuelve verdadero
	 */
	public boolean showHelp() {
		CommandParser.showHelp();
		return true;
	}
	
	/**
	 * Acaba la ejecución
	 * @return: Devuelve el valor del atributo "end", que es verdadero
	 */
	public boolean endExecution() {
		this.end = true;
		return end;
	}
	
	/**
	 * Añade una instrucción bytecode
	 * @param bc: Bytecode a introducir
	 * @return: Devuelve verdadero
	 * @throws ArrayException 
	 */
	public boolean addByteCodeInstruction(ByteCode bc) throws ArrayException {
		return bcProgram.addBCInstruction(bc);
	}
	
	private void lexicalAnalysis() throws ArrayException, LexicalAnalysisException {
		lexicalParser.initialize(sProgram);
		lexicalParser.lexicalParser(pProgram, "END");
	}
	
	private void generateByteCode() throws ArrayException {
		compiler.compile(this.pProgram);
	}
	
	public void compile() throws LexicalAnalysisException, ArrayException {
		try {
			if (sProgram.getSize() == 0) throw new ArrayException ("Excepción: No hay elementos que compilar");
			compiler.reset();
			this.lexicalAnalysis();
			this.generateByteCode();
		}
		catch (ArrayException ArrEx) {
			System.out.println(ArrEx.getMessage());
		}
	}

	public void load(String file) throws FileNotFoundException, ArrayException {
		Scanner sc = null;
		sProgram.reset();
		pProgram.reset();
		bcProgram.reset();
		lexicalParser.reset();
		try {
			sc = new Scanner(new File(file + ".txt"));
			String linea;
			linea = sc.nextLine();
			while (linea != null && !linea.equalsIgnoreCase("END")) {
				sProgram.addInstr(linea);
				linea = sc.nextLine();
				if (sProgram.getSize() >= 100) throw new ArrayException("Excepción: Se ha excedido el tamaño límite de instrucciones");				
			}
			sProgram.addInstr(linea);
		}
		catch (ArrayException arrEx) {
			System.out.println(arrEx.getMessage());
			sProgram.reset();
		}
		catch (FileNotFoundException FilEx) {
			System.out.println("Excepción: El fichero que intentas leer no existe");
		}
		finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
	
	/**
	 * Reemplaza una instrucción bytecode por otra
	 * @param replace: Posición que se quiere reemplazar
	 * @return: Devuelve verdadero si se ha ejecutado correctamente; falso en caso contrario
	 */
	public void replaceByteCode(int replace) throws BadFormatByteCodeException, ArrayException {
		if (replace > bcProgram.getNumberOfByteCodes()) throw new ArrayException("Excepción: No se pueden añadir más ByteCodes"); 
		System.out.print("Nueva instrucción: ");
		String linea = in.nextLine();
		ByteCode bc = ByteCodeParser.parse(linea);
		if (bc == null) throw new BadFormatByteCodeException("Excepción: El ByteCode introducido no es válido");
		this.bcProgram.replace(replace, bc);
	}
	
}

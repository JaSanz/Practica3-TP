package tp.pr3.mw.byteCode;

public abstract class ByteCodeOneParameter implements ByteCode {

	protected int param;
	
	/**
	 * Constructora
	 */
	public ByteCodeOneParameter(){};
	
	/**
	 * Constructora de un par�metro
	 * @param p: Par�metro que recibe para asign�rselo al atributo "param"
	 */
	public ByteCodeOneParameter(int p){
		this.param = p;
	}
	
	/**
	 * Comprueba que el bytecode introducido tiene dos par�metros
	 */
	@Override
	public ByteCode parse(String[] words) {
		if (words.length!=2) return null;
		else return this.parseAux(words[0],words[1]);
	}
	
	abstract protected ByteCode parseAux(String string1, String string2);
	
	/**
	 * Devuelve el nombre del bytecode y su par�metro
	 */
	public String toString(){
		return this.toStringAux() + " " + this.param;
	}
	
	abstract protected String toStringAux();
	
}

package tp.pr3.mw.byteCode;

public abstract class ByteCodeOneParameter implements ByteCode {

	protected int param;
	
	/**
	 * Constructora
	 */
	public ByteCodeOneParameter(){};
	
	/**
	 * Constructora de un parámetro
	 * @param p: Parámetro que recibe para asignárselo al atributo "param"
	 */
	public ByteCodeOneParameter(int p){
		this.param = p;
	}
	
	/**
	 * Comprueba que el bytecode introducido tiene dos parámetros
	 */
	@Override
	public ByteCode parse(String[] words) {
		if (words.length!=2) return null;
		else return this.parseAux(words[0],words[1]);
	}
	
	abstract protected ByteCode parseAux(String string1, String string2);
	
	/**
	 * Devuelve el nombre del bytecode y su parámetro
	 */
	public String toString(){
		return this.toStringAux() + " " + this.param;
	}
	
	abstract protected String toStringAux();
	
}

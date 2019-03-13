package tp.pr3.mw.elements;

public class Memory {
	
	private Integer[] memory; //Array de la memoria
	private final static int MAX_MEM = 200; //Tama�o m�ximo del array de la memoria al inicio del programa
	private int size; //Tama�o del array la memoria
	private boolean empty; //Controla si la pila est� o no vac�a
	
	/**
	 * Constructora
	 */
	public Memory() {
		this.empty = true;
		this.memory = new Integer[Memory.MAX_MEM];
		this.size = Memory.MAX_MEM;
		for (int  i = 0; i < this.size; i++) this.memory[i] = null;
	}
	
	/**
	 * Aumenta el tama�o de la memoria duplicando la posici�n introducida
	 * @param pos: Posici�n a partir de la cu�l se duplica el tama�o
	 */
	private void resize(int pos) {
			Integer[] arrayAuxiliar = new Integer[pos * 2];
			
			for (int i = 0; i < this.size; ++i) arrayAuxiliar[i] = this.memory[i];
			for (int i = this.size; i < pos; ++i) arrayAuxiliar[i] = null;
			this.memory = arrayAuxiliar;
			this.size = pos * 2;
	}
	
	public int getSizeMemory() {
		return this.size;
	}
	
	/**
	 * Determina si el valos de la memoria en una posici�n existe o no
	 * @param pos: Posici�n para ver si est� o no ocupada
	 * @return: Devuelve verdadero si la posici�n existe; falso en caso contrario
	 */
	public boolean getMemory(int pos) {
		if (memory[pos] != null) return true;
		else return false;
	}
	
	/**
	 * Escribe un valor en una determinada posici�n de la memoria
	 * @param pos: Posici�n donde se quiere escribir el valor
	 * @param value: Valor a introducir
	 * @return: Devuelve verdadero si la operaci�n se ha ejecutado correctamente
	 */
	public boolean write(int pos, int value) {
		if (pos >= size) resize(pos);
		memory[pos] = value;
		empty = false;
		return true;
	}
	
	/**
	 * Lee el valor de la memoria en una posici�n a introducir
	 * @param pos: Posici�n de la que se quiere leer el valor
	 * @return: Devuelve el valor de la posici�n introducida de la memoria
	 */
	public Integer read(int pos) {
		if (pos >= size || memory[pos] == null) return null;
		return memory[pos];
	}
	
	/**
	 * Resetea la memoria
	 */
	public void reset() {
		this.empty = true;
		this.memory = new Integer[Memory.MAX_MEM];
		this.size = Memory.MAX_MEM;
		for (int  i = 0; i < this.size; i++) this.memory[i] = null;
	}
	
	/**
	 * Devuelve los elementos de la memoria, siendo "vac�a" si no hay nada en ella
	 */
	public String toString() {
		if (this.empty) return "<vacia>";
		else {
			String s = "";
			for (int i = 0; i < this.size; i++)
				if (this.memory[i] != null) s = s + " [" + i + "]:" + this.memory[i];
			return s;
		}
	}

}
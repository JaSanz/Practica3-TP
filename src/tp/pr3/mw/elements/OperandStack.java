package tp.pr3.mw.elements;

import tp.pr3.mw.exceptions.StackException;

public class OperandStack {
	
	public static final int MAX_STACK = 100; //Numero máximo de elementos de la pila
	public int numElems; //Número de elementos usados de la pila. Posición
	private int[] stack; //Array de la pila
	
	/**
	 * Constructora
	 */
	public OperandStack(){
		this.numElems = 0;
		this.stack = new int [OperandStack.MAX_STACK];
	}
	
	/**
	 * Comprueba si la pila está vacía
	 * @return: Falso si numElems es distinto de 0, y verdadero si es 0
	 */
	public boolean isEmpty() {
		return numElems == 0;
	}
	
	/**
	 * Introduce un número en la cima de la pila
	 * @param value: Valor a introducir
	 * @return: Verdadero si la operación se ha ejecutado correctamente. Falso en el caso contrario
	 */
	public boolean push(int value) throws StackException {
		try {
			if (numElems == MAX_STACK) throw new StackException("Excepción: Se ha superado el número de elementos máximo de la pila");
			this.stack[this.numElems] = value;
			++this.numElems;
			return true;
		}
		catch (StackException stEx) {
			System.out.println(stEx.getMessage());
			return false;
		}
	}
	
	/**
	 * Quita la cima de la pila y la devuelve
	 * @return: Devuelve la cima de la pila si hay valores en ella; null si no hay nada
	 */
	public Integer pop() throws StackException {
		try{
			if (isEmpty()) throw new StackException("Excepción: La pila no tiene suficientes elementos");
			--this.numElems;
			return this.stack[this.numElems];
		}
		catch (StackException stEx) {
			System.out.println(stEx.getMessage());
			return null;
		}
	}
	
	/**
	 * Permite coger el último valor de la pila
	 * @return: Devuelve el último número de la pila sin hacer nada sobre él
	 */
	public int getNumStack() {
		return stack[numElems - 1];
	}
	
	/**
	 * Permite saber cuántos elementos tiene la pila
	 * @return: Devuelve el número de espacios ocupados de la pila
	 */
	public int getNumElems() {
		return this.numElems;
	}
	
	/**
	 * Resetea la pila
	 */
	public void reset() {
		numElems = 0;
	}
	
	/**
	 * Devuelve los elementos de la pila, siendo "vacía" si no hay nada en ella
	 */
	public String toString() {
		if (this.numElems == 0) return "<vacia>";
		else {
			String s = "";
			for (int i = 0; i < this.numElems; ++i) s = s + this.stack[i] + " ";
			return s;
		}
	}

}
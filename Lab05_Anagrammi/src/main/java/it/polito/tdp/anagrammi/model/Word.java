package it.polito.tdp.anagrammi.model;

public class Word {
	private String word;
	private boolean valida;

	/**
	 * @param word
	 */
	public Word(String word, boolean valida) {
		super();
		this.word = word;
		this.valida=valida;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the valida
	 */
	public boolean isValida() {
		return valida;
	}

	/**
	 * @param valida the valida to set
	 */
	public void setValida(boolean valida) {
		this.valida = valida;
	}

	@Override
	public String toString() {
		return word ;
	}
	
	
	

}

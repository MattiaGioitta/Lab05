package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO dao = new AnagrammaDAO();
	
	List<String> soluzione;
	List<Word> soluz;
	
	/**
	 * Metodo con cui il controller passa la parola e restiuisce
	 * una lista di anagrammi come soluzioni
	 * @param parola parola inserita dall'utente
	 * @return lista di soluzioni
	 */
	public List<Word> anagramma(String parola){
		this.soluzione = new ArrayList<String>();
		this.soluz= new ArrayList<Word>();
		parola = parola.toLowerCase();
		List<Character> disponibili = new ArrayList<Character>();
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		cerca("",0,disponibili);
		for(String s : this.soluzione) {
			if(this.dao.isCorrect(s)==true) {
				soluz.add(new Word(s,true));
			}
			else {
				soluz.add(new Word(s,false));
			}
		}
		
		return this.soluz;
	}

	/**
	 * Procedura ricorsiva per il calcolo degli anagrammi
	 * @param parziale parte iniziale dell'anagramma costruito nel passo precedente
	 * @param livello livello della ricorsione, sempre uguale a parametro.lenghth() 
	 * @param disponibili insieme delle lettere non ancora utilizzate
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		//condizione di terminazione
		if(disponibili.size()==0) {
			this.soluzione.add(parziale);
		}
		//caso normale
		for(Character ch : disponibili) {
			String tentativo = parziale + ch ;
		
			List<Character> rimanenti = new ArrayList<Character>(disponibili);
			rimanenti.remove(ch);
			cerca(tentativo,livello+1,rimanenti);
		}
			
		}
	
	
	
	
	
	
	}



package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		List<Word> soluzione = model.anagramma("abaco");
		System.out.println("Valide");
		for(Word s : soluzione) {
			if(s.isValida()==true) {
				System.out.println(s+"\n");
			}
		}
		
		System.out.println(" Non Valide");
		for(Word s : soluzione) {
			if(s.isValida()==false) {
				System.out.println(s+"\n");
			}
		}
		
	}

}

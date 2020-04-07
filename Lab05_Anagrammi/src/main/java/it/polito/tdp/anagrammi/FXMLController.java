package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnAnagramCalculator;

    @FXML
    private TextArea txtRightAnagram;

    @FXML
    private TextArea txtWrongAnagram;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramCalculate(ActionEvent event) {
    	this.txtRightAnagram.clear();
    	this.txtWrongAnagram.clear();
    	String parola = this.txtWord.getText();
    	List<Word> soluzione = this.model.anagramma(parola);
		for(Word s : soluzione) {
			if(s.isValida()==true) {
				this.txtRightAnagram.appendText(s+"\n");
			}
			else if(s.isValida()==false) {
				this.txtWrongAnagram.appendText(s+"\n");				
			}
		}
		

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtWord.clear();
    	this.txtRightAnagram.clear();
    	this.txtWrongAnagram.clear();

    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagramCalculator != null : "fx:id=\"btnAnagramCalculator\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRightAnagram != null : "fx:id=\"txtRightAnagram\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWrongAnagram != null : "fx:id=\"txtWrongAnagram\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}

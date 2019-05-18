/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	private Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		this.txtResult.clear();
		try {
			int anno = Integer.parseInt(this.txtAnno.getText());
	    	if(anno<1816 || anno>2016) {
	    		this.txtResult.setText("Inserire una data nel periodo corretto!");
	    	}
	    	else {
	    		model.creaGrafo(anno);
	    		Map<Country, Integer> statiConfinanti = model.getConfini();
	    		for(Country c : statiConfinanti.keySet()) {
	    			this.txtResult.appendText(c.getStateName()+" "+statiConfinanti.get(c)+"\n");
	    		}
	    		this.txtResult.appendText("Numero di componenti connesse: "+model.componentiConnesse());
	    	}
    		} catch(NumberFormatException c) {
	    		txtResult.setText("Inserire una numero di lettere valido");
	    	} catch(RuntimeException e ) {
	    		txtResult.setText("Errore di connessione al database!");
	    	}
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
	}

	public void setModel(Model model) {
		this.model=model;
		
	}
}

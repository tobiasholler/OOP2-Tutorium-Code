package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SampleController {
	//@FXML
	//private ResourceBundle resources;
	//@FXML
	//private URL location;
	@FXML
	private Label lblKandidat;
	@FXML
	private Label lblHeld;
	@FXML
	private ListView<String> listViewK;
	protected ArrayList<String> myListK = new ArrayList<>();
	protected ListProperty<String> listPropertyK = new SimpleListProperty<>();
	@FXML
	private ListView<String> listViewH;
	protected ArrayList<String> myListH = new ArrayList<>();
	protected ListProperty<String> listPropertyH = new SimpleListProperty<>();
	@FXML
	private Button btnTo;
	@FXML
	private Button btnBack;

	@FXML
	void getBack(ActionEvent event) {
		String selected = listViewH.getSelectionModel().getSelectedItem();
		if (selected != null) {
			listViewH.getSelectionModel().clearSelection();
			myListH.remove(selected);
			myListK.add(selected);
			listViewK.itemsProperty().bind(listPropertyK);
			listPropertyK.set(FXCollections.observableArrayList(myListK));
			listViewH.itemsProperty().bind(listPropertyH);
			listPropertyH.set(FXCollections.observableArrayList(myListH));
		}
		System.out.println("Back to the Roots");
	}

	@FXML
	void putHeroes(ActionEvent event) {
		String selected = listViewK.getSelectionModel().getSelectedItem();
		if (selected != null) {
			listViewK.getSelectionModel().clearSelection();
			myListK.remove(selected);
			myListH.add(selected);
			listViewK.itemsProperty().bind(listPropertyK);
			listPropertyK.set(FXCollections.observableArrayList(myListK));
			listViewH.itemsProperty().bind(listPropertyH);
			listPropertyH.set(FXCollections.observableArrayList(myListH));
		}
		System.out.println("auf zu den Helden");
	}

	@FXML
	void initialize() {
//		assert lblKandidat != null : "fx:id=\"lblKandidat\" was not injected: check your FXML file 'Sample.fxml'.";
//		assert lblHeld != null : "fx:id=\"lblHeld\" was not injected: check your FXML file 'Sample.fxml'.";
//		assert listViewK != null : "fx:id=\"listViewK\" was not injected: check your FXML file 'Sample.fxml'.";
//		assert listViewH != null : "fx:id=\"listViewH\" was not injected: check your FXML file 'Sample.fxml'.";
//		assert btnTo != null : "fx:id=\"btnTo\" was not injected: check yourFXML file 'Sample.fxml'.";
//		assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'Sample.fxml'.";
		myListK.add("Supermann");
		myListK.add("Spidermann");
		myListK.add("Politiker");
		myListK.add("Pfarrer");
		myListK.add("Werwolf");
		myListK.add("Polizist");
		myListK.add("Soldat");
		myListK.add("Lehrer");
		listViewK.itemsProperty().bind(listPropertyK);
		listPropertyK.set(FXCollections.observableArrayList(myListK));
	}
}

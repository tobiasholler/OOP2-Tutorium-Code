package application;

import java.util.ArrayList;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class HeldenController {

	@FXML
	private ListView<String> kandidatenListView;

	@FXML
	private Button zuHeldenButton;

	@FXML
	private Button zuKandidatenButton;

	@FXML
	private ListView<String> heldenListView;

	private ArrayList<String> kandidatenArray;
	private ArrayList<String> heldenArray;

	// private SimpleListProperty<String> kandidatenListProperty;
	// private SimpleListProperty<String> heldenListProperty;

	@FXML
	void initialize() {
		kandidatenArray = new ArrayList<String>();
		heldenArray = new ArrayList<String>();

		// kandidatenListProperty = new SimpleListProperty<String>();
		// heldenListProperty = new SimpleListProperty<String>();

		kandidatenArray.add("1");
		kandidatenArray.add("2");
		kandidatenArray.add("3");
		kandidatenArray.add("4");
		kandidatenArray.add("5");
		kandidatenArray.add("6");

		// kandidatenListView.itemsProperty().bind(kandidatenListProperty);
		// heldenListView.itemsProperty().bind(heldenListProperty);

		// kandidatenListProperty.set(FXCollections.observableArrayList(kandidatenArray));
		// heldenListProperty.set(FXCollections.observableArrayList(heldenArray));

		kandidatenListView.setItems(FXCollections.observableArrayList(kandidatenArray));
	}

	@FXML
	void zuHeldenHinzu(ActionEvent event) {
		int selectedItemIndex = kandidatenListView.getSelectionModel().getSelectedIndex();
		if (selectedItemIndex >= 0) {
			System.out.println(selectedItemIndex);
			String removed = kandidatenArray.remove(selectedItemIndex);
			heldenArray.add(removed);
			kandidatenListView.setItems(FXCollections.observableArrayList(kandidatenArray));
			heldenListView.setItems(FXCollections.observableArrayList(heldenArray));
		}
	}

	@FXML
	void zuKandidatenHinzu(ActionEvent event) {
		int selectedItemIndex = heldenListView.getSelectionModel().getSelectedIndex();
		if (selectedItemIndex >= 0) {
			System.out.println(selectedItemIndex);
			String removed = heldenArray.remove(selectedItemIndex);
			kandidatenArray.add(removed);
			kandidatenListView.setItems(FXCollections.observableArrayList(kandidatenArray));
			heldenListView.setItems(FXCollections.observableArrayList(heldenArray));
		}
	}

}

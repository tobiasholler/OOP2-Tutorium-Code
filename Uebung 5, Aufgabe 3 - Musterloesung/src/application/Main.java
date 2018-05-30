package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Übung ListFX");
			Group root = new Group();
			Scene scene = new Scene(root, 400, 250, Color.WHITE);
			// create a grid pane
			GridPane gridpane = new GridPane();
			gridpane.setPadding(new Insets(5));
			gridpane.setHgap(10);
			gridpane.setVgap(10);
			// candidates label
			Label candidatesLbl = new Label("Kandidaten");
			GridPane.setHalignment(candidatesLbl, HPos.CENTER);
			gridpane.add(candidatesLbl, 0, 0);
			Label heroesLbl = new Label("Helden");
			gridpane.add(heroesLbl, 2, 0);
			GridPane.setHalignment(heroesLbl, HPos.CENTER);
			// candidates
			final ObservableList<String> candidates = FXCollections.observableArrayList("Superman", "Spiderman",
					"Werwolf", "Polizei", "Feuerwehr", "Soldaten", "Eltern", "Doktor", "Politiker", "Pfarrer",
					"Lehrer");
			final ListView<String> candidatesListView = new ListView<String>(candidates);
			candidatesListView.setPrefWidth(150);
			candidatesListView.setPrefHeight(150);
			gridpane.add(candidatesListView, 0, 1);
			// heros
			final ObservableList<String> heroes = FXCollections.observableArrayList();
			final ListView<String> heroListView = new ListView<String>(heroes);
			heroListView.setPrefWidth(150);
			heroListView.setPrefHeight(150);
			gridpane.add(heroListView, 2, 1);
			// Auswahl von Helden
			Button sendRightButton = new Button(">");
			sendRightButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					String potential = candidatesListView.getSelectionModel().getSelectedItem();
					if (potential != null) {
						candidatesListView.getSelectionModel().clearSelection();
						candidates.remove(potential);
						heroes.add(potential);
					}
				}
			});
			// Abwahl von Helden
			Button sendLeftButton = new Button("<");
			sendLeftButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					String notHero = heroListView.getSelectionModel().getSelectedItem();
					if (notHero != null) {
						heroListView.getSelectionModel().clearSelection();
						heroes.remove(notHero);

						candidates.add(notHero);
					}
				}
			});
			// Sortieren von Helden
			Button sortButton = new Button("Sortieren");
			sortButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					String potential = heroListView.getSelectionModel().getSelectedItem();
					if (potential != null) {
						heroes.remove(potential);
						heroes.add(potential);
					}
				}
			});
			VBox vbox = new VBox(5);
			vbox.getChildren().addAll(sendRightButton, sendLeftButton);
			gridpane.add(vbox, 1, 1);
			GridPane.setConstraints(vbox, 1, 1, 1, 2, HPos.CENTER, VPos.CENTER);
			root.getChildren().add(gridpane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
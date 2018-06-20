package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		MenuBar menuBar = new MenuBar();
		root.setTop(menuBar);
		Menu dateiMenu = new Menu("Datei");
		Menu themeMenu = new Menu("Themen");
		menuBar.getMenus().addAll(dateiMenu, themeMenu);
		MenuItem closeItem = new MenuItem("Schlieﬂen");
		closeItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		dateiMenu.getItems().add(closeItem);
		MenuItem diamondStyleItem = new MenuItem("Diamond Style");
		diamondStyleItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add(getClass().getResource("diamond.css").toExternalForm());
			}
		});
		themeMenu.getItems().add(diamondStyleItem);
		MenuItem circleStyleItem = new MenuItem("Circle Style");
		circleStyleItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add(getClass().getResource("circle.css").toExternalForm());
			}
		});
		themeMenu.getItems().add(circleStyleItem);
		MenuItem gridStyleItem = new MenuItem("Grid Style");
		gridStyleItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add(getClass().getResource("grid.css").toExternalForm());
			}
		});
		themeMenu.getItems().add(gridStyleItem);
		
		Button standardButton = new Button("Standard");
		standardButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			}
		});
		root.setCenter(standardButton);
		
		Pagination peggy = new Pagination(10);
		root.setBottom(peggy);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		ToolBar toolBar = new ToolBar();
		AnchorPane anchorPane = new AnchorPane();
		root.setTop(toolBar);
		root.setCenter(anchorPane);
		ComboBox comboBox = new ComboBox();
		TextField textField = new TextField();
		Button button = new Button();
		toolBar.getItems().addAll(comboBox, textField, button);
		comboBox.getItems().addAll("Blau", "Rot", "Grün");
		comboBox.setValue("Blau");
		Label label = new Label("Gesamtanzahl: 0");
		anchorPane.getChildren().add(label);
		AnchorPane.setTopAnchor(label, 20.0);
		AnchorPane.setLeftAnchor(label, 30.0);
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		anchorPane.getChildren().add(hBox);
		AnchorPane.setLeftAnchor(hBox, 50.0);
		AnchorPane.setBottomAnchor(hBox, 20.0);
		AnchorPane.setRightAnchor(hBox, 50.0);
		AnchorPane.setTopAnchor(hBox, 60.0);
		
		hBox.setSpacing(22.0);
		VBox roteVBox = new VBox();
		roteVBox.setAlignment(Pos.BOTTOM_CENTER);
		Label rotesLabel = new Label("0");
		Rectangle rotesRechteck = new Rectangle(50.0, 1.0, Color.RED);
		roteVBox.getChildren().addAll(rotesLabel, rotesRechteck);
		hBox.getChildren().add(roteVBox);

		VBox blaueVBox = new VBox();
		blaueVBox.setAlignment(Pos.BOTTOM_CENTER);
		Label blauesLabel = new Label("0");
		Rectangle blauesRechteck = new Rectangle(50.0, 1.0, Color.BLUE);
		blaueVBox.getChildren().addAll(blauesLabel, blauesRechteck);
		hBox.getChildren().add(blaueVBox);
		
		VBox grueneVBox = new VBox();
		grueneVBox.setAlignment(Pos.BOTTOM_CENTER);
		Label gruenesLabel = new Label("0");
		Rectangle gruenesRechteck = new Rectangle(50.0, 1.0, Color.GREEN);
		grueneVBox.getChildren().addAll(gruenesLabel, gruenesRechteck);
		hBox.getChildren().add(grueneVBox);
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

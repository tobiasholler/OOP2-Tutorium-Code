package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.geometry.Insets;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		VBox vbx = new VBox();
		vbx.setSpacing(10);
		vbx.setPadding(new Insets(20));
		AnchorPane root = new AnchorPane();
		root.getChildren().add(vbx);
		root.setRightAnchor(vbx, 10.0);
		root.setBottomAnchor(vbx, 20.0);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("RadioButton Beispiel");
		ToggleGroup group = new ToggleGroup();
		RadioButton btn1 = new RadioButton("Heute");
		btn1.setToggleGroup(group);
		btn1.setSelected(true);
		RadioButton btn2 = new RadioButton("Morgen");
		btn2.setToggleGroup(group);
		RadioButton btn3 = new RadioButton("Immer");
		btn3.setToggleGroup(group);
		vbx.getChildren().add(btn1);
		vbx.getChildren().add(btn2);
		vbx.getChildren().add(btn3);
		scene.setRoot(root);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
package application;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		int startWert = 50;

		VBox root = new VBox(10);
		root.setPadding(new Insets(20));
		Scene scene = new Scene(root);
		Slider slider = new Slider();
		slider.setValue(startWert);
		root.getChildren().add(slider);
		TextField textField = new TextField();
		textField.setText(startWert + "");
		root.getChildren().add(textField);
		
		
		//slider.valueProperty().bindBidirectional(textField.textProperty(),
		//		NumberFormat.getNumberInstance());
		CheckBox checkBox = new CheckBox();
		checkBox.setText("Synchronisieren");
		checkBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (checkBox.isSelected()) {
					textField.textProperty().bindBidirectional(slider.valueProperty(),
							NumberFormat.getNumberInstance());
				} else {
					Bindings.unbindBidirectional(textField.textProperty(),
							slider.valueProperty());
				}
			}
		});
		root.getChildren().add(checkBox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

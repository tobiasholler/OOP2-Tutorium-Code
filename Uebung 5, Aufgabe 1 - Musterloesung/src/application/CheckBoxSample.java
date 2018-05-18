package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

public class CheckBoxSample extends Application {
	final String[] names = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	final CheckBox[] cbs = new CheckBox[names.length];

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		for (int i = 0; i < names.length; i++) {
			final CheckBox cb = cbs[i] = new CheckBox(names[i]);
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
				public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
					System.out.println(cb.getText() + " " + old_val + "->" + new_val);
				}
			});
		}
		VBox vbox = new VBox();
		vbox.getChildren().addAll(cbs);
		vbox.setSpacing(10);
		Scene scene = new Scene(new ScrollPane(vbox));
		stage.setTitle("Checkbox Beispiel");
		stage.setScene(scene);
		stage.show();
	}
}
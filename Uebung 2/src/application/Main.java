package application;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void init() throws Exception {
		Parameters p = getParameters();
		Map<String, String> named = p.getNamed();
		Set<String> keySet = named.keySet();
		for (String key : keySet) {
			System.out.println("HelloWorld Parameter: " + key + " Wert: " + named.get(key));
		}

		List<String> unnamed = p.getUnnamed();
		for (String param : unnamed) {
			System.out.println(param + param + " essen");
		}
	}

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

		Stage neuesFenster = new Stage();
		neuesFenster.initOwner(primaryStage);
		// neuesFenster.initModality(Modality.WINDOW_MODAL);
		// neuesFenster.initStyle(StageStyle.TRANSPARENT);
		neuesFenster.setTitle("unser neues Fenster");
		String s = neuesFenster.getTitle();

		StackPane neuesLayout = new StackPane();
		Scene neueScene = new Scene(neuesLayout);
		neuesFenster.setScene(neueScene);

		Label nachrichtenLabel = new Label();
		if (primaryStage.isResizable() == false)
			nachrichtenLabel.setText("ich bleibe gleich");
		else
			nachrichtenLabel.setText("ich bin anpassungsfähig");

		neuesLayout.getChildren().add(nachrichtenLabel);

		neuesFenster.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}

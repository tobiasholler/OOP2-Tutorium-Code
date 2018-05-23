package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		AnchorPane ac = new AnchorPane();
		VBox root = new VBox();
		root.setSpacing(10);
		ac.getChildren().add(root);
		AnchorPane.setRightAnchor(root, 20.0);
		AnchorPane.setBottomAnchor(root, 20.0);
		Scene scene = new Scene(ac, 400, 400);
		
		RadioButton rb1 = new RadioButton("Heute");
		root.getChildren().add(rb1);
		
		RadioButton rb2 = new RadioButton("Morgen");
		root.getChildren().add(rb2);
		
		RadioButton rb3 = new RadioButton("Immer");
		root.getChildren().add(rb3);
		
		ToggleGroup gruppe = new ToggleGroup();
		rb1.setToggleGroup(gruppe);
		rb2.setToggleGroup(gruppe);
		rb3.setToggleGroup(gruppe);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Radio Button Beispiel");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

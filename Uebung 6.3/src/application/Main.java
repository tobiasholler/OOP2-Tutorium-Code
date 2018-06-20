package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Konto konto = new Konto();
	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		Scene scene = new Scene(root);
		Button plusButton = new Button("+0.01");
		plusButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (konto.getKontostand() < 1) 
					konto.setKontostand(konto.getKontostand()+0.01);
			}
		});
		Button minusButton = new Button("-0.01");
		minusButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (konto.getKontostand() > 0.01) {
					double kontostand = konto.getKontostand();
					kontostand = kontostand - 0.01;
					konto.setKontostand(kontostand);
				}
			}
		});
		ProgressBar progressBar = new ProgressBar();
		//progressBar.setProgress(konto.getKontostand());
		progressBar.progressProperty().bind(konto.kontostandProperty());
		ProgressIndicator progressIndicator = new ProgressIndicator();
		//progressIndicator.setProgress(konto.getKontostand());
		progressIndicator.progressProperty().bind(konto.kontostandProperty());
		root.add(plusButton, 0, 0);
		root.add(minusButton, 1, 0);
		root.add(progressBar, 0, 1);
		root.add(progressIndicator, 1, 1);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package application;
	
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	final String[] names = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	final CheckBox[] cbs = new CheckBox[names.length];
	@Override
	public void start(Stage primaryStage) {

		VBox layout = new VBox();
		Scene scene = new Scene(layout);
		
		for (int i = 0; i < names.length; i++) {
			CheckBox cb = new CheckBox();
			cb.setText(names[i]);
			cbs[i] = cb;
			BooleanProperty prop = cb.selectedProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable,
						Boolean oldValue, Boolean newValue) {
					System.out.println(cb.getText() + " " + newValue);
				}
			});
			layout.getChildren().add(cb);
		}
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root, 400, 400);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public static void main(String[] args) {

		launch(args);
	}
}

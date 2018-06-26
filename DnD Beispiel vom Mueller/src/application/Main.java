package application;
	

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;





public class Main extends Application {
	final Text source = new Text(50, 100, "Zieh mich");
	final Text target = new Text(300, 100, "Hier her");
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			root.getChildren().addAll(source,target);
			source.setOnDragDetected(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent event) {
			        /* drag was detected, start a drag-and-drop gesture*/
			        /* allow any transfer mode */
			        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
			        
			        /* Put a string on a dragboard */
			        ClipboardContent content = new ClipboardContent();
			        content.putString(source.getText());
			        db.setContent(content);
		
			        event.consume();
			        source.setCursor(javafx.scene.Cursor.OPEN_HAND);
			    }
			});
			target.setOnDragOver(new EventHandler<DragEvent>() {
			    public void handle(DragEvent event) {
			        /* data is dragged over the target */
			        /* accept it only if it is not dragged from the same node 
			         * and if it has a string data */
			        if (event.getGestureSource() != target &&
			                event.getDragboard().hasString()) {
			            /* allow for moving */
			            event.acceptTransferModes(TransferMode.MOVE);
					     
			        }
			        
			        event.consume();
			    }
			});
			target.setOnDragEntered(new EventHandler<DragEvent>() {
			    public void handle(DragEvent event) {
			    /* the drag-and-drop gesture entered the target */
			    /* show to the user that it is an actual gesture target */
			         if (event.getGestureSource() != target &&
			                 event.getDragboard().hasString()) {
			             target.setFill(Color.GREEN);
			         }
			                
			         event.consume();
				    	
			    }
			});
			
			target.setOnDragExited(new EventHandler<DragEvent>() {
			    public void handle(DragEvent event) {
			        /* mouse moved away, remove the graphical cues */
			        target.setFill(Color.BLACK);

			        event.consume();
			    }
			});
			target.setOnDragDropped(new EventHandler<DragEvent>() {
			    public void handle(DragEvent event) {
			        /* data dropped */
			        /* if there is a string data on dragboard, read it and use it */
			        Dragboard db = event.getDragboard();
			        boolean success = false;
			        if (db.hasString()) {
			           target.setText(db.getString());
			           success = true;
			        }
			        /* let the source know whether the string was successfully 
			         * transferred and used */
			        event.setDropCompleted(success);
			        
			        event.consume();
			     }
			});
			source.setOnDragDone(new EventHandler<DragEvent>() {
			    public void handle(DragEvent event) {
			        /* the drag and drop gesture ended */
			        /* if the data was successfully moved, clear it */
			        if (event.getTransferMode() == TransferMode.MOVE) {
			            source.setText("");
			        }
			    
			        event.consume();
			    }
			});
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

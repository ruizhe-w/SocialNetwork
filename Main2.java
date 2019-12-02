package application;

import java.io.FileInputStream;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {
	// store any command-line arguments that were entered.
	private List<String> args;

	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 450;
	private static final String APP_TITLE = "Hello World!";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		

			VisualScene vs = new VisualScene();
			vs.addVertex("1");
			vs.addVertex("2");
			vs.addVertex("3");
			vs.addVertex("4");
			vs.addVertex("5");
			vs.addVertex("6");
			vs.addVertex("7");
			
			vs.addEdge("1", "2");
			vs.addEdge("1", "3");
			vs.addEdge("1", "4");
			vs.addEdge("1", "5");
			vs.addEdge("1", "6");
			vs.addEdge("1", "7");
			vs.addEdge("2", "5");
			
//			VisualScene vs2 = new VisualScene();
//			vs2.addVertex("23");
//
//			VBox root = new VBox(vs, vs2);
//		
//			

			Scene mainScene = new Scene(vs, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			

		// Add the stuff and set the primary stage
			primaryStage.setTitle(APP_TITLE);
			primaryStage.setScene(mainScene);
			primaryStage.show();
	}

//	public static void main(String[] args) {
//		   launch(args);
//	}
}
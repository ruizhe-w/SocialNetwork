/**
 * 
 */
package application;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author 95646
 *
 */
public class Main extends Application{
	private List<String> args;

	private static final int WINDOW_WIDTH = 1050;
	private static final int WINDOW_HEIGHT = 600;
	private static final String APP_TITLE = "Social Network Visualizer";

	@Override
	public void start(Stage primaryStage) throws Exception {
		args = this.getParameters().getRaw();
		primaryStage.setTitle(APP_TITLE);
		VBox vBox = new VBox(new MenuPane(), new VisualPane());
		BorderPane root = new BorderPane();
		root.setCenter(vBox);
		
		Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
		// TODO Auto-generated method stub

	}

}

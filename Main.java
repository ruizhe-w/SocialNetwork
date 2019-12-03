/**
 * CS400 final project 
 * Team: ateam 166
 * Member: 1. Yijun Cheng, lecture 001, cheng229@wisc.edu
 *		   2. Yuedong Cui, lecture 001, cui54@wisc.edu
 *		   3. Ruizhe Wang, lecture 001, rwang477@wisc.edu
 *		   4. Yuzheng Zhang, lecture 001, yzhang975@wisc.edu
 *		   5. Haolin Li, lecture 001, hli564@wisc.edu
 * This class is used to create a scene to show a social network
 */
package application;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	private List<String> args;

	// set the layout
	private static final int WINDOW_WIDTH = 1050;
	private static final int WINDOW_HEIGHT = 600;
	private static final String APP_TITLE = "Social Network Visualizer";

	/**
	 * This method is used to create a social network pane
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		args = this.getParameters().getRaw();
		// set the title
		primaryStage.setTitle(APP_TITLE);
		// create the menu pane and visual pane in a vertical box
		VBox vBox = new VBox(new MenuPane(), new VisualPane());
		// create root pane
		BorderPane root = new BorderPane();
		root.setCenter(vBox);
		// create scene
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

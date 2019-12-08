/**
 * 
 */
package application;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
	
	private static VisualPane visualPane;
	private static MenuPane menuPane;
	private static FileParser fileParser;
	private static Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		args = this.getParameters().getRaw();
		primaryStage.setTitle(APP_TITLE);
		
		menuPane = new MenuPane();
		visualPane = new VisualPane(menuPane);
		fileParser = new FileParser();
		menuPane.submitButton1.setOnAction(e -> {
			visualPane.saveCurrent();
			String name1 = menuPane.t2.getText();
			String name2 = menuPane.t3.getText();
			if(!name1.equals("") && name2.equals("")) {
				visualPane.home();
				visualPane.addVertex(name1);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}else if(!name1.equals("") && !name2.equals("")) {
				visualPane.home();
				visualPane.addVertex(name1);
				visualPane.addVertex(name2);
				visualPane.addEdge(name1, name2);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}
		});
		menuPane.submitButton2.setOnAction(e -> {
			visualPane.saveCurrent();
			String name1 = menuPane.t4.getText();
			String name2 = menuPane.t5.getText();
			if(!name1.equals("") && name2.equals("")) {
				visualPane.removeVertex(name1);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}else if(!name1.equals("") && !name2.equals("")) {
				visualPane.removeEdge(name1, name2);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}
		});
		menuPane.cleanButton.setOnAction(e -> {
			visualPane.saveCurrent();
			visualPane.clean();
			menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
		});
		menuPane.homeButton.setOnAction(e -> {
			visualPane.saveCurrent();
			visualPane.home();
			menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
		});
		menuPane.searchButton.setOnAction(e -> {
			visualPane.saveCurrent();
			String userName = menuPane.t1.getText();
			visualPane.search(userName);
		});
		menuPane.undoButton.setOnAction(e -> {
			//no need to save current
			visualPane.undo();
		});
		menuPane.submitButton5.setOnAction(e -> {
			visualPane.saveCurrent();
			try {
				fileParser.loadFromFile(visualPane, menuPane.LoadText.getText());
			} catch (Exception e1) {
			}
		});
		

		VBox vBox = new VBox(menuPane, visualPane);
		BorderPane root = new BorderPane();
		root.setCenter(vBox);
		
		scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

//		scene.lookup("#btn-search").setOnMouseClicked(e -> {
//			menuPane.funcSearch(
//					((TextField)scene.lookup("#txd-search")).getText()
//			);
//		});

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}
	

}

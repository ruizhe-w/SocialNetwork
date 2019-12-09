/**
 * 
 */
package application;

import java.io.IOException;
import java.util.ArrayList;
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
import javafx.stage.WindowEvent;

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
			//visualPane.saveCurrent();
			String name1 = menuPane.t2.getText();
			String name2 = menuPane.t3.getText();
			if(!name1.equals("") && name2.equals("")) {
				ArrayList<String> verticesList = visualPane.getVerticesList();
				if(!verticesList.contains(name1)) {
					visualPane.saveCurrent();
				}
				visualPane.home();
				visualPane.addVertex(name1);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}else if(!name1.equals("") && !name2.equals("")) {
				ArrayList<String> verticesList = visualPane.getVerticesList();
				if(!(verticesList.contains(name1) && verticesList.contains(name2))) {
					visualPane.saveCurrent();
				}
				visualPane.home();
				visualPane.addVertex(name1);
				visualPane.addVertex(name2);
				visualPane.addEdge(name1, name2);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}
		});
		menuPane.submitButton2.setOnAction(e -> {
			//visualPane.saveCurrent();
			String name1 = menuPane.t4.getText();
			String name2 = menuPane.t5.getText();
			if(!name1.equals("") && name2.equals("")) {
				ArrayList<String> verticesList = visualPane.getVerticesList();
				if(verticesList.contains(name1)) {
					visualPane.saveCurrent();
				}
				visualPane.home();
				visualPane.removeVertex(name1);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}else if(!name1.equals("") && !name2.equals("")) {
				ArrayList<String> verticesList = visualPane.getVerticesList();
				if(verticesList.contains(name1) && verticesList.contains(name2)) {
					visualPane.saveCurrent();
				}
				visualPane.home();
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

		// exit function
		scene.lookup("#btn-exit").setOnMouseClicked(e -> {
			menuPane.exitPane();
			primaryStage.fireEvent(new WindowEvent(
					primaryStage,
					WindowEvent.WINDOW_CLOSE_REQUEST));
		});

		scene.lookup("#btn-mutual").setOnMouseClicked(e -> {
			ArrayList<String> verticesList = visualPane.getVerticesList();
			String name1 = menuPane.t6.getText();
			String name2 = menuPane.t7.getText();
			if(verticesList.contains(name1) && verticesList.contains(name2)) {
				visualPane.saveCurrent();
			}
			visualPane.getMutualFriends(
					((TextField)scene.lookup("#txd-mutual-1")).getText(),
					((TextField)scene.lookup("#txd-mutual-2")).getText()
			);
		});

		scene.lookup("#btn-short").setOnMouseClicked(e -> {
			ArrayList<String> verticesList = visualPane.getVerticesList();
			String name1 = menuPane.t8.getText();
			String name2 = menuPane.t9.getText();
			if(verticesList.contains(name1) && verticesList.contains(name2)) {
				visualPane.saveCurrent();
			}
			visualPane.getShortestPath(
					((TextField)scene.lookup("#txd-short-1")).getText(),
					((TextField)scene.lookup("#txd-short-2")).getText()
			);
		});


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

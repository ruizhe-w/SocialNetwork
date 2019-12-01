/**
 * 
 */
package application;

import java.io.FileInputStream;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author 95646
 *
 */
public class Main extends Application{
	private List<String> args;

	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 800;
	private static final String APP_TITLE = "Social Network Visualizer";

	@Override
	public void start(Stage primaryStage) throws Exception {
		// save args example
		args = this.getParameters().getRaw();
		
		BorderPane root = new BorderPane();
		
		primaryStage.setTitle(APP_TITLE);
		HBox searchBar = new HBox();
		HBox add = new HBox();
		HBox remove = new HBox();
		HBox instructions = new HBox();
		HBox mutualFriends = new HBox();
		HBox shortestPath = new HBox();
		HBox numGroups = new HBox();
		HBox lastInstruction= new HBox();
		HBox load =new HBox();
		VBox v1 = new VBox();
		VBox v2 = new VBox();
		
		Button searchButton = new Button("Search");
		//Button addButton = new Button("Add");
		//Button removeButton = new Button("Remove");
		Button submitButton1 = new Button("Submit");
		Button submitButton2 = new Button("Submit");
		Button submitButton3 = new Button("Submit");
		Button submitButton4 = new Button("Submit");
		Button submitButton5 = new Button("Submit");
		Button clearButton = new Button("Clear");
		Button exitButton = new Button("Exit");
		Button saveButton = new Button("Save");
		
		TextField t1 = new TextField();
		t1.setPromptText("Search Name");
		
		TextField t2 = new TextField();
		t2.setPromptText("Enter Name 1");
		
		TextField t3 = new TextField();
		t3.setPromptText("Enter Name 2");
		
		TextField t4 = new TextField();
		t4.setPromptText("Enter Name 1");
		
		TextField t5 = new TextField();
		t5.setPromptText("Enter Name 2");
		
		TextField t6 = new TextField();
		t6.setPromptText("Enter Name 1");
		
		TextField t7 = new TextField();
		t7.setPromptText("Enter Name 2");
		
		TextField t8 = new TextField();
		t8.setPromptText("Enter Name 1");
		
		TextField t9 = new TextField();
		t9.setPromptText("Enter Name 2");
		
		TextField LoadText= new TextField();
		LoadText.setPromptText("Load File Here");
		
		
		
		Label numGroupsText = new Label("7");
		Label lastInstructionText = new Label("  s Jun");
		Label addLabel = new Label("Add        ");
		Label removeLabel =new Label("Remove ");
		Label mutualFriendsLabel = new Label("Mutual Friends ");
		Label shortestPathLabel = new Label("Shortest Path    ");
		Label numGroupsLabel = new Label("Number of Groups ");
		Label lastInstructionLabel = new Label("Last Instruction ");
		Label loadLabel = new Label("Load ");
		

		
		searchBar.getChildren().addAll(t1,searchButton);
		add.getChildren().addAll(addLabel,t2,t3,submitButton1);
		remove.getChildren().addAll(removeLabel,t4,t5,submitButton2);
		instructions.getChildren().addAll(clearButton, exitButton, saveButton);
		mutualFriends.getChildren().addAll(mutualFriendsLabel,t6,t7,submitButton3);
		shortestPath.getChildren().addAll(shortestPathLabel,t8,t9,submitButton4);
		numGroups.getChildren().addAll(numGroupsLabel, numGroupsText);
		lastInstruction.getChildren().addAll(lastInstructionLabel,lastInstructionText);
		load.getChildren().addAll(loadLabel,LoadText,submitButton5);
		
		v1.getChildren().addAll(searchBar,add,remove,instructions);
		v2.getChildren().addAll(mutualFriends, shortestPath,lastInstruction,load);
		
		Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		root.setLeft(v1);
		root.setRight(v2);
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

package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuPane extends Pane {

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
	Button submitButton1 = new Button("Submit");
	Button submitButton2 = new Button("Submit");
	Button submitButton3 = new Button("Submit");
	Button submitButton4 = new Button("Submit");
	Button submitButton5 = new Button("Submit");
	Button clearButton = new Button("Clear");
	Button exitButton = new Button("Exit");
	Button saveButton = new Button("Save");
	
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	TextField t3 = new TextField();
	TextField t4 = new TextField();
	TextField t5 = new TextField();
	TextField t6 = new TextField();
	TextField t7 = new TextField();
	TextField t8 = new TextField();
	TextField t9 = new TextField();
	TextField LoadText= new TextField();
	
	Label numGroupsText = new Label("7");
	Label lastInstructionText = new Label("  s Jun");
	Label addLabel = new Label("Add        ");
	Label removeLabel =new Label("Remove ");
	Label mutualFriendsLabel = new Label("Mutual Friends ");
	Label shortestPathLabel = new Label("Shortest Path    ");
	Label numGroupsLabel = new Label("Number of Groups ");
	Label lastInstructionLabel = new Label("Last Instruction ");
	Label loadLabel = new Label("Load ");
	
	public MenuPane() {
		this.setPrefSize(300, 1000);
		
		t1.setPromptText("Search Name");
		
		// add
		t2.setPromptText("Enter Name 1");
		t3.setPromptText("Enter Name 2");
		
		// remove
		t4.setPromptText("Enter Name 1");
		t5.setPromptText("Enter Name 2");
		
		// mutual friends
		t6.setPromptText("Enter Name 1");
		t7.setPromptText("Enter Name 2");
		
		// shortest paths
		t8.setPromptText("Enter Name 1");
		t9.setPromptText("Enter Name 2");
		
		
		LoadText.setPromptText("Load File Here");
		
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

		this.getChildren().addAll(v1, v2);
		
		v1.setLayoutX(25);
		v1.setLayoutY(25);
		
		v2.setLayoutX(550);
		v2.setLayoutY(25);
	}

}

/**
 * CS400 final project 
 * Team: ateam 166
 * Member: 1. Yijun Cheng, lecture 001, cheng229@wisc.edu
 *		   2. Yuedong Cui, lecture 001, cui54@wisc.edu
 *		   3. Ruizhe Wang, lecture 001, rwang477@wisc.edu
 *		   4. Yuzheng Zhang, lecture 001, yzhang975@wisc.edu
 *		   5. Haolin Li, lecture 001, hli564@wisc.edu
 * This class is used to create menu pane
 */
package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuPane extends AnchorPane {
	VBox function = new VBox();
	VBox input = new VBox();
	VBox buttons = new VBox();
	HBox textFields0 = new HBox();
	HBox textFields1 = new HBox();
	HBox textFields2 = new HBox();
	HBox menuButtons = new HBox();
	VBox leftMenu = new VBox();
	HBox MenuContent = new HBox();

	VBox function2 = new VBox();
	VBox input2 = new VBox();
	HBox textFields3 = new HBox();
	HBox textFields4 = new HBox();
	VBox buttons2 = new VBox();
	HBox MenuContent2 = new HBox();
	HBox info1 = new HBox();
	HBox info2 = new HBox();
	VBox rightMenu = new VBox();

	HBox Menu = new HBox();

	Button searchButton = new Button("Search");
	Button submitButton1 = new Button("Submit");
	Button submitButton2 = new Button("Submit");
	Button submitButton3 = new Button("Submit");
	Button submitButton4 = new Button("Submit");
	Button submitButton5 = new Button("Submit");
	Button cleanButton = new Button("Clean");
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
	TextField LoadText = new TextField();

	Label search_Bar = new Label("	search bar");
	Label numGroupsText = new Label("1");
	Label lastInstructionText = new Label("NONE");
	Label addLabel = new Label("	Add");
	Label removeLabel = new Label("	Remove");
	Label mutualFriendsLabel = new Label("		Mutual Friends");
	Label shortestPathLabel = new Label("		Shortest Path");
	Label numGroupsLabel = new Label("		Number of Groups: ");
	Label lastInstructionLabel = new Label("		Last Instruction: ");
	Label loadLabel = new Label("		Load");

	Label empty = new Label("");
	Label empty1 = new Label("");
	Label empty2 = new Label("");
	Label empty3 = new Label("");
	Label empty4 = new Label("");
	Label empty5 = new Label("");
	Label empty6 = new Label("");
	Label empty7 = new Label("");
	Label empty8 = new Label("	");

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

		numGroupsText.setOnMouseEntered(e -> numGroupsText.
				setStyle("-fx-font-size:20pt;"));
		numGroupsText.setOnMouseExited(e -> numGroupsText.
				setStyle("-fx-font-size:10pt;"));
		lastInstructionText.setOnMouseEntered(e -> lastInstructionText.
				setStyle("-fx-font-size:20pt;"));
		lastInstructionText.setOnMouseExited(e -> lastInstructionText.
				setStyle("-fx-font-size:10pt;"));

		LoadText.setPromptText("Load File Here");

		menuButtons.getChildren().addAll(empty8, cleanButton, empty2, 
				exitButton, empty3, saveButton);
		textFields1.getChildren().addAll(t2, t3);
		textFields2.getChildren().addAll(t4, t5);
		function.getChildren().addAll(search_Bar, empty, addLabel, empty1, 
				removeLabel);
		input.getChildren().addAll(t1, textFields1, textFields2);
		buttons.getChildren().addAll(searchButton, submitButton1, 
				submitButton2);
		MenuContent.getChildren().addAll(function, input, buttons);
		leftMenu.getChildren().addAll(empty6, MenuContent, menuButtons);

		textFields3.getChildren().addAll(t6, t7);
		textFields4.getChildren().addAll(t8, t9);
		info1.getChildren().addAll(numGroupsLabel, numGroupsText);
		info2.getChildren().addAll(lastInstructionLabel, lastInstructionText);
		function2.getChildren().addAll(mutualFriendsLabel, empty4, 
				shortestPathLabel, empty5, loadLabel);
		input2.getChildren().addAll(textFields3, textFields4, LoadText);
		buttons2.getChildren().addAll(submitButton3, submitButton4, 
				submitButton5);
		MenuContent2.getChildren().addAll(function2, input2, buttons2);
		rightMenu.getChildren().addAll(empty7, MenuContent2, info1, info2);

		Menu.getChildren().addAll(leftMenu, rightMenu);

		this.getChildren().addAll(Menu);	
	}

}

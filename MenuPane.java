////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: MenuPane
//Files: MenuPane.java
//
//Course: CS 400, Fall 2019
//
//Team:     ateam 166
//Members: 1. Yijun Cheng, lecture 001, cheng229@wisc.edu
//		   2. Yuedong Cui, lecture 001, cui54@wisc.edu
//		   3. Ruizhe Wang, lecture 001, rwang477@wisc.edu
//		   4. Yuzheng Zhang, lecture 001, yzhang975@wisc.edu
//		   5. Haolin Li, lecture 001, hli564@wisc.edu
//Lecturer's Name: Debra Deppeler
//
/**
 * CS400 final project 
 * This class is used to create menu pane
 */
package application;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MenuPane extends AnchorPane {
	private static FileParser fileParser;

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
	HBox info3 = new HBox();
	VBox rightMenu = new VBox();

	HBox Menu = new HBox();//HBox and VBox needed to implement the menuPane

	Button searchButton = new Button("Search");
	Button submitButton1 = new Button("Submit");
	Button submitButton2 = new Button("Submit");
	Button submitButton3 = new Button("Submit");
	Button submitButton4 = new Button("Submit");
	Button submitButton5 = new Button("Submit");
	Button homeButton = new Button("Home");
	Button cleanButton = new Button("Clean");
	Button exitButton = new Button("Exit");
	Button saveButton = new Button("Save");
	Button helpButton = new Button("Help");//Buttons

	TextField t1 = new TextField();
	TextField t2 = new TextField();
	TextField t3 = new TextField();
	TextField t4 = new TextField();
	TextField t5 = new TextField();
	TextField t6 = new TextField();
	TextField t7 = new TextField();
	TextField t8 = new TextField();
	TextField t9 = new TextField();
	TextField LoadText = new TextField();//All textFields needed

	Label search_Bar = new Label("	search bar");
	Label numGroupsText = new Label("[0]");
	Label lastInstructionText = new Label("NONE");
	Label addLabel = new Label("	Add");
	Label removeLabel = new Label("	Remove");
	Label mutualFriendsLabel = new Label("		Mutual Friends");
	Label shortestPathLabel = new Label("		Shortest Path");
	Label numGroupsLabel = new Label("		Number of Groups: ");
	Label lastInstructionLabel = new Label("		Last Instruction: ");
	Label loadLabel = new Label("		Load");
	Label totalUserLabel = new Label("	Total users: ");
	Label totalUser = new Label("0");
	Label numFriendsLabel = new Label("	 	Number of friends for current user: ");
	Label numFriends = new Label("Need a central user");

	Label empty = new Label("");
	Label empty1 = new Label("");
	Label empty2 = new Label("");
	Label empty3 = new Label("");
	Label empty4 = new Label("");
	Label empty5 = new Label("");
	Label empty6 = new Label("");
	Label empty7 = new Label("");
	Label empty8 = new Label("	");//all labels needed

	public MenuPane() {
		fileParser = new FileParser();

		this.setPrefSize(300, 1050);
		t1.setPromptText("Search Name");

		// add
		t2.setPromptText("This only for a new vertex");
		t3.setPromptText("Enter for an new edge");

		// remove
		t4.setPromptText("This only to remove a vertex");
		t5.setPromptText("Enter to remove an edge");

		// mutual friends
		t6.setPromptText("Enter Name 1");
		t7.setPromptText("Enter Name 2");

		// shortest paths
		t8.setPromptText("Enter Name 1");
		t9.setPromptText("Enter Name 2");

		numGroupsText.setOnMouseEntered(e -> numGroupsText.setStyle("-fx-font-size:20pt;"));
		numGroupsText.setOnMouseExited(e -> numGroupsText.setStyle("-fx-font-size:10pt;"));//increase the font size
		lastInstructionText.setOnMouseEntered(e -> lastInstructionText.setStyle("-fx-font-size:20pt;"));
		lastInstructionText.setOnMouseExited(e -> lastInstructionText.setStyle("-fx-font-size:10pt;"));//increase the font size
		totalUser.setOnMouseEntered(e -> totalUser.setStyle("-fx-font-size:20pt;"));
		totalUser.setOnMouseExited(e -> totalUser.setStyle("-fx-font-size:10pt;"));//increase the font size
		numFriends.setOnMouseEntered(e -> numFriends.setStyle("-fx-font-size:20pt;"));
		numFriends.setOnMouseExited(e -> numFriends.setStyle("-fx-font-size:10pt;"));//increase the font size

		LoadText.setPromptText("Load File Here");

		menuButtons.getChildren().addAll(empty8, homeButton, cleanButton, empty2, exitButton, empty3, saveButton,
				helpButton);
		textFields1.getChildren().addAll(t2, t3);
		textFields2.getChildren().addAll(t4, t5);
		function.getChildren().addAll(search_Bar, addLabel, removeLabel);
		function.setSpacing(11);//arrange the layout of menuPane

		input.getChildren().addAll(t1, textFields1, textFields2);
		buttons.getChildren().addAll(searchButton, submitButton1, submitButton2);
		MenuContent.getChildren().addAll(function, input, buttons);
		leftMenu.getChildren().addAll(empty6, MenuContent, menuButtons);//arrange the layout of menuPane

		textFields3.getChildren().addAll(t6, t7);
		textFields4.getChildren().addAll(t8, t9);
		info1.getChildren().addAll(numGroupsLabel, numGroupsText, totalUserLabel, totalUser);
		info2.getChildren().addAll(lastInstructionLabel, lastInstructionText);
		info3.getChildren().addAll(numFriendsLabel, numFriends);
		function2.getChildren().addAll(mutualFriendsLabel, shortestPathLabel, loadLabel);
		function2.setSpacing(11);//arrange the layout of menuPane

		input2.getChildren().addAll(textFields3, textFields4, LoadText);
		buttons2.getChildren().addAll(submitButton3, submitButton4, submitButton5);
		MenuContent2.getChildren().addAll(function2, input2, buttons2);
		rightMenu.getChildren().addAll(empty7, MenuContent2, info1, info2, info3);//arrange the layout of menuPane

		Menu.getChildren().addAll(leftMenu, rightMenu);

		this.getChildren().addAll(Menu);

		addId();
	}

	/**
	 * Set ID for each button
	 */
	private void addId() {
		searchButton.setId("btn-search");
		submitButton1.setId("btn-add");
		submitButton2.setId("btn-remove");
		submitButton3.setId("btn-mutual");
		submitButton4.setId("btn-short");
		submitButton5.setId("btn-load");//Set ID for submit buttons

		t1.setId("txd-search");
		t2.setId("txd-add-1");
		t3.setId("txd-add-2");
		t4.setId("txd-remove-1");
		t5.setId("txd-remove-2");
		t6.setId("txd-mutual-1");
		t7.setId("txd-mutual-2");
		t8.setId("txd-short-1");
		t9.setId("txd-short-2");
		LoadText.setId("txd-load");

		cleanButton.setId("btn-clean");
		exitButton.setId("btn-exit");
		saveButton.setId("btn-save");

		numGroupsText.setId("txt-group");
		lastInstructionText.setId("txt-last");
	}

}

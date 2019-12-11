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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		//add
		menuPane.submitButton1.setOnAction(e -> {
			//visualPane.saveCurrent();
			String name1 = menuPane.t2.getText();
			String name2 = menuPane.t3.getText();
			if((!name1.equals("") && name2.equals("")) || (name1.equals(name2) && !name1.equals(""))) {
				ArrayList<String> verticesList = visualPane.getVerticesList();
				if(!verticesList.contains(name1)) {
					visualPane.saveInstructions("a", name1, null);
					visualPane.saveCurrent();
					int size = visualPane.instructionList().size();
					menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));
					scene.lookup("#txd-add-1").setStyle(
							"-fx-border-color: transparent;"
					);
					scene.lookup("#txd-add-2").setStyle(
							"-fx-border-color: transparent;"
					);
				} else {
					scene.lookup("#txd-add-1").setStyle(
							"-fx-border-color: RED;"
					);
					scene.lookup("#txd-add-2").setStyle(
							"-fx-border-color: transparent;"
					);
				}
				visualPane.home();
				visualPane.addVertex(name1);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}else if(!name1.equals("") && !name2.equals("")) {
				visualPane.home();
//				visualPane.saveInstructions("a", name1, name2);
				visualPane.addVertex(name1);
				visualPane.addVertex(name2);
				System.out.println("df");

				if (visualPane.addEdge(name1, name2)) {
					visualPane.saveInstructions("a", name1, name2);
					visualPane.saveCurrent();
					int size = visualPane.instructionList().size();
					menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));

					scene.lookup("#txd-add-1").setStyle(
							"-fx-border-color: transparent;"
					);

					scene.lookup("#txd-add-2").setStyle(
							"-fx-border-color: transparent;"
					);
				} else {
					scene.lookup("#txd-add-1").setStyle(
							"-fx-border-color: RED;"
					);

					scene.lookup("#txd-add-2").setStyle(
							"-fx-border-color: RED;"
					);
				}

				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			} else {

				scene.lookup("#txd-add-1").setStyle(
						"-fx-border-color: RED;"
				);

				scene.lookup("#txd-add-2").setStyle(
						"-fx-border-color: RED;"
				);
			}

		});
		//remove
		menuPane.submitButton2.setOnAction(e -> {
			//visualPane.saveCurrent();
			String name1 = menuPane.t4.getText();
			String name2 = menuPane.t5.getText();
			if(!name1.equals("") && name2.equals("")) {
				ArrayList<String> verticesList = visualPane.getVerticesList();
				if(verticesList.contains(name1)) {
					visualPane.saveInstructions("r", name1, null);
					visualPane.saveCurrent();
					int size = visualPane.instructionList().size();
					menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));

					scene.lookup("#txd-remove-1").setStyle(
							"-fx-border-color: transparent;"
					);

					scene.lookup("#txd-remove-2").setStyle(
							"-fx-border-color: transparent;"
					);
				} else {
					scene.lookup("#txd-remove-1").setStyle(
							"-fx-border-color: RED;"
					);
				}
				visualPane.home();
				visualPane.removeVertex(name1);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			}else if(!name1.equals("") && !name2.equals("")) {
				ArrayList<String> verticesList = visualPane.getVerticesList();
				if(verticesList.contains(name1) && verticesList.contains(name2)) {
					visualPane.saveInstructions("r", name1, name2);
					visualPane.saveCurrent();
					int size = visualPane.instructionList().size();
					menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));

					scene.lookup("#txd-remove-1").setStyle(
							"-fx-border-color: transparent;"
					);
					scene.lookup("#txd-remove-2").setStyle(
							"-fx-border-color: transparent;"
					);
				} else {
					scene.lookup("#txd-remove-1").setStyle(
							"-fx-border-color: RED;"
					);
					scene.lookup("#txd-remove-2").setStyle(
							"-fx-border-color: RED;"
					);
				}
				visualPane.home();
				visualPane.removeEdge(name1, name2);
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			} else {
				scene.lookup("#txd-remove-1").setStyle(
						"-fx-border-color: RED;"
				);
				scene.lookup("#txd-remove-2").setStyle(
						"-fx-border-color: RED;"
				);
			}
		});
		//clean
		menuPane.cleanButton.setOnAction(e -> {
			visualPane.saveCurrent();
			visualPane.clean();
			menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			menuPane.lastInstructionText.setText("clean");
		});
		menuPane.homeButton.setOnAction(e -> {
			visualPane.saveCurrent();
			visualPane.home();
			menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			visualPane.saveInstructions("home", null, null);
			int size = visualPane.instructionList().size();
			menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));
		});
		menuPane.searchButton.setOnAction(e -> {
			visualPane.saveCurrent();
			String userName = menuPane.t1.getText();
			visualPane.search(userName);
			if(visualPane.getVerticesList().contains(userName)) {
				visualPane.saveInstructions("s", userName, null);
				int size = visualPane.instructionList().size();
				menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));
			}
		});
		menuPane.undoButton.setOnAction(e -> {
			//no need to save current
			visualPane.undo();
		});
		menuPane.submitButton5.setOnAction(e -> {
			visualPane.saveCurrent();
			visualPane.saveInstructions("load", menuPane.LoadText.getText(), null);
			int size = visualPane.instructionList().size();
			menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));
			try {
				fileParser.loadFromFile(visualPane, menuPane.LoadText.getText());
				menuPane.numGroupsText.setText("[" + String.valueOf(visualPane.getGroupNumber()) + "]");
			} catch (Exception e1) {
			}
		});
		menuPane.saveButton.setOnAction(e ->{
			Button yes = new Button(" Yes ");
			Button no = new Button("Cancel");
			HBox yOrn = new HBox();
			yOrn.getChildren().addAll(new Label("	 	"), yes, no);
			yOrn.setSpacing(22);
			VBox extiInfo = new VBox();
			Label prompt = new Label("File name: ");
			TextField fileNameText = new TextField();
			fileNameText.setPromptText("Type your file name here");
			HBox promptBox = new HBox();
			promptBox.getChildren().addAll(prompt, fileNameText);
			extiInfo.getChildren().addAll( promptBox, yOrn);
			extiInfo.setSpacing(11);
			BorderPane form = new BorderPane();
			form.setLeft(new Label(" 		"));
			form.setCenter(extiInfo);
			form.setTop(new Label(" 		"));
			form.setRight(new Label("	"));
			Scene newScene = new Scene(form, 400, 150);
			//create a new stage
			final Stage dialog = new Stage();
			//show the new scene
			dialog.setTitle("File Name prompt");
			dialog.setScene(newScene);
			dialog.show();
			yes.setOnAction(e2 -> {
				if(fileNameText.getText().length() > 4 && fileNameText.getText().substring(fileNameText.getText().length() - 4).equals(".txt")) {
					try {
						fileParser.saveToFile(visualPane, fileNameText.getText());
					}catch(IOException e1) {
						
					}
					dialog.fireEvent(new WindowEvent(dialog,
							WindowEvent.WINDOW_CLOSE_REQUEST));
				}else {
					form.setBottom(new Label("					invalid filename"));
				}
			});
			no.setOnAction(e2 -> {
				dialog.fireEvent(new WindowEvent(dialog,
						WindowEvent.WINDOW_CLOSE_REQUEST));
				
			});
			
		});
		
		

		VBox vBox = new VBox(menuPane, visualPane);
		BorderPane root = new BorderPane();
		root.setCenter(vBox);
		
		scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

		// exit function
		scene.lookup("#btn-exit").setOnMouseClicked(e -> {
			Label ifSave = new Label("Do you want to save your instructions?");
			Button yes = new Button("Yes");
			Button no = new Button("No");
			Button cancel = new Button("Cancel");
			HBox yOrn = new HBox();
			yOrn.getChildren().addAll(new Label("	 "), yes, no, cancel);
			yOrn.setSpacing(22);
			VBox extiInfo = new VBox();
			Label prompt = new Label("File name: ");
			TextField fileNameText = new TextField();
			fileNameText.setPromptText("Type your file name here");
			HBox promptBox = new HBox();
			promptBox.getChildren().addAll(prompt, fileNameText);
			extiInfo.getChildren().addAll(ifSave, promptBox, yOrn);
			extiInfo.setSpacing(11);
			BorderPane form = new BorderPane();
			form.setLeft(new Label(" 		"));
			form.setCenter(extiInfo);
			form.setTop(new Label(" 		"));
			form.setRight(new Label("	"));
			Scene newScene = new Scene(form, 400, 150);
			//create a new stage
			final Stage dialog = new Stage();
			//show the new scene
			dialog.setTitle("Confirm Save");
			dialog.setScene(newScene);
			dialog.show();
			yes.setOnAction(e2 -> {
				if(fileNameText.getText().length() > 4 && fileNameText.getText().substring(fileNameText.getText().length() - 4).equals(".txt")) {
					try {
						fileParser.saveToFile(visualPane, fileNameText.getText());
					}catch(IOException e1) {
						
					}
					dialog.fireEvent(new WindowEvent(dialog,
							WindowEvent.WINDOW_CLOSE_REQUEST));
					primaryStage.fireEvent(new WindowEvent(primaryStage,
							WindowEvent.WINDOW_CLOSE_REQUEST));
				}else {
					form.setBottom(new Label("					invalid filename"));
				}
			});
			no.setOnAction(e2 -> {
				dialog.fireEvent(new WindowEvent(dialog,
						WindowEvent.WINDOW_CLOSE_REQUEST));
				primaryStage.fireEvent(new WindowEvent(primaryStage,
						WindowEvent.WINDOW_CLOSE_REQUEST));
			});
			cancel.setOnAction(e2 -> {
				dialog.fireEvent(new WindowEvent(dialog,
						WindowEvent.WINDOW_CLOSE_REQUEST));
			});
			
		});

		scene.lookup("#btn-mutual").setOnMouseClicked(e -> {
			
			ArrayList<String> verticesList = visualPane.getVerticesList();
			String name1 = menuPane.t6.getText();
			String name2 = menuPane.t7.getText();
			if(verticesList.contains(name1) && verticesList.contains(name2) && !name1.equals(name2)) {
				visualPane.saveInstructions("mutual", name1, name2);
				int size = visualPane.instructionList().size();
				menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));
				visualPane.saveCurrent();

				scene.lookup("#txd-mutual-1").setStyle(
						"-fx-border-color: transparent;"
				);
				scene.lookup("#txd-mutual-2").setStyle(
						"-fx-border-color: transparent;"
				);
			} else {
				if (!verticesList.contains(name1)) {
					scene.lookup("#txd-mutual-1").setStyle(
							"-fx-border-color: RED;"
					);
				} else {
					scene.lookup("#txd-mutual-1").setStyle(
							"-fx-border-color: transparent;"
					);
				}

				if (!verticesList.contains(name2)) {
					scene.lookup("#txd-mutual-2").setStyle(
							"-fx-border-color: RED;"
					);
				} else {
					scene.lookup("#txd-mutual-2").setStyle(
							"-fx-border-color: transparent;"
					);
				}
				
				return;
			}
			if (!name1.equals(name2)) {
				visualPane.getMutualFriends(((TextField) scene.lookup("#txd-mutual-1")).getText(),
						((TextField) scene.lookup("#txd-mutual-2")).getText());
			}
			if(verticesList.contains(name1) && verticesList.contains(name2) && !name1.equals(name2)) {
			 	if(!visualPane.checkPath(name1, name2)) {
					((Label)scene.lookup("#txt-group")).setText("[2]");
				}else {
					((Label)scene.lookup("#txt-group")).setText("[1]");
				}
			}

		});

		scene.lookup("#btn-short").setOnMouseClicked(e -> {
			ArrayList<String> verticesList = visualPane.getVerticesList();
			String name1 = menuPane.t8.getText();
			String name2 = menuPane.t9.getText();
			if(verticesList.contains(name1) && verticesList.contains(name2) && !name1.equals(name2)) {
				visualPane.saveInstructions("path", name1, name2);
				int size = visualPane.instructionList().size();
				menuPane.lastInstructionText.setText(visualPane.instructionList().get(size - 1));
				visualPane.saveCurrent();
			} else {
				if (!verticesList.contains(name1)) {
					scene.lookup("#txd-short-1").setStyle(
							"-fx-border-color: RED;"
					);
				} else {
					scene.lookup("#txd-short-1").setStyle(
							"-fx-border-color: transparent;"
					);
				}

				if (!verticesList.contains(name2)) {
					scene.lookup("#txd-short-2").setStyle(
							"-fx-border-color: RED;"
					);
				} else {
					scene.lookup("#txd-short-2").setStyle(
							"-fx-border-color: transparent;"
					);
				}
				
				return;
			}
			if(!name1.equals(name2)) {
				if(visualPane.checkPath(name1, name2)) {
					visualPane.getShortestPath(
							((TextField)scene.lookup("#txd-short-1")).getText(),
							((TextField)scene.lookup("#txd-short-2")).getText()
					);
					((Label)scene.lookup("#txt-group")).setText("[1]");
			}else {
				((Label)scene.lookup("#txt-group")).setText("[2]");
			}
			}
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

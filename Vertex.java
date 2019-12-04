package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Vertex extends Pane {
	
	private int x, y, r;
	private String name;
	
	private Label label;
	private Circle circle;

	
	public Vertex(int x, int y, int r, String name) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.name = name;
		
		this.label = new Label(name);
		this.label.setBackground(new Background(new BackgroundFill(
								Color.WHITE, 
								CornerRadii.EMPTY, 
								Insets.EMPTY)));
		
		this.label.setLayoutX(r + 5);
		this.label.setLayoutY(r + 5);
		this.label.setMouseTransparent(true);
		
		this.circle = new Circle(r + 5, r + 5, r);
		this.circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		this.circle.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
		
		
		this.circle.setOnMouseEntered(e -> {
			this.circle.setRadius(r + 5);
		});
		
		this.circle.setOnMouseExited(e -> {
			this.circle.setRadius(r);
		});
		
		
		this.setOnMouseEntered(e -> {
			this.circle.setRadius(r + 5);
		});
		
		this.setOnMouseExited(e -> {
			this.circle.setRadius(r);
		});
		
		this.setMaxWidth(2 * r + 10);
		this.setMaxHeight(2 * r + 10);
		
		this.getChildren().addAll(this.circle, this.label);
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getR() {
		return r;
	}


	public void setR(int r) {
		this.r = r;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	//TODO: add click function

}

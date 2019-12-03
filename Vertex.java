/**
 * CS400 final project 
 * Team: ateam 166
 * Member: 1. Yijun Cheng, lecture 001, cheng229@wisc.edu
 *		   2. Yuedong Cui, lecture 001, cui54@wisc.edu
 *		   3. Ruizhe Wang, lecture 001, rwang477@wisc.edu
 *		   4. Yuzheng Zhang, lecture 001, yzhang975@wisc.edu
 *		   5. Haolin Li, lecture 001, hli564@wisc.edu
 * This class is used to create an vertex to visual pane
 */
package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Vertex extends Pane {

	// private field of vertex
	private int x, y, r;
	private String name;

	private Label label;
	private Circle circle;

	/**
	 * constructor
	 * 
	 * @param x    x-coordinate of the vertex
	 * @param y    y-coordinate of the vertex
	 * @param r    size of the vertex
	 * @param name name of the vertex
	 */
	public Vertex(int x, int y, int r, String name) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.name = name;

		// create label and set background
		this.label = new Label(name);
		this.label.setBackground(new Background(new BackgroundFill(Color.WHITE,
				CornerRadii.EMPTY, Insets.EMPTY)));

		this.label.setLayoutX(x);
		this.label.setLayoutY(y);

		// create vertex as a circle and color it
		this.circle = new Circle(x, y, r);
		this.circle.setFill(Color.color(Math.random(), Math.random(),
				Math.random()));
		this.circle.setStroke(Color.color(Math.random(), Math.random(),
				Math.random()));

		// add vertex to layout
		this.getChildren().addAll(this.circle, this.label);
	}

	/**
	 * return x-coordinate of the vertex
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * set x-coordinate of the vertex
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * return y-coordinate of the vertex
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * set y-coordinate of the vertex
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * return size of the vertex
	 * 
	 * @return
	 */
	public int getR() {
		return r;
	}

	/**
	 * set size of the vertex
	 * 
	 * @param r
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * return name of the vertex
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name of the vertex
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	// TODO: add click function

}

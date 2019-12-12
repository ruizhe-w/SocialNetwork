////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Edge
//Files: Edge.java,
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
 * 
 * Team: ateam 166
 * This class is used to create an edge to connect vertexes in visual pane
 */
package application;

import javafx.scene.shape.Line;

public class Edge extends Line {

	// vertex name
	private String s1, s2;

	/**
	 * constructor
	 * 
	 * @param x1 x-coordinate of the first vertex
	 * @param y1 y-coordinate of the first vertex
	 * @param x2 x-coordinate of the second vertex
	 * @param y2 y-coordinate of the first vertex
	 * @param s1 name of the first vertex
	 * @param s2 name of the second vertex
	 */
	public Edge(int x1, int y1, int x2, int y2, String s1, String s2) {
		super(x1, y1, x2, y2);
		this.s1 = s1;
		this.s2 = s2;

		this.setMouseTransparent(true);// set the mouse to be transparent to avoid wrong user actions
	}

	/**
	 * Getter method for s1
	 * 
	 * @return String s1
	 */
	public String getS1() {
		return s1;
	}

	/**
	 * Mutator method for s1
	 * 
	 * @param s1
	 */
	public void setS1(String s1) {
		this.s1 = s1;
	}

	/**
	 * Getter method for s2
	 * 
	 * @return String s2
	 */
	public String getS2() {
		return s2;
	}

	/**
	 * Mutator method for s2
	 * 
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
}

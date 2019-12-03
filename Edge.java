/**
 * CS400 final project 
 * Team: ateam 166
 * Member: 1. Yijun Cheng, lecture 001, cheng229@wisc.edu
 *		   2. Yuedong Cui, lecture 001, cui54@wisc.edu
 *		   3. Ruizhe Wang, lecture 001, rwang477@wisc.edu
 *		   4. Yuzheng Zhang, lecture 001, yzhang975@wisc.edu
 *		   5. Haolin Li, lecture 001, hli564@wisc.edu
 * This class is used to create an edge to connect vertexes in visual pane
 */
package application;

import javafx.scene.shape.Line;

public class Edge extends Line {

	// vertex name
	String s1, s2;

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
	}
}

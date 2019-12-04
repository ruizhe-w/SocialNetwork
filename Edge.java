package application;

import javafx.scene.shape.Line;

public class Edge extends Line {

	String s1, s2;
	
	public Edge(int x1, int y1, int x2, int y2, String s1, String s2) {
		super(x1, y1, x2, y2);
		this.s1 = s1;
		this.s2 = s2;
		
		this.setMouseTransparent(true);
	}
}

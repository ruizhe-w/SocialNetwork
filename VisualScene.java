package application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class VisualScene extends Pane {
	
	List<PersonNode> circles;
	Map<String, Integer> map;
	List<Edge> edges;
	
	public VisualScene() {
		circles = new LinkedList<PersonNode>();
		map = new HashMap<String, Integer>();
		edges = new LinkedList<Edge>();
	}
	
	public boolean addEdge (String name1, String name2) {
		if (!map.containsKey(name1) || !map.containsKey(name2)) {
			return false;
		}
		
		int key_1 = map.get(name1);
		int key_2 = map.get(name2);
		
		PersonNode v1 = circles.get(key_1);
		PersonNode v2 = circles.get(key_2);
		
		// TODO: add check contains or not
		
		Edge edge = new Edge(v1.getX(), v1.getY(), v2.getX(),
				v2.getY(), v1.getName(), v2.getName());
		
		this.getChildren().add(edge);
		
		return true;
	}
	
	
	public boolean addVertex (String name) {
		Random rand = new Random();
		int counter = 0;
		while (true) { 
			counter++;
			int x = rand.nextInt(1000);
			int y = rand.nextInt(500);
			int r = 30;
			if (!checkCollision(x, y, r)) {
				PersonNode pn = new PersonNode(x, y, r, name);
				
				this.getChildren().add(pn);
				map.put(name, this.circles.size());
				this.circles.add(pn);
				break;
			}
			
			if (counter >= 50) {
				PersonNode pn = new PersonNode(x, y, r, name);
				
				this.getChildren().add(pn);
				map.put(name, this.circles.size());
				this.circles.add(pn);
				break;
			}
		}
		return true;
	}
	
	
	private boolean checkCollision(int x, int y, int r) {
		for (int i = 0; i < circles.size(); i++) {
			int x_length = x - circles.get(i).getX();
			int y_length = y - circles.get(i).getY();
			int r_length = r - circles.get(i).getR();
			
			if (x_length * x_length + y_length * y_length < r_length * r_length) {
				return true;
			}
		}
		return false;
	}
}

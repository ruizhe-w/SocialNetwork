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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import javafx.scene.input.MouseEvent;

public class VisualPane extends Pane {
	
	// field of visual pane
	private List<Vertex> circles;
	private Map<String, Integer> map;
	private List<Edge> edges;
	private Scene scene;
	
	public VisualPane() {
		this.setPrefSize(400, 1050);
		
		circles = new LinkedList<Vertex>();
		map = new HashMap<String, Integer>();
		edges = new LinkedList<Edge>();
		
		// create vertexes and edges
		this.addVertex("1");
		this.addVertex("2");
		this.addVertex("3");
		this.addVertex("4");
		this.addVertex("5");
		this.addVertex("6");
		this.addVertex("7");
		this.addVertex("8");
		this.addVertex("9");
		this.addVertex("10");
		
		this.addEdge("1", "2");
		this.addEdge("1", "3");
		this.addEdge("1", "4");
		this.addEdge("1", "5");
		this.addEdge("1", "6");
		this.addEdge("1", "7");
		this.addEdge("1", "8");
		this.addEdge("1", "9");
		this.addEdge("1", "10");
		this.addEdge("2", "5");
		this.addEdge("3", "7");
		this.addEdge("4", "8");
		this.addEdge("5", "6");
		this.addEdge("8", "10");
	}
	
	/**
	 * This method add edge to visual pane
	 * @param name1 name of the first vertex
	 * @param name2 name of the second vertex
	 */
	private void addEdge (String name1, String name2) {
		// both vertexes should already exist
		if (!map.containsKey(name1) || !map.containsKey(name2)) {
			return;
		}
		
		int key_1 = map.get(name1);
		int key_2 = map.get(name2);
		
		Vertex v1 = circles.get(key_1);
		Vertex v2 = circles.get(key_2);
		
		// TODO: add check contains or not
		
		Edge edge = new Edge(v1.getX(), v1.getY(), v2.getX(),
				v2.getY(), v1.getName(), v2.getName());
		
		this.getChildren().add(edge);
		edges.add(edge);
	}
	
	/**
	 * This method add vertex to the visual pane
	 * @param name name of vertex
	 */
	private void addVertex (String name) {
		Random rand = new Random();
		int counter = 0;
		while (true) { 
			counter++;
			int x = rand.nextInt(900) + 60;
			int y = rand.nextInt(280) - 40;
			int r = 30;
			
			// check if the location has already been occupied
			if (!checkCollision(x, y, r)) {
				Vertex pn = new Vertex(x, y, r, name);
				
				pn.setLayoutX(x - 5 - r);
				pn.setLayoutY(y - 5 - r);
				
				this.getChildren().add(pn);
				map.put(name, this.circles.size()); // add to map
				this.circles.add(pn); // add 
				break;
			}
			
			if (counter >= 50) {
				Vertex pn = new Vertex(x, y, r, name);
				this.getChildren().add(pn);
				map.put(name, this.circles.size());
				this.circles.add(pn);
				break;
			}
		}
	}
	
	
	private int getGroupNumber() {
		return 0;
	}
	
	
	private void removeEdge(String s1, String s2) {
		
	}
	
	
	private void removeVertex(String string) {
		
	}
	
	
	
	
	/**
	 * This method check if new vertex is conflict with others
	 * @param x x-coordinate of the vertex
	 * @param y y-coordinate of the vertex
	 * @param r size of the vertex
	 * @return true if conflict
	 */
	private boolean checkCollision(int x, int y, int r) {
		for (int i = 0; i < circles.size(); i++) {
			int x_length = x - circles.get(i).getX();
			int y_length = y - circles.get(i).getY();
			int r_length = r + circles.get(i).getR();
			
			// compare new location with all other vertexes
			if (x_length * x_length + y_length * y_length 
					< r_length * r_length) {
				return true;
			}
		}
		return false;
	}
	
	
	public void funcAdd(String s1, String s2) {
		
	}
	
	
	// TODO: 3. finish the function
	public void funcSearch(String string) {
		System.out.println(string);
	}
	
	
	public void funcRemove(String s1, String s2) {
		
	}
	
	
	public void funcMutual(String s1, String s2) {
		
	}
	
	
	public void funcLoad(String string) {
		
	}
	
	
	private void updateGroupNumber() {
		
	}
	
	
	private void updateInstrunction() {
		
	}
	
	// TODO: 2. bind the listener based on the model below
	public void addListener(Scene scene) {
		this.scene = scene;
		
		// Bind Model
		scene.lookup("#btn-search").addEventHandler(
				MouseEvent.MOUSE_CLICKED,
				handlerSearch);
	}
	

	// Listener Model
	EventHandler<MouseEvent> handlerSearch = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				funcSearch(
					((TextField)scene.lookup("#txd-search")).getText());
			}
		};
		
	// TODO: 1. add listener based on the model above
}



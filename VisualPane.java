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

import java.util.ArrayList;
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
	
	private int numVertex;
	private ArrayList<String> vertexList;
	private ArrayList<ArrayList<Boolean>> edgeList;
	private int numGroup;
	
	public VisualPane() {
		this.setPrefSize(400, 1050);
		circles = new LinkedList<Vertex>();
		map = new HashMap<String, Integer>();
		edges = new LinkedList<Edge>();
		vertexList = new ArrayList<String>();
		edgeList = new ArrayList<ArrayList<Boolean>>();
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
		edgeList.get(vertexList.indexOf(name1)).set(vertexList.indexOf(name2), true);
		edgeList.get(vertexList.indexOf(name2)).set(vertexList.indexOf(name1), true);
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
				vertexList.add(name);
				numVertex++;
				for (int i = 0; i < numVertex - 1; i++) {
					edgeList.get(i).add(false);
				}
				edgeList.add(new ArrayList<Boolean>());
				break;
			}
			
			if (counter >= 50) {
				Vertex pn = new Vertex(x, y, r, name);
				this.getChildren().add(pn);
				map.put(name, this.circles.size());
				this.circles.add(pn);
				vertexList.add(name);
				numVertex++;
				for (int i = 0; i < numVertex - 1; i++) {
					edgeList.get(i).add(false);
				}
				edgeList.add(new ArrayList<Boolean>());
				break;
			}
		}
	}
	
	
	/**
	 * Get the number of the groups
	 * @return the number of groups
	 */
	private int getGroupNumber() {
		numGroup = 0;
		boolean[] visited = new boolean[numVertex];
		for (int i = 0; i < numVertex; i++) {
			if (!visited[i]) {
				getGroupNumberHelper(i, visited, numGroup);
				numGroup++;
			}
		}
		return numGroup;
	}
	
	private void getGroupNumberHelper(int i, boolean[] visited, int numGroup) {
		visited[i] = true;
		for (int j = 0; j < edgeList.get(i).size(); j++) {
			if (edgeList.get(i).get(j) && !visited[j]) {
				getGroupNumberHelper(j, visited, numGroup);
			}
		}
	}
	
	
	/**
	 * remove an edge between vertex s1 and vertex s2
	 * if there is no edge between vertex s1 and s2, just simply return
	 * @param s1 name of a vertex
	 * @param s2 name of a vertex
	 */
	private void removeEdge(String s1, String s2) {
		if (!vertexList.contains(s1) || !vertexList.contains(s2)) {
			return;
		}
		edgeList.get(vertexList.indexOf(s1)).set(vertexList.indexOf(s2), false);
		edgeList.get(vertexList.indexOf(s2)).set(vertexList.indexOf(s1), false);
	}
	

	
	/**
	 * remove the vertex specified by the vertex name
	 * if there is no vertex specified, just return
	 * @param string name of a vertex
	 */
	private void removeVertex(String string) {
		if (!vertexList.contains(string)) {
			return;
		}
		for (int i = 0; i < numVertex; i++) {
			edgeList.get(i).remove(vertexList.indexOf(string));
		}
		edgeList.remove(vertexList.indexOf(string));
		vertexList.remove(vertexList.indexOf(string));
		numVertex--;
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
	
}


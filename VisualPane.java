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
	
	//last context
	private List<LinkedList<Node>> curContext;
	private List<List<Vertex>> tmpCircles;
	private List<List<Edge>> tmpEdges;
	private ArrayList<Integer> tmpNumVertex;
	private ArrayList<ArrayList<String>> tmpVertexList;
	private ArrayList<ArrayList<ArrayList<Boolean>>> tmpEdgeList;
	private ArrayList<Integer> lastNumGroup;
	int step;
	
	// field of visual pane
	private MenuPane menuPane;
	private List<Vertex> circles;
	private Map<String, Integer> map;
	private List<Edge> edges;
	private Scene scene;
	
	private int numVertex;
	private ArrayList<String> vertexList;
	private ArrayList<ArrayList<Boolean>> edgeList;
	private int numGroup;
	//private String centralUser;
	//private List<Vertex> friends;
	
	public VisualPane(MenuPane menuPane) {
		lastNumGroup = new ArrayList<Integer>();
		tmpCircles = new LinkedList<List<Vertex>>();
		tmpEdges = new LinkedList<List<Edge>>();
		tmpVertexList = new ArrayList<ArrayList<String>>();
		tmpEdgeList = new ArrayList<ArrayList<ArrayList<Boolean>>>();
		tmpNumVertex = new ArrayList<Integer>();
		this.curContext = new LinkedList<LinkedList<Node>>();
		this.setPrefSize(400, 1050);
		circles = new LinkedList<Vertex>();
		map = new HashMap<String, Integer>();
		edges = new LinkedList<Edge>();
		vertexList = new ArrayList<String>();
		edgeList = new ArrayList<ArrayList<Boolean>>();
		this.menuPane = menuPane;
		step = -1;
		//centralUser = "";
	}
	
	/**
	 * This method add edge to visual pane
	 * @param name1 name of the first vertex
	 * @param name2 name of the second vertex
	 */
	public void addEdge(String name1, String name2) {
		
		// both vertexes should already exist
		
		
		Vertex v1 = null;
		Vertex v2 = null;
		
		for(int i = 0; i < circles.size(); i++) {
			if(circles.get(i).getName().equals(name1)) {
				v1 = circles.get(i);
			}
			if(circles.get(i).getName().equals(name2)) {
				v2 = circles.get(i);
			}
		}
		
		if(v2 == null || v2 == null) {
			return;
		}
		
		// TODO: add check contains or not
		
		Edge edge = new Edge(v1.getX(), v1.getY(), v2.getX(),
				v2.getY(), v1.getName(), v2.getName());
		
		this.getChildren().add(edge);
		edges.add(edge);
		//System.out.println("777");
		edgeList.get(vertexList.indexOf(name1)).set(vertexList.indexOf(name2), true);
		edgeList.get(vertexList.indexOf(name2)).set(vertexList.indexOf(name1), true);
	}
	
	/**
	 * This method add vertex to the visual pane
	 * @param name name of vertex
	 */
	public void addVertex(String name) {
		if(vertexList.contains(name)) {
			return;
		}
		
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
				//System.out.println(numVertex + " " + edgeList.size()+" ADD");
				for (int i = 0; i < numVertex - 1; i++) {
					edgeList.get(i).add(false);
				}
				edgeList.add(new ArrayList<Boolean>());
				for (int i = 0; i < numVertex; i++) {
					edgeList.get(numVertex - 1).add(false);
				}
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
				for (int i = 0; i < numVertex; i++) {
					edgeList.get(numVertex - 1).add(false);
				}
				break;
			}
		}
	}
	
	
	/**
	 * Get the number of the groups
	 * @return the number of groups
	 */
	public int getGroupNumber() {
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
	public void removeEdge(String s1, String s2) {
		if (!vertexList.contains(s1) || !vertexList.contains(s2)) {
			return;
		}
		Vertex pn = null;
		Vertex pn2 = null;
		
		for(int i = 0; i < circles.size(); i++) {
			if(circles.get(i).getName().equals(s1)) {
				pn = circles.get(i);
			}
			if(circles.get(i).getName().equals(s2)) {
				pn2 = circles.get(i);
			}
		}
		for(int j = 0; j < edges.size(); j++) {
			if(((edges.get(j).getS1().equals(s1) &&
					edges.get(j).getS2().equals(s2))) ||
					((edges.get(j).getS1().equals(s2) &&
							edges.get(j).getS2().equals(s1)))) {
				Edge edge = edges.get(j);
				this.getChildren().remove(edge);
				edges.remove(edge);
			}
		}
		
		
		edgeList.get(vertexList.indexOf(s1)).set(vertexList.indexOf(s2), false);
		edgeList.get(vertexList.indexOf(s2)).set(vertexList.indexOf(s1), false);
	}
	

	
	/**
	 * remove the vertex specified by the vertex name
	 * if there is no vertex specified, just return
	 * @param string name of a vertex
	 */
	public void removeVertex(String string) {
		if (!vertexList.contains(string)) {
			return;
		}
		Vertex pn = circles.get(vertexList.indexOf(string));
		map.remove(string);
		for (int i = 0; i < numVertex; i++) {
			Vertex pn2 = circles.get(i);
			
			for(int j = 0; j < edges.size(); j++) {
				if((edges.get(j).getS1().equals(string) ||
						edges.get(j).getS2().equals(string))) {
					Edge edge = edges.get(j);
					this.getChildren().remove(edge);
					edges.remove(edge);
				}
			}
			
			edgeList.get(i).remove(vertexList.indexOf(string));
		}
		edgeList.remove(vertexList.indexOf(string));
		this.getChildren().remove(circles.get(vertexList.indexOf(string)));
		this.circles.remove(vertexList.indexOf(string));
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
	
	public void setCentralUser(String name) {
		if(!vertexList.contains(name)) {
			return;
		}
		Vertex v1 = circles.get(vertexList.indexOf(name));
		//friends = new LinkedList<Vertex>();
		this.getChildren().clear();
		this.getChildren().add(v1);
		
		for (int i = 0; i < edgeList.get(vertexList.indexOf(name)).size(); i++) {
			if (edgeList.get(vertexList.indexOf(name)).get(i)) {
				
				//friends.add(circles.get(vertexList.indexOf(name)));
				Vertex v2 = circles.get(i);
				this.getChildren().add(v2);
				this.getChildren().add(new Edge(v1.getX(), v1.getY(), v2.getX(),
						v2.getY(), v1.getName(), v2.getName()));
				
			}
		}
		menuPane.numGroupsText.setText("[1]");
	}
	
	public void home() {
		this.getChildren().clear();
		for(int i = 0; i < circles.size(); i++) {
			this.getChildren().add(circles.get(i));
		}
		for(int i = 0; i < edges.size(); i++) {
			this.getChildren().add(edges.get(i));
		}
	}
	
	public void clean() {
		this.getChildren().clear();
		circles.clear();
		vertexList.clear();
		numVertex = 0;
		edgeList.clear();
		edges.clear();
	}

	public void search(String name) {
		if(!vertexList.contains(name)) {
			return;
		}
		setCentralUser(name);
	}
	
	public void saveCurrent() {
		step++;
		tmpCircles.add(new LinkedList<Vertex>());
		tmpEdges.add(new LinkedList<Edge>());
		tmpVertexList.add(new ArrayList<String>());
		tmpEdgeList.add(new ArrayList<ArrayList<Boolean>>());
		curContext.add(new LinkedList<Node>());
		
		for(int i = 0; i < circles.size(); i++) {
			tmpCircles.get(step).add(circles.get(i));
			tmpVertexList.get(step).add(vertexList.get(i));
			tmpEdgeList.get(step).add(new ArrayList<Boolean>());
			for(int j = 0; j < edgeList.get(i).size(); j++) {
				tmpEdgeList.get(step).get(i).add(edgeList.get(i).get(j));
			}
		}
		for(int i = 0; i < edges.size(); i++) {
			tmpEdges.get(step).add(edges.get(i));
		}
		String strGroup = menuPane.numGroupsText.getText();
		lastNumGroup.add(Integer.parseInt(strGroup.substring(1, strGroup.length() - 1)));
		tmpNumVertex.add(numVertex);
		
		for(int i = 0; i < this.getChildren().size(); i++) {
			curContext.get(step).add(this.getChildren().get(i));
		}
	}
	
	public void undo() {
		if(step == -1) {
			return;
		}
		 this.getChildren().clear();
		if (!curContext.get(step).isEmpty()) {
			for (int i = 0; i < curContext.get(step).size(); i++) {
				if (!this.getChildren().contains(curContext.get(step).get(i)))
					this.getChildren().add(curContext.get(step).get(i));
			}
		}else {
			this.getChildren().clear();
		}
		 circles = tmpCircles.get(step);
		 edges = tmpEdges.get(step);
		 numVertex = tmpNumVertex.get(step);
		 vertexList = tmpVertexList.get(step);
		 edgeList = tmpEdgeList.get(step);
		 
		 menuPane.numGroupsText.setText("[" + String.valueOf(lastNumGroup.get(step)) + "]");
		 //lastNumGroup = Integer.parseInt(menuPane.numGroupsText.getText());
		 
		 lastNumGroup.remove(step);
		 curContext.remove(step);
		 tmpCircles.remove(step);
		 tmpEdges.remove(step);
		 tmpNumVertex.remove(step);
		 tmpVertexList.remove(step);
		 tmpEdgeList.remove(step);
		 step--;
	}
	
	private void updateVisual() {
	}

	
	
	
}

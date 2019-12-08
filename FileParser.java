/**
 * CS400 final project 
 * Team: ateam 166
 * Member: 1. Yijun Cheng, lecture 001, cheng229@wisc.edu
 *		   2. Yuedong Cui, lecture 001, cui54@wisc.edu
 *		   3. Ruizhe Wang, lecture 001, rwang477@wisc.edu
 *		   4. Yuzheng Zhang, lecture 001, yzhang975@wisc.edu
 *		   5. Haolin Li, lecture 001, hli564@wisc.edu
 * This class is used to read instructions from file and save instructions 
 * to file
 */
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

	
	/**
	 * load a file from the given filename
	 * @param fileName
	 * @throws IOException 
	 */
	public static void loadFromFile(VisualPane visualPane, String fileName) throws IOException {
		File file = new File(fileName);
		Scanner scnr = new Scanner(file);
		while (scnr.hasNextLine()) {
			String[] str = scnr.nextLine().split(" ");
			if (str[0].equals("a")) {
				if (str.length == 2) {
					visualPane.addVertex(str[1]);
				} else if (str.length == 3){
					visualPane.addEdge(str[1], str[2]);
				}
			} else if (str[0].equals("r")) {
				if (str.length == 2) {
					visualPane.removeVertex(str[1]);
				} else if (str.length == 3){
					visualPane.removeEdge(str[1], str[2]);
				}
			} else if (str[0].equals("s")) {
				// TODO: clean first
				ArrayList<String> friends = visualPane.setCentralUser(str[1]);
				visualPane.addVertex(str[1]);
				for (int i = 0; i < friends.size(); i++) {
					visualPane.addEdge(str[1], friends.get(i));
				}
			}
		}
		scnr.close();
	}
	
	
	/**
	 * save current layout to a new file
	 * @param visualPane
	 * @throws IOException 
	 */
	public static void saveToFile(VisualPane visualPane, String filename) throws IOException {
		File file = new File(filename);
		PrintWriter printer = new PrintWriter(file);
		// TODO: click function
	}
}

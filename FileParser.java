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
	public void loadFromFile(VisualPane visualPane, String fileName) throws IOException {
		File file = new File(fileName);
		Scanner scnr = new Scanner(file);
		while (scnr.hasNextLine()) {
			String[] str = scnr.nextLine().split(" ");
			if (str[0].equals("a")) {
				if (str.length == 2) {
					visualPane.addVertex(str[1]);
				} else if (str.length == 3){
					visualPane.addVertex(str[1]);
					visualPane.addVertex(str[2]);
					visualPane.addEdge(str[1], str[2]);
				}
			} else if (str[0].equals("r")) {
				if (str.length == 2) {
					visualPane.removeVertex(str[1]);
				} else if (str.length == 3){
					visualPane.removeEdge(str[1], str[2]);
				}
			} else if (str[0].equals("s")) {
				visualPane.setCentralUser(str[1]);
				
			}
		}
		scnr.close();
	}
	
	
	/**
	 * save current layout to a new file
	 * @param visualPane
	 * @throws IOException 
	 */
	public void saveToFile(VisualPane visualPane, String filename) throws IOException {
		File file = new File(filename);
		PrintWriter printer = new PrintWriter(file);
		for (int i = 0; i < visualPane.instructionList().size(); i++) {
			String[] arr = visualPane.instructionList().get(i).split(" ");
			if (!arr[0].equals("home") && !arr[0].equals("mutual") && !arr[0].equals("path") && !arr[0].equals("load")) {
				printer.println(visualPane.instructionList().get(i));
			} else if (arr[0].equals("load")) {
				if (arr.length == 2) {
					String name = arr[1];
					File file1 = new File(name);
					Scanner scnr = new Scanner(file1);
					while (scnr.hasNextLine()) {
						printer.println(scnr.nextLine());
					}
					scnr.close();
				}
			}
		}
		printer.close();
	}
}

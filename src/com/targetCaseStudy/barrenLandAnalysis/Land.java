package com.targetCaseStudy.barrenLandAnalysis;

import java.util.ArrayList;
import java.util.Stack;
import java.io.IOException;

public class Land {
	private static final int xSize = 400;
	private static final int ySize = 600;
	private static Stack<Coordinate> coordinateStack;
	private static ArrayList<Integer> landAreas;		// Holds areas for each separate section of fertile land
	private static Coordinate[][] map;
	
	/**
	 * Constructor
	 */
	public Land() {
		coordinateStack = new Stack<Coordinate>();
		landAreas = new ArrayList<Integer>();
		map = new Coordinate[xSize][ySize];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Coordinate(i, j);
			}
		}
	}

	/**
	 * Fills the map with the given barren land areas
	 * @param barrenLandString
	 */
	public void fillBarrenLand(String barrenLandString) {
		try {
			int[][] barrenLand = parseInput(barrenLandString);
			if (barrenLand != null) { 		// No barren land if null
				for (int i = 0; i < barrenLand.length; i++) {
					if (barrenLand[i][0] > barrenLand[i][2] || barrenLand[i][1] > barrenLand[i][3] || barrenLand[i][2] > 399 || barrenLand[i][3] > 599) {
						throw new IOException("Invalid input: Coordinates are invalid");
					}
					for (int j = barrenLand[i][0]; j <= barrenLand[i][2]; j++) {
						for (int k = barrenLand[i][1]; k <= barrenLand[i][3]; k++) {
							map[j][k].setBarren(true);
						}
					}
				}
			}
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}
	}
	
	/**
	 * Finds and stores the area of each fertile section
	 */
	public void findLandAreas() {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (!map[x][y].isVisited() && !map[x][y].isBarren()) {
					landAreas.add(traverseArea(x,y));
				}
			}
		}
	}

	/**
	 * Traverses from a given coordinate to all the fertile coordinates in the same fertile area
	 * @param a
	 * @param b
	 * @return integer value of the fertile area in which (a, b) is in
	 */
	public int traverseArea(int a, int b) {
		coordinateStack.add(map[a][b]);
		Coordinate tempCoordinate = null;
		int x, y = 0;
		int fertileLandPortionArea = 0;
		while (!coordinateStack.isEmpty()) {
			tempCoordinate = coordinateStack.pop();
			x = tempCoordinate.getX();
			y = tempCoordinate.getY();
			if (!map[x][y].isVisited()) {
				map[x][y].setVisited(true);
				fertileLandPortionArea++;
				if (x != xSize - 1 && !map[x+1][y].isBarren()) {	// Add neighbor to right to stack if not barren
					coordinateStack.push(map[x+1][y]);
				}
				if (y != ySize - 1 && !map[x][y+1].isBarren()) {    // Add neighbor above to stack if not barren
					coordinateStack.push(map[x][y+1]);
				}
				if (x != 0 && !map[x-1][y].isBarren()) {			// Add neighbor to left to stack if not barren
					coordinateStack.push(map[x-1][y]);
				}
				if (y != 0 && !map[x][y-1].isBarren()) {			// Add neighbor below to stack if not barren
					coordinateStack.push(map[x][y-1]);
				}
			}
		}
		return fertileLandPortionArea;
	}

	/**
	 * Parses the Array List containing each fertile land area into a string from smallest to largest area
	 * @return string of fertile land areas from smallest to largest
	 */
	public String getLandAreas() {
		landAreas.sort(null);
		String landAreaString = "";
		for (int i = 0; i < landAreas.size(); i++) {
			landAreaString += (landAreas.get(i) + " ");
		}
		return landAreaString;
	}
	
	/**
	 * Parses a string input of barren land into a 2D array
	 * The first index contains the number of barren rectangles, and the second index contains the 4 value of each rectangle.
	 * @param input
	 * @return a 2D containing the coordinates of a barren land rectangle
	 * @throws IOException if coordinates don't have the 4 location integers
	 */
	private static int[][] parseInput(String input) throws IOException {
		// Remove all special characters from string, leaving only numbers and spaces.
		input = input.replace("{", "");
		input = input.replace("\"", "");
		input = input.replace(",", "");
		input = input.replace("}", "");
		
		String[] splitString = input.split(" ");
		
		if (splitString.length > 0 && splitString[0] == "") {  // Check for different instances of no-input (e.g. "{" "}" or "{}" or "{ }"
			return null; // returning null signals no barren land
		}
		
		if (splitString.length % 4 != 0) {
			throw new IOException("Invalid input: Coordinate is missing a location value.");
		}
		
		int[][] parsedString = new int [splitString.length / 4][4];
		
		for (int i = 0; i < splitString.length / 4; i++) {
			for (int j = 0; j < 4; j++) {
				parsedString[i][j] = Integer.valueOf(splitString[i*4 + j]);
			}
		}

		return parsedString;
	}
}

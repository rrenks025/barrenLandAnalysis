package com.targetCaseStudy.barrenLandAnalysis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static Land myLand;
	
	public static void main(String[] args) {
		String testString = "";
//		testString = "{\"48 192 351 207\", \"48 392 351 407\", \"120 52 135 547\", \"260 52 275 547\"}"; 
//		testString = "{\" \"}"; 				// Tests empty input
//		testString = "{\"0 0 400 599\"}";	// Tests for error when x >= 400
//		testString = "{\"0 0 399 600\"}";	// Tests for error when y >= 600
//		testString = "{\"10 10 0 20\"}";		// Tests for error when bottom left x-coord is larger than top right x-coord
//		testString = "{\"10 10 20 0\"}";		// Tests for error when bottom left y-coord is larger than top right y-coord
//		testString = "{\"48 192 207\"}";		// Tests for error when a coordinate does not have 
		
		myLand = new Land();
		
		try {
			BufferedReader getTestString = new BufferedReader(new InputStreamReader(System.in));
			testString = getTestString.readLine();
			getTestString.close();
		}
		catch (IOException e) {
			System.err.println("Unable to read input.");
		}
	   
//		for (int i = 0; i < args.length; i++) {
//			testString += args[i];
//			testString += " ";
//		}
		
		myLand.fillBarrenLand(testString);
		myLand.findLandAreas();
		System.out.println(myLand.getLandAreas());
	}
}

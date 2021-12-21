package com.targetCaseStudy.barrenLandAnalysis;

public class Coordinate {
	private int x;
	private int y;
	private boolean visited;
	private boolean barren;
	private boolean addedToStack;

	/**
	 * Constructor
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		visited = false;
		barren = false;
		addedToStack = false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isBarren() {
		return this.barren;
	}
	
	public void setBarren(boolean barren) {
		this.barren = barren;
	}
	
	public boolean isAddedToStack() {
		return this.addedToStack;
	}
	
	public void setAddedToStack(boolean addedToStack) {
		this.addedToStack = addedToStack;
	}
}

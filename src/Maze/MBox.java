package Maze;

import Dijkstra.VertexInterface;

public abstract class MBox 
	implements VertexInterface {
	
	protected int x;
	protected int y;
	protected String label;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Constructor of the class MBox with given coordinates in the Maze
	 * @param x the x coordinate (horizontal)
	 * @param y the y coordinate (vertical)
	 */
	public MBox(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
		}
	
	public int getY() {
		return y;
	}
	
	public String getLabel() {
		return label ;
		
	}
	
	public void setLabel(String label) {
		this.label = label;
	}








}

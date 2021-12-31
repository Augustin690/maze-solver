package Maze;

import Dijkstra.VertexInterface;

public abstract class MBox 
	implements VertexInterface {
	
	private Maze maze;
	private int x;
	private int y;
	private String[][] strings;
	
	public MBox(Maze maze,int x, int y) {
		this.x = x;
		this.y = y;
		this.maze = maze;
	}
	
	public int getX() {
		return x;
		}
	
	public int getY() {
		return y;
	}
	
	public String getLabel() {
		strings = null;
		return strings [getX()][getY()];
		
	}
	

}

package Maze;

import Dijkstra.ASetInterface;
import Dijkstra.VertexInterface;

public class MBox 
	implements VertexInterface {
	
	protected int x;
	protected int y;
	public String label;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public MBox(int x, int y) {
		this.x = x;
		this.y = y;
		this.label = label;
		
		// Constructor for the type MBox, x and y are its coordinates in the Maze which is basically a matrix of MBox
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

	@Override
	public boolean isInA(VertexInterface x, ASetInterface A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSuccessor(VertexInterface x, VertexInterface y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSuccessor(VertexInterface x) {
		// TODO Auto-generated method stub
		return false;
	}



}

package Maze;

import Dijkstra.ASetInterface;
import Dijkstra.VertexInterface;

public class WBox extends MBox {
	
	

	public WBox(int x, int y) {
		super(x, y);
		this.label = "W";
	}

	public double p(VertexInterface x, VertexInterface y) {
		// TODO Auto-generated method stub
		return 0;
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

}

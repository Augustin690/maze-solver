package Maze;

import Dijkstra.ASetInterface;
import Dijkstra.VertexInterface;

public class ABox extends MBox {
	
	

	public ABox(int x, int y) {
		super(x, y);
		this.label = "A";
		// TODO Auto-generated constructor stub
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

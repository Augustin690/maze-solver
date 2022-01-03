package Maze;

import Dijkstra.ASetInterface;
import Dijkstra.VertexInterface;

public class DBox extends MBox {

	public DBox(Maze maze,int x, int y) {
		super(maze,x, y);
		// TODO Auto-generated constructor stub
	}
	public int getX() {
		return x;
		}
	@Override
	public int getY() {
		return y;
	}
	
	private int getPosition() {
		return Maze[DBox.getX()][DBox.getY()];
	}
	//reference sur le type Maze
	
	private MBox getNeighbour() {
		//Il faut demander au labyrinthe quels sont les voisins de la case
		int x = MBox.getX();
		int y = MBox.getY();
		for (int i= x-1 ; i<= x+1;i++) {
			for (int j=y-1; j<= y+1;j++) {
				return MBox(i,j) ;
				
			}
		}
		if (DBox.getX() = width -1) {
			if (DBox.getY()= length -1)
		}
	    
		
	}
	@Override
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

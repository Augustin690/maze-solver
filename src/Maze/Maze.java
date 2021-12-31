package Maze;
import java.util.ArrayList;

import Dijkstra.GraphInterface;
import Dijkstra.VertexInterface;

public class Maze 
	implements GraphInterface {
	
	public int width;
	public int length;

	public Maze(int width,int length) {
		String [][] maze = new String[width][length];
	}
	ArrayList<MBox> mboxesList = new ArrayList<MBox>();
	//ajouter les cases en faisant .add?
	
	public MBox getMbox() {
		int x = MBox.getX();
		int y = MBox.getY();
		return MBox(x,y);
	}
	
	{
		MBox[][] boxes = null;
		boxes[0][0] = new DBox(this,0,0);
	}

	@Override
	public GraphInterface buildGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> arrays = new ArrayList<VertexInterface>();
		for (int i=0; i<width;i++) {
			for (int j=0;j<length;j++) {
				arrays.add(VertexInterface);
			}
		}
		return arrays;
	}

	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWeight(VertexInterface src, VertexInterface dst) {
		// TODO Auto-generated method stub
		return 0;
	}

}

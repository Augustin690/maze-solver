package Dijkstra;

import java.util.ArrayList;


public interface GraphInterface {
	
	public ArrayList<VertexInterface> getAllVertices2();
	//Returns an arrayList of all of the vertices of the graph
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) ;
	//Returns the successor of vertex
	
	public int getWeight(VertexInterface src,VertexInterface dst) ;
	//Returns the weight of the path between the vertices src and dst
	
	boolean isSuccessor(VertexInterface x, VertexInterface y,GraphInterface g );
	//returns true if y is a successor of x in the graph g
	
	public boolean isInG(VertexInterface x);
	//returns true if x is in g
	
	public int getNumber();
	//returns the number of vertices in g

	

}
		



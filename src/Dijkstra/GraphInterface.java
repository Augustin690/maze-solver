package Dijkstra;

import java.util.ArrayList;


public interface GraphInterface {
	
	public ArrayList<VertexInterface> getAllVertices();
	//Returns an arrayList of all of the vertices of the graph
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) ;
	//Returns the successor of vertex
	
	public int getWeight(VertexInterface src,VertexInterface dst) ;
	//Returns the weight of the path between the vertices src and dst



	
	
	
	
	
	
	
	
	
	
	}
		



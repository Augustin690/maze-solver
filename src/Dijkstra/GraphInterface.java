package Dijkstra;

import java.util.ArrayList;

public interface GraphInterface {
	
	public GraphInterface buildGraph();
	//pour construire notre graphe qui sera l'objet de notre programme --> liste des sommets/vertex du graphe
	
	public ArrayList<VertexInterface> getAllVertices();
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) ;
	
	public int getWeight(VertexInterface src,VertexInterface dst) ;
	
	
	
	
	
	
	
	
	
	
	}
		



package Dijkstra;


public interface ASetInterface {
	
	public ASetInterface union(VertexInterface x);
	//in order to add a vertex to A
	
	public VertexInterface searchMin();
	//to search y not in A with pi(y) minimal
	
	public boolean isInA(VertexInterface x);
	//returns true  is x is in A

	
	
	
	

}

package Dijkstra;
public interface VertexInterface {
	
	public boolean isInA(VertexInterface x, ASetInterface A);
	//return if whether or not the Vertex is in the AsetInterface A
	
	public boolean isSuccessor(VertexInterface x);
	//return if whether or not x is the successor of a given Vertex.
	
	public String getLabel();
	//getter for the String Label: A for ABox, W for WBox...

	boolean isSuccessor(VertexInterface x, VertexInterface y);
	

}

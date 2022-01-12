package Dijkstra;
public interface VertexInterface {
	
	//public double p(VertexInterface x ,VertexInterface y);
	//Weigth function
	
	public boolean isInA(VertexInterface x, ASetInterface A);
	//return if whether or not the Vertex is in the AsetInterface A
	
	public boolean isSuccessor(VertexInterface x, VertexInterface y);
	//return if whether or not y is the successor of x.
	
	public String getLabel();
	//getter for the String Label: A for ABox, W for WBox...
	

}

package Dijkstra;
public interface VertexInterface {
	
	public double p(VertexInterface x ,VertexInterface y);
	//Fonction poids de l'arc (x,y) ie distance de x � y o� x dans A et y pas dans A
	
	public boolean isInA(VertexInterface x, ASetInterface A);
	
	public boolean isSuccessor(VertexInterface x, VertexInterface y);
	
	public static String getLabel();
	
	

}

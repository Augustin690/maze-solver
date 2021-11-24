

public interface ASetInterface {
	//recherche de methodes a implementer

	public ASetInterface initASet(VertexInterface r);
	//pour initialiser A au début du programme (utile?)
	
	public ASetInterface union(VertexInterface x);
	//pour réaliser l'union de A et de pivot à la fin de la boucle
	
	public VertexInterface searchMin(ASetInterface A);
	
	
	
	
	

}

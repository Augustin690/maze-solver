

public interface ASetInterface {
	//recherche de methodes a implementer

	public ASetInterface initASet(VertexInterface r);
	//pour initialiser A au d�but du programme (utile?)
	
	public ASetInterface union(VertexInterface x);
	//pour r�aliser l'union de A et de pivot � la fin de la boucle
	
	public VertexInterface searchMin(ASetInterface A);
	
	
	
	
	

}

package Dijkstra;
import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface,VertexInterface> implements PreviousInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Previous() {
		
		new Hashtable<VertexInterface,VertexInterface>(150);
	}
    
	
	@Override
	public VertexInterface father(VertexInterface x) {
		// TODO Auto-generated method stub
		return null;
	}

}

package Maze;

public class DBox extends MBox {

	public DBox(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getX() {
		return x;
		}
	@Override
	public int getY() {
		return y;
	}
	
	private int getPosition() {
		return Maze[DBox.getX()][DBox.getY()];
	}
	//reference sur le type Maze
	
	private MBox getNeighbour() {
		//Il faut demander au labyrinthe quels sont les voisins de la case
		int x = MBox.getX();
		int y = MBox.getY();
		for (int i= x-1 ; i<= x+1;i++) {
			for (int j=y-1; j<= y+1;j++) {
				return MBox(i,j) ;
				
			}
		}
		if (DBox.getX() = width -1) {
			if (DBox.getY()= length -1)
		}
	    
		
	}
	
	
	
	

}

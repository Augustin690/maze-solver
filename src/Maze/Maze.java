package Maze;
import java.util.ArrayList;

public class Maze 
	implements GraphInterface {
	
	public int width;
	public int length;

	public Maze(int width,int length) {
		String [][] maze = new String[width][length];
	}
	ArrayList<MBox> mboxesList = new ArrayList<MBox>();
	//ajouter les cases en faisant .add?
	
	public MBox getMbox() {
		int x = MBox.getX();
		int y = MBox.getY();
		return MBox(x,y);
	}

}

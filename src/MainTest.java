import java.io.IOException;
import Maze.Maze;


public class MainTest {
	
	public static void main(String[] args) throws IOException {
		Maze maze = new Maze();
		maze.initFromTextFile("data/labyrinthe.txt");
	}
	
}

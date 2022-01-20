import java.io.IOException;
import Maze.Maze;
import Maze.MazeReadingException;


public class MainTest {
	
	public static void main(String[] args) throws IOException, MazeReadingException {
		Maze maze = new Maze();
		maze.initFromTextFile("data/labyrinthe.txt");
		maze.saveToTextFile("data/labyrinthe2.txt");
		System.out.println("Maze successfully constructed from text file");
	}
	
}

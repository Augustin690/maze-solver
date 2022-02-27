import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Maze.ABox;
import Maze.DBox;
import Maze.Maze;
import Maze.MazeReadingException;
import Dijkstra.Dijkstra;
import Dijkstra.Previous;
import Dijkstra.VertexInterface;

public class MainTest {
	
	/*public static void main1(String[] args) throws IOException, MazeReadingException {
		Maze m = new Maze(10, 10);
		m.initFromTextFile("data/labyrinthe.txt");
		m.getAllVertices();
		m.saveToTextFile("data/labyrinthe3.txt");
		System.out.println("m successfully constructed from text file");
	}*/
	

	
	public static void main(String[] args) throws IOException, MazeReadingException {
		ArrayList<Integer> dimensions = Maze.readingFile("data/Untitled 1");
		int d = dimensions.get(0);
		int w = dimensions.get(1);
		Maze m = new Maze(d,w);
		m.initFromTextFile("data/Untitled 1");
		DBox D = m.Start();
		System.out.println(D.getLabel());
		System.out.println(D.getX());
		System.out.println(D.getY());
		Previous pr = Dijkstra.dijkstra(m, D);
		System.out.println("Dijkstra is good");
		ABox A = m.findEnd();
		ArrayList<VertexInterface> list = m.traceBack(A, D, pr);
		Maze.readingFile("data/Untitled 1");
		m.saveToTextFile("data/untitled1Solved", list);
		if(list!= null) {
			System.out.println("here is the solution");
		}
		else {
			System.out.println("no solution");
		}
		Maze.readingFile("data/untitled1Solved");
	}
}

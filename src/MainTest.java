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
	
	public static void readingFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String st;
		
		while ((st = br.readLine()) != null)

        System.out.println(st);
	}
	
	public static void main(String[] args) throws IOException, MazeReadingException {
		Maze m = new Maze(10,10);
		m.initFromTextFile("data/labyrintheplusdur");
		DBox D = m.Start();
		System.out.println(D.getLabel());
		System.out.println(D.getX());
		System.out.println(D.getY());
		Previous pr = Dijkstra.dijkstra(m, D);
		System.out.println("Dijkstra is good");
		ABox A = m.findEnd();
		ArrayList<VertexInterface> list = m.traceBack(A, D, pr);
		readingFile("data/labyrintheplusdur");
		m.saveToTextFile("data/labyrinthefacileSolved", list);
		if(list!= null) {
			System.out.println("here is the solution");
		}
		else {
			System.out.println("no solution");
		}
		readingFile("data/labyrinthefacileSolved");
	}
}

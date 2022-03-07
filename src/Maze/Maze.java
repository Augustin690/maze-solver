package Maze;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

import Dijkstra.GraphInterface;
import Dijkstra.Previous;
import Dijkstra.VertexInterface;

public class Maze

  implements GraphInterface {

	private static int depth;
	private static int width;
	private static MBox[][] maze;
	
	public Maze(int depth, int width) {
		Maze.depth = depth;
		Maze.width = width;
		Maze.maze = new MBox[width][depth];
	}
	

	/**
	 * Method that returns all of the vertices of the Maze
	 * @return an ArrayList of VertexInterface containing all of the vertices (MBox) of the Maze
	 */
	public static ArrayList<VertexInterface> getAllVertices() {             //returns the list of all the vertices (Mboxes) that the maze contains
		ArrayList<VertexInterface> arrays = new ArrayList<VertexInterface>();
		for (int j=0;j<depth;j++) {
			for (int i=0; i<width;i++) {
			 
				MBox boxij = maze[i][j];
				arrays.add(boxij);
			}
		}
		return arrays;
	}


	@Override
	/**
	 * Returns the list of the vertices that are accessible (not walls) starting form "vertex", a wall has no neighbors
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> arrays = new ArrayList<VertexInterface>();
		MBox box = (MBox)vertex ;
		int x = box.getX();
		int y = box.getY();
		int w = width -1 ;
		int d = depth -1;
		
		if (box.getLabel().contentEquals("W")) {    //a wall cannot have any successors
			return null;
		}
		
		if(x == 0) {
			if(y>0 && y<d) {
				arrays.add(maze[x][y+1]);
				arrays.add(maze[x][y-1]);
				arrays.add(maze[x+1][y]);
				}
			else if(y == 0) {
				arrays.add(maze[x][y+1]);
				arrays.add(maze[x+1][y]);
			}
			else {
				arrays.add(maze[x][y-1]);
				arrays.add(maze[x+1][y]);
			}
		}
		else if (y == 0) {
			if(x<w) {
				arrays.add(maze[x][y+1]);
				arrays.add(maze[x-1][y]);
				arrays.add(maze[x+1][y]);
			}
			else {				
			arrays.add(maze[x][y+1]);
			arrays.add(maze[x-1][y]);
			}
		}
		else if(x == w) {
			if(y<d) {
				arrays.add(maze[x][y+1]);
				arrays.add(maze[x][y-1]);
				arrays.add(maze[x-1][y]);	
			}
			else {
				arrays.add(maze[x][y-1]);
				arrays.add(maze[x-1][y]);
			}
		}
		else if(y == d) {
			arrays.add(maze[x][y-1]);
			arrays.add(maze[x-1][y]);
			arrays.add(maze[x+1][y]);
		}
		else {                                  
			arrays.add(maze[x][y-1]);
			arrays.add(maze[x-1][y]);
			arrays.add(maze[x+1][y]);
			arrays.add(maze[x][y+1]);
		}
		return arrays;
	}

	@Override
	public int getWeight(VertexInterface src, VertexInterface dst) {   //Method that will return the weight of an arc between 2 side-to-side Vertices (MBoxes): 1 if they are not walls (WBox), plus infinity if one of them is
		MBox boxsrc = (MBox) src;
		MBox boxdst = (MBox) dst;
		if (boxsrc.getLabel().contentEquals("W")) {
			return Integer.MAX_VALUE;
		}
		if(boxdst.getLabel().contentEquals("W")) {
			return Integer.MAX_VALUE;
		}
		else {
			return 1;
		}
	}
	
	/**
	 * Initializes the Maze from a text file that represents a maze 
	 * @param fileName the name of the file
	 * @throws IOException
	 * @throws MazeReadingException
	 */
	public final void initFromTextFile(String fileName) throws IOException, MazeReadingException {  
		
        Reader reader = new FileReader(fileName);
        try (BufferedReader br = new BufferedReader(reader)) {
			maze = new MBox[width][depth];
			
			for(int j =0; j<depth;j++) {
     
				String line = br.readLine();
				
				for(int i = 0; i<width;i++) {
					
					char label = line.charAt(i);
					
					if (label == 'W') {
						maze[i][j] = new WBox(i,j) ;
				         }
					else if (label == 'E') {
						maze[i][j] = new EBox(i,j) ; 
						} 
					else if (label == 'D') {
						maze[i][j] = new DBox(i,j) ;
						} 
					else if (label == 'A') {
						maze[i][j] = new ABox(i,j) ;
						}
					else {
						throw new MazeReadingException(fileName ,89,"invalid letter");
					}
				}
			                                           
			}
		}
        
    }
	
	/**
	 * Reads a text file and displays it to the console, returns a 2-sized ArrayList that contains the width and depth of the file
	 * @param fileName the name of the file to read
	 * @return an ArrayList of Integers, the index 0 Int represents the depth, the index 1 the width
	 * @throws IOException
	 */
	public static ArrayList<Integer> readingFile(String fileName) throws IOException {
		
		String st;
		int k = 0;
		int l = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			
			while ((st = br.readLine()) != null) {
				System.out.println(st);
				l = st.length();
				k++;
			}

			System.out.println("width: " + l);
			System.out.println("depth: " + k);
			list.add(k);
			list.add(l);
			
			return list;
		}
	}

	/**
	 *  Saves the current maze in the form of a text file
	 */
	public final void saveToTextFile(String fileName, ArrayList<VertexInterface> list) throws IOException, MazeReadingException {  //method that will save the Maze into a text file "fileName"
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileName);
			for(int j = 0; j < Maze.depth; j++) {
			   for(int i =0; i < Maze.width; i++) {
				    String label = maze[i][j].getLabel();
				    
					    if(list !=null && label.contentEquals("E") && list.contains(maze[i][j])){
					    	pw.print("+");  	
					    }
				    
					    else {
					    	pw.print(maze[i][j].getLabel());
					    }
				}
			   pw.println();
			   }
		 } catch (Exception e) {
			e.printStackTrace();
			}
		finally {
			try {
				pw.close();
			} catch (Exception e){}
		}
   }
	
	/**
	 * Finds the start in a maze
	 * @return the unique DBox of the maze
	 */
	public final DBox Start() {
		DBox start = null;
		for(int i = 0; i < Maze.width; i++) {
			   for(int j =0; j < Maze.depth; j++) {
	            	String label= maze[i][j].getLabel();
	    			if(label.contentEquals("D")) {
	    				start = (DBox) maze[i][j];
	    				}
				}	
	}
		return start;
	}
	
	/**
	 * Finds the end of the maze
	 * @return the unique ABox of the maze
	 */
	public final ABox findEnd() {
		ABox end = null;
		for(int i = 0; i < Maze.width; i++) {
			   for(int j =0; j < Maze.depth; j++) {
				   System.out.println("i" + i + "j" + j);
	            	String label= maze[i][j].getLabel();
	    			if(label.contentEquals("A")) {
	    				end = (ABox) maze[i][j];
	    				}
				}	
	}
		return end;
	}

	@Override
	/**
	 * Returns wether a given Vertex is in a maze or not
	 */
	public boolean isInG(VertexInterface x) {
		ArrayList<VertexInterface> list = 	Maze.getAllVertices();
		return list.contains(x);
	}

	@Override
	public int getNumber() {
		return width*depth;
	}
	
	/**
	 * Returns the shortest path between two vertices of the maze if there is one
	 * @param x the first vertex
	 * @param y the second vertex
	 * @param pr hashtable that contains the shortest paths between all the vertices of the maze
	 * @return an ArrayList of vertices (MBox) that represents the path between the two vertices
	 */
	public ArrayList<VertexInterface> traceBack(VertexInterface x, VertexInterface y,Previous pr) {
		
		ArrayList<VertexInterface> list = new ArrayList<VertexInterface>();
		
		while(x != y ) {
			if(pr.get(x)!= null) {
				list.add(x);
				System.out.println(x.getLabel());
				x = pr.get(x);
				System.out.println(x.getLabel());
			}
			else {
				System.out.println("there is no solution");
				return null;
			}

		}
		System.out.println(list);
		System.out.println(list.size());
		return list;				
	}


	@Override
	public boolean isSuccessor(VertexInterface x, VertexInterface y, GraphInterface m) {  	//returns true if y is a successor of x
		// TODO Auto-generated method stub
		ArrayList<VertexInterface> list = m.getSuccessors(x);
		return list.contains(y);
	}

	@Override
	/**
	 * Returns all the vertices (MBox) of the maze
	 */
	public ArrayList<VertexInterface> getAllVertices2() {
		// TODO Auto-generated method stub
		return Maze.getAllVertices();
	}
	
	public static MBox[][] getMaze() {
		
		return maze;
	}
	
	public void setMaze(MBox[][] maze) {
		
		Maze.maze = maze;
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getDepth() {
		return depth;
	}
	
	public static void setWidth(int width) {
		
		Maze.width = width;
		
	}
	
	public static void setDepth(int depth) {
		
		Maze.depth = depth;
	}
}



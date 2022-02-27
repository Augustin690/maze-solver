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
	

	public static ArrayList<VertexInterface> getAllVertices() {             //returns the list of all the vertices (Mboxes) that the maze contains
		ArrayList<VertexInterface> arrays = new ArrayList<VertexInterface>();
		for (int i=0; i<width;i++) {
			for (int j=0;j<depth;j++) {
				MBox boxij = maze[i][j];
				arrays.add(boxij);
				/*String label = maze[j][i].getLabel();
				System.out.println(label);*/
			}
		}
		return arrays;
	}

	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {  //returns the list of the vertices that are accessible starting form  "vertex" (basically its neighbors that are not walls)
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
	
	public final void initFromTextFile(String fileName) throws IOException, MazeReadingException {  
		
        Reader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader);  
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
	
	public static ArrayList<Integer> readingFile(String fileName) throws IOException {
		
		String st;
		int k =0;
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

	
	public final void saveToTextFile(String fileName, ArrayList<VertexInterface> list) throws IOException, MazeReadingException {  //method that will save the Maze into a text file "fileName"
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileName);
			for(int j = 0; j < Maze.depth; j++) {
			   for(int i =0; i < Maze.width; i++) {
				    String label = maze[i][j].getLabel();
				    if(list != null) {
					    if(label.contentEquals("E") && list.contains(maze[i][j])){
					    	pw.print("+");  	
					    }
					    else {
					    	pw.print(maze[i][j].getLabel());
					    }
				    }
				    else {
				    	System.out.println("no solution");
				    	return;
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
	
	public final ABox findEnd() {
		ABox end = null;
		for(int i = 0; i < Maze.width; i++) {
			   for(int j =0; j < Maze.depth; j++) {
	            	String label= maze[i][j].getLabel();
	    			if(label.contentEquals("A")) {
	    				end = (ABox) maze[i][j];
	    				}
				}	
	}
		return end;
	}
	@Override
	public boolean isInG(VertexInterface x) {
		ArrayList<VertexInterface> list = 	Maze.getAllVertices();
		return list.contains(x);
	}

	@Override
	public int getNumber() {
		return width*depth;
	}
	
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
}



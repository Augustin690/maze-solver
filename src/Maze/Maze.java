package Maze;
import java.util.ArrayList;
import java.io.*;
import Dijkstra.GraphInterface;
import Dijkstra.Previous;
import Dijkstra.VertexInterface;

public class Maze

  implements GraphInterface {

	private static int width;
	private static int depth;
	private static MBox[][] maze;
	
	public Maze(int depth, int width) {
		Maze.depth = depth;
		Maze.width = width;
		Maze.maze = new MBox[depth][width];
	}
	

	public static ArrayList<VertexInterface> getAllVertices() {             //returns the list of all the vertices (Mboxes) that the maze contains
		ArrayList<VertexInterface> arrays = new ArrayList<VertexInterface>();
		for (int i=0; i<width;i++) {
			for (int j=0;j<depth;j++) {
				MBox boxij = maze[j][i];
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
		if (boxsrc.getLabel().contentEquals("W") | boxdst.getLabel().contentEquals("W")) {
			return Integer.MAX_VALUE;
		}
		else {
			return 1;
		}
	}
	
	public final void initFromTextFile(String fileName) throws IOException, MazeReadingException {  //trying to turn a method that reads the file into one that constructs a maze from it
	      
        Reader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader);  
        maze = new MBox[depth][width];
        
        for(int j =0; j<width;j++) {
      
        	String line = br.readLine();
        	
        	for(int i = 0; i<depth;i++) {
        		
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
        			throw new MazeReadingException(fileName,89,"invalid letter");
        		}
        	}
                                                   
        }
        
    }

	
	public final void saveToTextFile(String fileName) throws IOException, MazeReadingException {  //method that will save the Maze into a text file "fileName"
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileName);
			for(int i = 0; i < Maze.width; i++) {
			   for(int j =0; j < Maze.depth; j++) {
	            	pw.print(maze[j][i].getLabel());
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
	
	public final DBox findStart() {
		DBox start = null;
		for(int i = 0; i < Maze.width; i++) {
			   for(int j =0; j < Maze.depth; j++) {
	            	String label= maze[j][i].getLabel();
	    			if(label.contentEquals("D")) {
	    				start = (DBox) maze[j][i];
	    				}
				}	
	}
		return start;
	}
	
	public final ABox findEnd() {
		ABox end = null;
		for(int i = 0; i < Maze.width; i++) {
			   for(int j =0; j < Maze.depth; j++) {
	            	String label= maze[j][i].getLabel();
	    			if(label.contentEquals("A")) {
	    				end = (ABox) maze[j][i];
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
			list.add(x);
			System.out.println(x.getLabel());
			x = pr.get(x);
			System.out.println(x.getLabel());
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
	
	
		
}



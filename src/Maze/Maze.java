package Maze;
import java.util.ArrayList;
import java.io.*;
import Dijkstra.GraphInterface;
import Dijkstra.VertexInterface;
import Maze.MBox;

public class Maze

  implements GraphInterface {

	private int width;
	private int depth;
	private MBox[][] maze;
	
	public Maze(int depth, int width) {
		this.depth = depth;
		this.width = width;
		this.maze = new MBox[depth][width];
	}
	
	

	@Override
	public ArrayList<VertexInterface> getAllVertices() {                        //returns the list of all the vertices (Mboxes) that make the maze
		ArrayList<VertexInterface> arrays = new ArrayList<VertexInterface>();
		for (int i=0; i<width;i++) {
			for (int j=0;j<depth;j++) {
				MBox boxij = new MBox(i,j);
				arrays.add(boxij);
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
		
		if (box.getLabel().contentEquals("W")) {    //a wall cannot have any successors
			return null;
		}
		else {                                    // the vertex is not a wall 
			for (int i = x-1; i <= x+1; i++) {
				for (int j = y-1 ; j <= y+1; j++) {
					MBox boxij = new MBox(i,j);
					while (boxij.getLabel().compareTo("W")!=0) {   //ensuring the neighbors are not walls nor vertex itself
						while(i != x &&  j != y) {
							arrays.add(boxij);}                    //adding the successors of vertex (the neighbors that are not walls nor vertex) to the list
						}
					}
				}
		}
		return arrays;
	}

	@Override
	public double getWeight(VertexInterface src, VertexInterface dst) {   //Method that will return the weight of an arc between 2 side-to-side Vertices (MBoxes): 1 if they are not walls (WBox), plus infinity if one of them is
		MBox boxsrc = (MBox) src;
		MBox boxdst = (MBox) dst;
		if (src.getLabel().contentEquals("W") | dst.getLabel().contentEquals("W")) {
			return Double.POSITIVE_INFINITY;
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
			for(int i = 0; i < this.width; i++) {
			   for(int j =0; j < this.depth; j++) {
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

	@Override
	public boolean isInG(VertexInterface x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
		
		
	}



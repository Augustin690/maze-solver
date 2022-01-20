package Maze;
import java.util.ArrayList;
import java.io.*;
import Dijkstra.GraphInterface;
import Dijkstra.VertexInterface;
import Maze.MBox;

public class Maze

  implements GraphInterface {

	private int width = 10;
	private int depth = 10;

	MBox[][] boxes = new MBox[width][depth];
	private Maze maze;

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
	      
        Reader reader = new FileReader(fileName);  //creating reader to read the text file
        BufferedReader br = new BufferedReader(reader); //creating a default size bufferedreader 
        String line = null;  //initializing the String "line" that will represent the lines of the text file
        
        while((line = br.readLine())!= null) { // I want to add each line of the file to the maze but you cannot add strings to a matrix of MBox: I have to figure that out --> gotta use getLabel() method
        	int j = 0;
        	
        	for(int i = 0; i<line.length();i++) {
        		
        		if (line.charAt(i) == 'W') {
        			boxes[i][j] = new WBox(i,j) ;
        	         }
        		if (line.charAt(i) == 'E') {
        			boxes[i][j] = new EBox(i,j) ; 
        			} 
        		if (line.charAt(i) == 'D') {
        			boxes[i][j] = new DBox(i,j) ;
        			} 
        		if (line.charAt(i) == 'A') {
        			boxes[i][j] = new ABox(i,j) ;
        			}
        		if (line.charAt(i)!= 'W' && line.charAt(i) != 'E'&& line.charAt(i) != 'D' && line.charAt(i)!= 'A' ) {
        			throw new MazeReadingException(fileName,89,"invalid file");
        		}
        	}
        	j++;
                                                   
        }
        br.close();
    }

	
	public final void saveToTextFile(String fileName) throws IOException, MazeReadingException {  //method that will save the Maze into a text file "fileName"
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(fileName);
			
			for(int i = 0; i < width; i++) {
				
				for(int j =0; j < depth; j++) {
					
					if(boxes[i][j].getLabel().contentEquals("W")) {
						pw.print("W");
					}
					if(boxes[i][j].getLabel().contentEquals("E")) {
						pw.print("E");
					}
					if(boxes[i][j].getLabel().contentEquals("A")) {
						pw.print("A");
					}
					if(boxes[i][j].getLabel().contentEquals("D")) {
						pw.print("D");
					}
				
				}
				
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



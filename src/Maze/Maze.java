package Maze;
import java.util.ArrayList;
import java.io.*;
import Dijkstra.GraphInterface;
import Dijkstra.VertexInterface;
import Maze.MBox;

public class Maze

  extends ArrayList<ArrayList<MBox>>

  implements GraphInterface {

	private int width;
	private int length;

	ArrayList<ArrayList<MBox>> boxes;



	@Override
	public ArrayList<VertexInterface> getAllVertices() {                        //returns the list of all the vertices (Mboxes) that make the maze
		ArrayList<VertexInterface> arrays = new ArrayList<VertexInterface>();
		for (int i=0; i<width;i++) {
			for (int j=0;j<length;j++) {
				MBox boxij = new MBox(i,j);
				arrays.add(boxij);
			}
		}
		return arrays;
	}

	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {        //returns the list of the vertices that are accessible starting form  "vertex" (basically its neighbors that are not walls)
		ArrayList<VertexInterface> arrays = new ArrayList<VertexInterface>();
		MBox box = (MBox)vertex ;
		int x = box.getX();
		int y = box.getY();
		
		if (box.getLabel().contentEquals("W")) {                //a wall cannot have any successors
			return null;
		}
		else {                                                // the vertex is not a wall 
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
	public int getWeight(VertexInterface src, VertexInterface dst) {         //Method that will return the weight of an arc between 2 side-to-side Vertices (MBoxes): 1 if they are not walls (WBox), plus infinity if one of them is
		MBox boxsrc = (MBox) src;
		MBox boxdst = (MBox) dst;
		
		
	// TODO 
		return 0;
	}
	
	public final void initFromTextFile(String fileName) throws IOException {  //trying to turn a method that reads the file into one that constructs a maze from it
	      
        Reader reader = new FileReader(fileName);  //creating reader to read the text file

        
        BufferedReader br = new BufferedReader(reader); //creating a default size bufferedreader 
    
        String line = null;  //initializing the String "line" that will represent the lines of the text file
        
        Maze maze = (Maze) boxes;  // creating an object of type Maze which is also a matrix of MBox
        
        while((line = br.readLine())!= null) {
            maze.add(line);                       // I want to add each line of the file to the maze but you cannot add strings to a matrix of MBox: I have to figure that out
        }
        br.close();
    }
	public final void saveToTextFile(String fileName) {           //method that will save the Maze into a text file "fileName"
	
		
	}
		
		
	}



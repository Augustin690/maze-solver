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
	public ArrayList<VertexInterface> getAllVertices() {
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
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
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
	public int getWeight(VertexInterface src, VertexInterface dst) {
		MBox boxsrc = (MBox) src;
		MBox boxdst = (MBox) dst;
		
		
	// TODO 
		return 0;
	}
	
	public final void initFromTextFile(String fileName) throws IOException {
	      // On crée un  Reader pour lire le fichier.
        Reader reader = new FileReader(fileName);

        // On crée un buffered reader de taille par défaut
        BufferedReader br = new BufferedReader(reader);
    
        String line = null;
        
        Maze maze = (Maze) boxes;
        
        while((line = br.readLine())!= null) {
            maze.add(line); 
        }
        br.close();
    }
	public final void saveToTextFile(String fileName) {
	
		
	}
		
		
	}



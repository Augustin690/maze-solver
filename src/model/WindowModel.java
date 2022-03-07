package model;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import Dijkstra.Dijkstra;
import Dijkstra.Previous;
import Dijkstra.VertexInterface;
import GUI.DrawingPanel;
import GUI.MBoxPanel;
import GUI.MazeApp;
import Maze.ABox;
import Maze.DBox;
import Maze.EBox;
import Maze.Maze;
import Maze.MazeReadingException;

@SuppressWarnings("deprecation")
public final class WindowModel extends Observable {
	
	private static Maze m;
	private Color currentColor;
	private boolean modified;
	private ArrayList<VertexInterface> solutionPath;
	private int width ;
	private int depth ;
	
	
	public WindowModel(){
		
		super();
		m = new Maze(10,10);
		for(int j = 0; j < Maze.getDepth(); j++) {
			   for(int i =0; i < Maze.getWidth(); i++) {
				   
				   Maze.getMaze()[i][j] = new EBox(i,j);
			   }
		}
	    currentColor = Color.PINK;
	    setWidth(10);
	    setDepth(10);
	
	}
	
	/**
	 * Solves the Maze if possible thanks to dijkstra's algorithm and then update the view 
	 */
	public void solveMaze() {
		
		if(Ctrl.isImported() && !Ctrl.isModified()) {
		
			/*Ctrl.setImported(false);*/
			System.out.println("solving" + Ctrl.isImported());
			/*System.exit(0);*/
			DBox D = m.Start();
			Previous pr = Dijkstra.dijkstra(m, D);
			System.out.println("Dijkstra is good");
			ABox A = m.findEnd();
			solutionPath = m.traceBack(A, D, pr);
			update();
		}
		
		else if(Ctrl.isModified() /*|| Ctrl.isStartSelection() || Ctrl.isEndSelection()*/) {
			
			if(Ctrl.isImported()) {
				
				System.out.println("solvingeditb4update");
				update();
				System.out.println("solvingedit" + Ctrl.isImported());

				DBox D = DrawingPanel.getD();
				
				System.out.println("depart"+ D.getLabel() + D.getX() + D.getY());
				ABox A = m.findEnd();
				System.out.println("arrivee"+ A.getLabel() + A.getX() + A.getY());
				/*System.exit(0);*/
				Previous pr = Dijkstra.dijkstra(m, D);
				System.out.println("Dijkstra is good edit");
				solutionPath = m.traceBack(A, D, pr);
				Ctrl.setModified(false);
				update();
			}
			
			else {
				System.out.println("boucle");
				/*m = new Maze(10,10);*/
				update();
				System.out.println("solving" + Ctrl.isImported());

				DBox D = DrawingPanel.getD();
				
				System.out.println("depart"+ D.getLabel() + D.getX() + D.getY());
				ABox A = m.findEnd();
				System.out.println("arrivee"+ A.getLabel() + A.getX() + A.getY());
				/*System.exit(0);*/
				Previous pr = Dijkstra.dijkstra(m, D);
				System.out.println("Dijkstra is good");
				solutionPath = m.traceBack(A, D, pr);
				Ctrl.setModified(false);
				update();				
			}	
		}
	}
	

	public ArrayList<VertexInterface> getSolutionPath()	{
		
		return solutionPath;
	}
	
	/**
	 * Imports a maze from a text file and displays it
	 * @param file the text file
	 * @param mazeApp the view of the moddel
	 * @throws IOException
	 */
	public void importMaze(File file, MazeApp mazeApp) throws IOException {
		
		if(file!= null) {
			String fileName = file.getAbsolutePath();
			
			ArrayList<Integer> dimensions = Maze.readingFile(fileName);
			int d = dimensions.get(0);
			int w = dimensions.get(1);
			setWidth(w);
			setDepth(d);
			update(new MBoxPanel(mazeApp));
			
			Maze m = new Maze(d,w);
			
			try {
				m.initFromTextFile(fileName);
				
			} catch (IOException | MazeReadingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
			setMazeModel(m);
			
			System.out.println("importMaze update()");
			update();
		}
	  }
	
	/**
	 * Saves a maze displayed on the GUI to a text file
	 * @param fileToSave the name of the text file that will contains the representation of the maze
	 * @throws IOException
	 * @throws MazeReadingException
	 */
	public void saveMaze(File fileToSave) throws IOException, MazeReadingException {
		// TODO Auto-generated method stub
		String fileName = fileToSave.getAbsolutePath();
		
		m.saveToTextFile(fileName, solutionPath);
		
	}
	
	public void selectWall(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		System.out.println("selectwall");
        update(mboxPanel);
		
	}
	
	public void selectStart(MBoxPanel mboxPanel) {
		
		update(mboxPanel);
	}
	
	public void selectEnd(MBoxPanel mboxPanel) {
		
		update(mboxPanel);
	}
	
	
	public void setChanged() {
		
		super.setChanged();
		setModified(true);
	}
	public void update() {
		
		setChanged();
		System.out.println(hasChanged());
		notifyObservers();
	}
	
	public void update(MBoxPanel mboxPanel) {
		
		System.out.println("model.update(mboxpanel)");
		setChanged();
		notifyObservers(mboxPanel);
	}

	public static Maze getMazeModel() {
		return m;
	}
	
	public static void setMazeModel(Maze m) {
		
		WindowModel.m = m;
	}

	public Color getCurrentColor() {
		// TODO Auto-generated method stub
		return currentColor;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public void resetMaze() {
		// TODO Auto-generated method stub
		setChanged();
		notifyObservers();
	}

	public void resetPath() {
		// TODO Auto-generated method stub
		setChanged();
		notifyObservers();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		Maze.setWidth(width);
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
		Maze.setDepth(depth);
	}

}

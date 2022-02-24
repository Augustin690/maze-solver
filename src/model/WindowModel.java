package model;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;

import Dijkstra.Dijkstra;
import Dijkstra.Previous;
import Dijkstra.VertexInterface;
import GUI.DrawingPanel;
import GUI.EndButton;
import GUI.MBoxPanel;
import GUI.MazeApp;
import GUI.StartButton;
import GUI.WallButton;
import Maze.ABox;
import Maze.DBox;
import Maze.EBox;
import Maze.MBox;
import Maze.Maze;
import Maze.MazeReadingException;
import Maze.WBox;

public final class WindowModel extends Observable {
	
	private static Maze m;
	private Color currentColor = Color.PINK;
	private boolean modified;
	private MazeApp mazeApp;
	private ArrayList<VertexInterface> solutionPath;
	
	@SuppressWarnings("deprecation")
	public WindowModel(){
		
		super();
		m = null;
	
	}
	
	public void solveMaze() {
		
		if(MBoxPanel.isImported()) {
			
			MBoxPanel.setImported(false);
			System.out.println("solving" + MBoxPanel.isImported());
			DBox D = m.Start();
			Previous pr = Dijkstra.dijkstra(m, D);
			System.out.println("Dijkstra is good");
			ABox A = m.findEnd();
			solutionPath = m.traceBack(A, D, pr);
			update();
		}
		
		else if(WallButton.isWallsSelection() || StartButton.isStartSelection() || EndButton.isEndSelection()) {
			
			System.out.println("boucle");
			m = new Maze(10,10);
			update();
			System.out.println("solving" + MBoxPanel.isImported());
			
			 for(int i =0; i< Maze.getWidth();i++) {
			    	for(int j = 0; j<Maze.getDepth();j++) {
			    		
			    		System.out.print(Maze.getMaze()[j][i].getLabel());
			    		
			    	}
			    }
			 for(int i =0; i< Maze.getWidth();i++) {
			    	for(int j = 0; j<Maze.getDepth();j++) {
			    		
			    		System.out.print(Maze.getMaze()[i][j]);
			    		
			    	}
			    }
			DBox D = DrawingPanel.getD();
			
			System.out.println("depart"+ D.getLabel() + D.getX() + D.getY());
			ABox A = m.findEnd();
			System.out.println("arrivee"+ A.getLabel() + A.getX() + A.getY());
			/*System.exit(0);*/
			Previous pr = Dijkstra.dijkstra(m, D);
			System.out.println("Dijkstra is good");
			solutionPath = m.traceBack(A, D, pr);
			WallButton.setWallsSelection(false);
			update();
			
		}
	}
	

	public ArrayList<VertexInterface> getSolutionPath()	{
		
		return solutionPath;
	}
	
	public void importMaze(File file, MazeApp mazeApp) {
		
		if(file!= null) {
			String fileName = file.getAbsolutePath();
			Maze m = new Maze(10,10);
			
			try {
				m.initFromTextFile(fileName);
				
			} catch (IOException | MazeReadingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
			setMazeModel(m);
			
			update();
		}
	  }
	
	public void selectWall(MBoxPanel mboxPanel) {
		// TODO Auto-generated method stub
		update(mboxPanel);
		
	}
	
	public void selectStart(MBoxPanel mboxPanel) {
		
		update(mboxPanel);
	}
	
	public void selectEnd(MBoxPanel mboxPanel) {
		
		update(mboxPanel);
	}
	
	
	@SuppressWarnings("deprecation")
	public void setChanged() {
		
		super.setChanged();
		setModified(true);
	}
	@SuppressWarnings("deprecation")
	public void update() {
		
		setChanged();
		System.out.println(hasChanged());
		notifyObservers();
	}
	
	@SuppressWarnings("deprecation")
	public void update(MBoxPanel mboxPanel) {
		
		setChanged();
		notifyObservers(mboxPanel);
	}

	public static Maze getMazeModel() {
		return m;
	}
	
	public static void setMazeModel(Maze m) {
		
		WindowModel.m = m;
	}



	public void saveToFile() {
		// TODO Auto-generated method stub
		
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


}

package model;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;

import Dijkstra.Dijkstra;
import Dijkstra.Previous;
import Dijkstra.VertexInterface;
import GUI.MBoxPanel;
import GUI.MazeApp;
import Maze.ABox;
import Maze.DBox;
import Maze.MBox;
import Maze.Maze;
import Maze.MazeReadingException;

public final class WindowModel extends Observable {
	
	private Maze m;
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
			ArrayList<VertexInterface> mboxList = m.getAllVertices2();
			DBox D = m.Start();
			/*System.out.println(D.getLabel());
			System.out.println(D.getX());
			System.out.println(D.getY());*/
			Previous pr = Dijkstra.dijkstra(m, D);
			System.out.println("Dijkstra is good");
			ABox A = m.findEnd();
			solutionPath = m.traceBack(A, D, pr);
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
			
			/*((MBoxPanel) mazeApp.getPanel().getDrawingPanel().getComponent(mboxList.indexOf(x))).setLabelMPanel(label);*/
			
			update();
				
			
				
				/*if(label == "A") {
				
				mazeApp.getPanel().getDrawingPanel().getComponent(mboxList.indexOf(x)).setBackground(Color.BLACK);

			}
			if(label == "D") {
				
				mazeApp.getPanel().getDrawingPanel().getComponent(mboxList.indexOf(x)).setBackground(Color.BLUE);
			}
			if(label == "W") {
				
				mazeApp.getPanel().getDrawingPanel().getComponent(mboxList.indexOf(x)).setBackground(Color.GREEN);
			}
			if(label == "E") {
				
				mazeApp.getPanel().getDrawingPanel().getComponent(mboxList.indexOf(x)).setBackground(Color.WHITE);
			}*/
			
		}
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

	public Maze getMazeModel() {
		return m;
	}
	
	public void setMazeModel(Maze m) {
		
		this.m = m;
	}





	public void saveToFile() {
		// TODO Auto-generated method stub
		
	}

	public Color getCurrentColor() {
		// TODO Auto-generated method stub
		return currentColor;
	}
	
	@SuppressWarnings("deprecation")
	public void setCurrentColor(Color currentColor, MBoxPanel mPanel) {
		
	    System.out.println("OKK");
		this.currentColor = currentColor;
		this.setChanged();
		this.modified = true;
		System.out.println("OKK2");
		this.notifyObservers(mPanel);
		System.out.println("OKK3");
	}
	
     @SuppressWarnings("deprecation")
	public void setCurrentColor(Color currentColor) {
		
	    System.out.println("OKK");
		this.currentColor = currentColor;
		this.setChanged();
		this.modified = true;
		this.notifyObservers();

	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}
	


}

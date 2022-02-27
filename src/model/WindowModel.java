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

@SuppressWarnings("deprecation")
public final class WindowModel extends Observable {
	
	private static Maze m;
	private Color currentColor = Color.PINK;
	private boolean modified;
	private MazeApp mazeApp;
	private ArrayList<VertexInterface> solutionPath;
	
	public WindowModel(){
		
		super();
		m = null;
	
	}
	
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
				m = new Maze(10,10);
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
			
			System.out.println("importMaze update()");
			update();
		}
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


}

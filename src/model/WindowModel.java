package model;

import java.awt.*;
import java.util.*;

import Maze.Maze;

public final class WindowModel extends Observable {
	
	private Maze maze;
	private Color currentColor;
	
	public WindowModel(){
		
		maze = null;
	
	}
	
	public void update() {
		setChanged();
	}
	
	
	
	
	
	public void addObserver(Observer observer) {
		
	}



	public Maze getMazeModel() {
		return maze;
	}
	
	public void setMazeModel(Maze maze) {
		
		this.maze = maze;
	}





	public void saveToFile() {
		// TODO Auto-generated method stub
		
	}





	public Color getCurrentColor() {
		// TODO Auto-generated method stub
		return currentColor;
	}
	
	@SuppressWarnings("deprecation")
	public void setCurrentColor(Color currentColor) {
		
		this.currentColor = currentColor;
		setChanged();
		notifyObservers();
	}
	


}

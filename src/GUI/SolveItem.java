package GUI;

import javax.swing.JMenuItem;

import Dijkstra.Dijkstra;
import Dijkstra.Previous;
import Dijkstra.VertexInterface;
import Maze.ABox;
import Maze.DBox;
import Maze.Maze;

import java.awt.Color;
import java.awt.event.*;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SolveItem extends JMenuItem implements ActionListener {
	
	private final MazeApp mazeApp;
	
	public SolveItem(MazeApp mazeApp) {
		
		super("                                                       Solve");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MBoxPanel.setSolved(true);
		mazeApp.getModel().solveMaze();
		MBoxPanel.setSolved(false);
		
	}

}

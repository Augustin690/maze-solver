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
		
		super("                                                    Solve");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("OK");
		Maze m = mazeApp.getModel().getMazeModel();
		ArrayList<VertexInterface> mboxList = m.getAllVertices2();
		DBox D = m.Start();
		System.out.println(D.getLabel());
		System.out.println(D.getX());
		System.out.println(D.getY());
		Previous pr = Dijkstra.dijkstra(m, D);
		System.out.println("Dijkstra is good");
		ABox A = m.findEnd();
		ArrayList<VertexInterface> list = m.traceBack(A, D, pr);
		for(VertexInterface x :list) {
			String label = x.getLabel();
			if(list != null) {
			    if(label.contentEquals("E") && list.contains(x)){
			    	mazeApp.getPanel().getDrawingPanel().getComponent(mboxList.indexOf(x)).setBackground(Color.RED);  	
			    }
		    }
		}
		
	}

}

 package GUI;

import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import Dijkstra.VertexInterface;
import Maze.*;
import Maze.MazeReadingException;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ImportItem extends JMenuItem implements ActionListener {

	private final MazeApp mazeApp;
	
	public ImportItem(MazeApp mazeApp) {
		
		super("Import");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("OK");
		JFileChooser fc = new JFileChooser("/JavaMazeProject/data");
		fc.showDialog(mazeApp, "IMPORT");
		if(fc.getSelectedFile()!= null) {
			String fileName = fc.getSelectedFile().getAbsolutePath();
			Maze m = new Maze(10,10);
			try {
				m.initFromTextFile(fileName);
			} catch (IOException | MazeReadingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ArrayList<VertexInterface> mboxList = m.getAllVertices2();
			for(VertexInterface x : mboxList) {
				
				String label = x.getLabel();
				((MBoxPanel) mazeApp.getPanel().getDrawingPanel().getComponent(mboxList.indexOf(x))).setLabel(label);
				if(label == "A") {
					
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
				}
				
			}
		
		mazeApp.getModel().update();
		mazeApp.getModel().setMazeModel(m);
	}

	}
}



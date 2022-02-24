 package GUI;

import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import Dijkstra.VertexInterface;
import Maze.*;
import Maze.MazeReadingException;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
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
		WallButton.setWallsSelection(false);
		System.out.println("OKi");
		JFileChooser fc = new JFileChooser("/JavaMazeProject/data");
		fc.showDialog(mazeApp, "IMPORT");
		File file = fc.getSelectedFile();
		if(file!=null) {
			
			MBoxPanel.setImported(true);
			System.out.println(MBoxPanel.isImported());
		}
		mazeApp.getModel().importMaze(file,mazeApp);
		System.out.println("imported");

	}
}



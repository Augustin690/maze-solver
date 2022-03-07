package GUI;

import javax.swing.*;

import Maze.MazeReadingException;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class SaveItem extends JMenuItem implements ActionListener {
	
  private final MazeApp mazeApp;
	
	public SaveItem(MazeApp mazeApp) {
		
		super("Save");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser(/*"C:\\Users\\Augustin\\eclipse-workspace\\JavaMazeProject\\data"*/);
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(mazeApp);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		    try {
				mazeApp.getModel().saveMaze(fileToSave);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MazeReadingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}

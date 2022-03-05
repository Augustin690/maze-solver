package GUI;

import javax.swing.*;

import Maze.MazeReadingException;
import model.WindowModel;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class QuitItem extends JMenuItem implements ActionListener {
	
	private final MazeApp mazeApp;
	
	public QuitItem(MazeApp mazeApp) {
		
		super("Quit");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	  public void actionPerformed(ActionEvent evt)
	   {
	      WindowModel model = mazeApp.getModel() ;
		   
	      if (model.isModified()) {
	         int response = JOptionPane.showInternalOptionDialog(this,
	                                                             "Drawing not saved. Save it ?",
	                                                             "Quit application",
	                                                             JOptionPane.YES_NO_CANCEL_OPTION,
	                                                             JOptionPane.WARNING_MESSAGE,
	                                                             null,null,null) ;
			   switch (response) {
			   case JOptionPane.CANCEL_OPTION:
				   return ;
			   case JOptionPane.OK_OPTION:
					JFileChooser fileChooser = new JFileChooser("C:\\Users\\Augustin\\eclipse-workspace\\JavaMazeProject\\data");
					fileChooser.setDialogTitle("Specify a file to save");   
					 
					int userSelection = fileChooser.showSaveDialog(mazeApp);
					 
					if (userSelection == JFileChooser.APPROVE_OPTION) {
					    File fileToSave = fileChooser.getSelectedFile();
					    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
					    try {
							model.saveMaze(fileToSave);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (MazeReadingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				  
				   break ;
			   case JOptionPane.NO_OPTION:
				   break ;
			   }
		   }
		   System.exit(0) ;
	   }
}

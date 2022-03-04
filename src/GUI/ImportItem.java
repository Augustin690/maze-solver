 package GUI;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import model.Ctrl;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ImportItem extends JMenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final MazeApp mazeApp;
	
	public ImportItem(MazeApp mazeApp) {
		
		super("Import");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ctrl.setWallsSelection(false);
		System.out.println("OKi");
		JFileChooser fc = new JFileChooser("/JavaMazeProject/data");
		fc.showDialog(mazeApp, "IMPORT");
		File file = fc.getSelectedFile();
		if(file!=null) {
			
			Ctrl.setImported(true);
			System.out.println(Ctrl.isImported());
		}
		try {
			mazeApp.getModel().importMaze(file,mazeApp);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("imported");

	}
}



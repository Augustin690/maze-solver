package GUI;

import javax.swing.*;

import model.WindowModel;

import java.awt.event.*;

public class QuitItem extends JMenuItem implements ActionListener {
	
	private final MazeApp mazeApp;
	
	public QuitItem(MazeApp mazeApp) {
		
		super("Quit");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@SuppressWarnings("deprecation")
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
				   model.saveToFile() ;
				   break ;
			   case JOptionPane.NO_OPTION:
				   break ;
			   }
		   }
		   System.exit(0) ;
	   }
}

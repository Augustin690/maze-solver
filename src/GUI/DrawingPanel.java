package GUI;

import javax.swing.*;

import Dijkstra.VertexInterface;
import Maze.MBox;
import Maze.Maze;
import model.WindowModel;

import java.awt.*;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
	
	private final MazeApp mazeApp;
	private MBoxPanel mboxPanel;
	private ArrayList<MBoxPanel> mboxPanelList = new ArrayList<MBoxPanel>();
	
	public DrawingPanel(MazeApp mazeApp) {
		
		super();
		
		this.mazeApp = mazeApp;
		
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(256,256));
		setLayout(new GridLayout(10,10,2,2));
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				add(mboxPanel = new MBoxPanel(mazeApp));
				mboxPanelList.add(mboxPanel);
			}
		}
	}
	
	
	public void notifyForUpdate(Object o) {
		
		/*mboxPanel.notifyForUpdate();*/
		
	}
	
	public void notifyForUpdate() {
		
		WindowModel model = mazeApp.getModel();
		Maze m = model.getMazeModel();
		ArrayList<VertexInterface> mboxList = m.getAllVertices2();
		
		if(MBoxPanel.isSolved()) {
			
			ArrayList<VertexInterface> sPath = model.getSolutionPath();
			for(VertexInterface x :sPath) {
				String label = x.getLabel();
				if(sPath != null) {
				    if(label.contentEquals("E") && sPath.contains(x)){
				    	MBoxPanel mboxPanel = (MBoxPanel) getComponent(mboxList.indexOf(x));
				    	mboxPanel.notifyForUpdate(); 
				    }
			    }
			
		}
		}
		if(MBoxPanel.isImported()) {
			
			for(VertexInterface x :mboxList) {
				
				String label = x.getLabel();
				MBoxPanel mboxPanel = (MBoxPanel) getComponent(mboxList.indexOf(x));
			    mboxPanel.setLabelMPanel(label);
			    mboxPanel.notifyForUpdate();
			    }
			}
		}
	
	public MBoxPanel getMBoxPanel() {
		
		return mboxPanel;
	}

}

package GUI;

import javax.swing.*;

import Dijkstra.VertexInterface;
import Maze.MBox;
import Maze.Maze;

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
		
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(256,256));
		setLayout(new GridLayout(10,10,2,2));
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				add(mboxPanel = new MBoxPanel(mazeApp));
				mboxPanelList.add(mboxPanel);
			}
		}
	}
	
	/*public void paint (Graphics g) {
		
		super.paint(g);
		
		int w = getWidth();
		int h = getHeight();
		System.out.println("yes1");
		/*boolean v = true;*/
		
		/*while(mazeApp.getModel().isModified()) {
			System.out.println("yes");
			g.setColor(mazeApp.getModel().getCurrentColor());
			g.fillRect(4,4,w-8,h-8);
			
			g.setColor(Color.BLACK);
			g.drawRect(4,4,w-8,h-8);
	}*/
	
	public void notifyForUpdate(Object o) {
		
		/*mboxPanel.notifyForUpdate();*/
		
	}
	
	public void notifyForUpdate() {
		
		Maze m = mazeApp.getModel().getMazeModel();
		/*mPanel.repaint(mPanel.getX(),mPanel.getY(),mPanel.getWidth(),mPanel.getHeight());*/
		/*repaint(mPanel.getX(),mPanel.getY(),mPanel.getWidth(),mPanel.getHeight());*/
		ArrayList<VertexInterface> mboxList = m.getAllVertices2();
		for(VertexInterface x :mboxList) {
			
			String label = x.getLabel();
			MBoxPanel mboxPanel = (MBoxPanel) getComponent(mboxList.indexOf(x));
			mboxPanel.setLabelMPanel(label);
			mboxPanel.notifyForUpdate();
		}
		
	}
	
	
	public MBoxPanel getMBoxPanel() {
		
		return mboxPanel;
	}

}

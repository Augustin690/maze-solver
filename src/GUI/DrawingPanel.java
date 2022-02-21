package GUI;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
	
	private final MazeApp mazeApp;
	private MBoxPanel mboxPanel;
	
	public DrawingPanel(MazeApp mazeApp) {
		
		super();
		
		this.mazeApp = mazeApp;
		
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(256,256));
		setLayout(new GridLayout(10,10,2,2));
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				add(mboxPanel = new MBoxPanel(mazeApp));
			}
		}
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		/*window.getModel().paintSegments(g);*/
	}
	
	public void notifyForUpdate() {
		
		mboxPanel.notifyForUpdate();
	}
	
	public MBoxPanel getMBoxPanel() {
		
		return mboxPanel;
	}

}

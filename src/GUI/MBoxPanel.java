package GUI;

import javax.swing.JPanel;

import Maze.MBox;
import model.WindowModel;

import java.awt.* ;
import java.awt.event.*;

public class MBoxPanel extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final MazeApp mazeApp;
	private String labelMPanel = "E";
	private MBox mbox;
	private static boolean imported = false;
	private static boolean solved = false;
	
	public MBoxPanel(MazeApp mazeApp) {
		
		super();
		setBackground(Color.RED);
		
		this.mazeApp = mazeApp;
		addMouseListener(this);
	}
	
	
	public void paint(Graphics g) {
			
			super.paint(g);
			
			int w = getWidth();
			int h = getHeight();
			System.out.println("yes1");
			
			
			g.setColor(mazeApp.getModel().getCurrentColor());
			g.fillRect(8,8,w-15,h-15);
				
			g.setColor(Color.BLACK);
			g.drawRect(8,8,w-15,h-15);
		
	}
	
	public void MouseEntered(MouseEvent e) {
		
		setBackground(Color.GREEN);
	}
	
	public void refresh() {
		WindowModel model = mazeApp.getModel();
		
		if(solved) {
			
			setBackground(Color.cyan);
			
		}
		
		if(WallButton.isWallsSelection()) {
			
			setLabelMPanel("W");
			/*mbox.setLabel("W");*/
			System.out.println("helloooooo");
		}
		
		if(StartButton.isStartSelection()) {
			
			setLabelMPanel("D");
			System.out.println("hellooooooDD");
		}
		
		if(EndButton.isEndSelection()) {
			
			setLabelMPanel("A");
			System.out.println("hellooooooAAA");
		}
		
		if(imported || WallButton.isWallsSelection() || StartButton.isStartSelection() || EndButton.isEndSelection() ) {
			
			if(!solved) {
			
                 if(labelMPanel == "A") {
				
		         setBackground(Color.YELLOW);
		         }
                 
                 if(labelMPanel == "D") {
				
				setBackground(Color.BLUE);
				}
                 
                 if(labelMPanel == "W") {
				
				setBackground(Color.GREEN);
				}
                 System.out.println("hello");
                 
                 if(labelMPanel == "E") {
				
				setBackground(Color.darkGray);
				}
			}
           }
		
	}
	
	
	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		refresh();
	}

	public String getLabelMPanel() {
		return labelMPanel;
	}

	public void setLabelMPanel(String labelMPanel) {
		this.labelMPanel = labelMPanel;
	}
	
	public static boolean isImported() {
		
		return imported;
	}
	
	public static void setImported(boolean imported) {
		
		MBoxPanel.imported = imported;
	}

	public static boolean isSolved() {
		return solved;
	}

	public static void setSolved(boolean solved) {
		MBoxPanel.solved = solved;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		MBoxPanel mboxPanel = (MBoxPanel) e.getSource();
		if(WallButton.isWallsSelection()) {
			
			mazeApp.getModel().selectWall(mboxPanel);
			System.out.println("selecting wall");
			
		}
		if(StartButton.isStartSelection()) {
			
			mazeApp.getModel().selectStart(mboxPanel);
			StartButton.setStartSelection(false);
		}
		
		if(EndButton.isEndSelection()) {
			
			mazeApp.getModel().selectEnd(mboxPanel);
			EndButton.setEndSelection(false);
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

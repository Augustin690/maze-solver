package GUI;

import javax.swing.JPanel;

import Maze.MBox;
import model.Ctrl;
import model.*;

import java.awt.* ;
import java.awt.event.*;

public class MBoxPanel extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;
	private String labelMPanel = "E";
	private Color solveColor = null;

	
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
		
	}
	
	public void refresh() {
		WindowModel model = mazeApp.getModel();
		
		if(Ctrl.isSolved()) {
			
			setSolveColor(Color.CYAN);
			setBackground(solveColor);
			
		}
		
		else if(Ctrl.isWallsSelection() && !Ctrl.isResetActive() && !Ctrl.isStartSelection() && !Ctrl.isEndSelection() && !Ctrl.isRemoveStrt()) {
			
			setLabelMPanel("W");
			/*mbox.setLabel("W");*/
			System.out.println("helloooooo78");
		}
		
		else if(Ctrl.isStartSelection()) {
			
			setLabelMPanel("D");
			System.out.println("hellooooooDD");
		}
		
		else if(Ctrl.isEndSelection()) {
			
			setLabelMPanel("A");
			System.out.println("hellooooooAAA");
		}
		
		else if (Ctrl.isRemoveStrt()) {
			
			setLabelMPanel("E");
		}
		
		
		if(Ctrl.isImported() || Ctrl.isWallsSelection() || Ctrl.isStartSelection() || Ctrl.isEndSelection() || Ctrl.isResetActive() || Ctrl.isRemoveStrt() || Ctrl.isResetPath()) {
			
			if(!Ctrl.isSolved() || Ctrl.isResetPath()) {
			
                 if(labelMPanel == "A") {
				
		         setBackground(Color.YELLOW);
		         }
                 
                 if(labelMPanel == "D") {
				
				setBackground(Color.BLUE);
				}
                 
                 if(labelMPanel == "W") {
				
				setBackground(Color.GREEN);
				System.out.println("hello7");
				}
                 
                 
                 if(labelMPanel == "E") {
                	 
                	 System.out.println("resetting");
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


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		MBoxPanel mboxPanel = (MBoxPanel) e.getSource();
		String labelMPanel = mboxPanel.getLabelMPanel();
		
		if(Ctrl.isWallsSelection()) {
			
			System.out.println("selecting wall");
			mazeApp.getModel().selectWall(mboxPanel);		
		}
		if(Ctrl.isStartSelection()) {
			
			System.out.println("selecting start");
			mazeApp.getModel().selectStart(mboxPanel);
			Ctrl.setStartSelection(false);
		}
		
		if(Ctrl.isEndSelection()) {
			
			System.out.println("selecting end");
			mazeApp.getModel().selectEnd(mboxPanel);
			Ctrl.setEndSelection(false);
		}
		if(labelMPanel != "E") {
			
			System.out.println("creating empty box");
			Ctrl.setRemoveStrt(true);
			Ctrl.setModified(true);
			mazeApp.getModel().update(mboxPanel);
			Ctrl.setRemoveStrt(false);
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


	public Color getSolveColor() {
		return solveColor;
	}


	public void setSolveColor(Color solveColor) {
		this.solveColor = solveColor;
	}

}

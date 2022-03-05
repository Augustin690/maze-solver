package GUI;

import javax.swing.*;

import Dijkstra.VertexInterface;
import Maze.ABox;
import Maze.DBox;
import Maze.EBox;
import Maze.MBox;
import Maze.Maze;
import Maze.WBox;
import model.Ctrl;
import model.WindowModel;

import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final MazeApp mazeApp;
	private MBoxPanel mboxPanel;
	private ArrayList<MBoxPanel> mboxPanelList = new ArrayList<MBoxPanel>();
	private Maze mDrawn;
	private static DBox D;
	
	
	public DrawingPanel(MazeApp mazeApp) {
		
		super();
		
		this.mazeApp = mazeApp;
		WindowModel model = mazeApp.getModel();
		
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(256,256));
		setLayout(new GridLayout(model.getDepth(),model.getWidth(),2,2));
		for(int i=0;i<model.getDepth();i++) {
			for(int j=0;j<model.getWidth();j++) {
				add(mboxPanel = new MBoxPanel(mazeApp));
				mboxPanelList.add(mboxPanel);
			}
		}
	}
	
	
	public void notifyForUpdate(MBoxPanel mboxPanel) {
		WindowModel model = this.mazeApp.getModel();
		
		if(!Ctrl.isEndSelection() && !Ctrl.isStartSelection() && !Ctrl.isWallsSelection() &&!Ctrl.isModified()) {
			
			for(Component comp : getComponents()) {		
				
				MBoxPanel mboxPanell = (MBoxPanel) comp;
				remove(mboxPanell);
				mboxPanelList.remove(mboxPanel);

			}
			
			setLayout(new GridLayout(model.getDepth(),model.getWidth(),2,2));
			
			for(int i=0;i<model.getDepth();i++) {
				for(int j=0;j<model.getWidth();j++) {
					add(mboxPanel = new MBoxPanel(mazeApp));
					mboxPanelList.add(mboxPanel);
				}
			}
			
			updateUI();
		}

		
	     if(Ctrl.isResetActive()) {
			
			for(Component comp : getComponents()) {		
				
				MBoxPanel mboxPanel2 = (MBoxPanel) comp;
				mboxPanel2.setLabelMPanel("E");
				mboxPanel2.notifyForUpdate();
				System.out.println("coucouuOLL");
			}
		}
		

		else{
			
			int width = model.getWidth();
			int k = mboxPanelList.indexOf(mboxPanel);
			int i = k/width;
			int j = k- width*i;
			
			if(Ctrl.isEndSelection()) {
				
				Maze.getMaze()[j][i] = new ABox(j,i);
			}
			
			if(Ctrl.isStartSelection()) {
				
				Maze.getMaze()[j][i] = new DBox(j,i);
				
			}
			
			if(Ctrl.isWallsSelection()) {
				
				Maze.getMaze()[j][i] = new WBox(j,i);
			}
			
			mboxPanel.notifyForUpdate();
			System.out.println("e??");
		}			
		
	}
	
	public void notifyForUpdate() {
		
		WindowModel model = mazeApp.getModel();
		Maze m = WindowModel.getMazeModel();
		System.out.println("notifyforupdate()drawing");
		
		if(Ctrl.isResetPath()) {
			
			for(Component comp : getComponents()) {		
				
				System.out.println("reset path before displaying solution");
				MBoxPanel mboxPanel1 = (MBoxPanel) comp;
				if(mboxPanel1.getSolveColor()!= null /*&& mboxPanel1.getLabelMPanel()!= "W"*/) {
					
					mboxPanel1.notifyForUpdate();
				}
		
			}
		}

		
		else if(Ctrl.isSolved()) {
			
			if(Ctrl.isModified() || Ctrl.isStartSelection() || Ctrl.isEndSelection()) {
				
				MBox[][] mazeDrawn = Maze.getMaze();
				
				int k =-1;
				int width = mazeApp.getModel().getWidth();
						
				for(Component comp : getComponents()) {
					
					MBoxPanel mboxPanel = (MBoxPanel) comp;
					String labelMPanel = mboxPanel.getLabelMPanel();
					int i =0;
					int j =0;
					k++;
					i = i + k/width ; // y depth
					j = k - width*i ; //x width
					/*System.out.println("i"+ i +"j"+j);*/
					
					if (labelMPanel == "W" ) {
						System.out.println("i"+ i +"j"+j);
						WBox wbox = new WBox(j,i);
						mazeDrawn[j][i] = wbox ;
					}	
	        	         
	        		else if (labelMPanel == "E") {
	        			System.out.println("i"+ i +"j"+j);
	        			EBox ebox = new EBox(j,i);
	        			mazeDrawn[j][i] = ebox ; 
	        			
	        			} 
	        		else if (labelMPanel == "D") {
	        			System.out.println("i"+ i +"j"+j);
	        			DBox dbox = new DBox(j,i);
	        			mazeDrawn[j][i] = dbox ;
	        			D = (DBox) mazeDrawn[j][i];
	        			
	        			} 
	        		else if (labelMPanel == "A") {
	        			System.out.println("i"+ i +"j"+j);
	        			ABox abox = new ABox(j,i);
	        			mazeDrawn[j][i] = abox ;
	        		}
	        			
	        	
					System.out.println(mazeDrawn[j][i].getLabel());
					
					
					/*System.out.print("i:"+ i);
					System.out.print("j:"+ j);*/
					System.out.print("k:"+ k);
					

				Ctrl.setWallsSelection(false);
				Ctrl.setStartSelection(false);
				Ctrl.setEndSelection(false);
				
				}
			}
			else {
				ArrayList<VertexInterface> mboxList = m.getAllVertices2();
				ArrayList<VertexInterface> sPath = model.getSolutionPath();
				for(VertexInterface x :sPath) {
					String label = x.getLabel();
					if(sPath != null) {
					    if(label.contentEquals("E") && sPath.contains(x)){
					    	MBoxPanel mboxPanel = (MBoxPanel) getComponent(mboxList.indexOf(x));
					    	System.out.print(mboxPanel.getLabelMPanel());
					    	mboxPanel.notifyForUpdate(); 
					    	System.out.println("coucou");
					    	
					    }
				    }
				}
			}
		}
		
		else if(Ctrl.isImported()) {
			
			ArrayList<VertexInterface> mboxList = m.getAllVertices2();
			System.out.println("importing");
			/*System.exit(0);*/
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
	
	public Maze getMDrawn() {
		
		return mDrawn;
	}


	public static DBox getD() {
		return D;
	}

}

package GUI;

import javax.swing.*;

import Dijkstra.VertexInterface;
import Maze.ABox;
import Maze.DBox;
import Maze.EBox;
import Maze.MBox;
import Maze.Maze;
import Maze.WBox;
import model.WindowModel;

import java.awt.*;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

public class DrawingPanel extends JPanel {
	
	private final MazeApp mazeApp;
	private MBoxPanel mboxPanel;
	private ArrayList<MBoxPanel> mboxPanelList = new ArrayList<MBoxPanel>();
	private Maze mDrawn;
	private static DBox D;
	
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
	
	
	public void notifyForUpdate(MBoxPanel mboxPanel) {
		
			mboxPanel.notifyForUpdate();
		
	}
	
	public void notifyForUpdate() {
		
		WindowModel model = mazeApp.getModel();
		Maze m = model.getMazeModel();
		

		
		if(MBoxPanel.isSolved()) {
			
			if(WallButton.isWallsSelection() || StartButton.isStartSelection() || EndButton.isEndSelection()) {
				
				MBox[][] mazeDrawn = Maze.getMaze();
				
				int k =-1;
						
				for(Component comp : getComponents()) {
					
					MBoxPanel mboxPanel = (MBoxPanel) comp;
					String labelMPanel = mboxPanel.getLabelMPanel();
					int i =0;
					int j =0;
					k++;
					i = i + k/10 ;
					j = k - 10*i ;
					System.out.println("j"+ i +"i"+j);
					
					if (labelMPanel == "W" ) {
						System.out.println("j"+ i +"i"+j);
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
	        			//mboxStock.get(j).add(i, new DBox(i,j));
	        			D = (DBox) mazeDrawn[j][i];
	        			
	        			} 
	        		else if (labelMPanel == "A") {
	        			System.out.println("i"+ i +"j"+j);
	        			ABox abox = new ABox(j,i);
	        			mazeDrawn[j][i] = abox ;
	        		}
	        			
	        	
					System.out.println(mazeDrawn[j][i].getLabel());
					
					
					System.out.print("j:"+ i);
					System.out.print("i:"+ j);
					System.out.print("k:"+ k);
					

				WallButton.setWallsSelection(false);
				StartButton.setStartSelection(false);
				EndButton.setEndSelection(false);
				
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
					    	mboxPanel.notifyForUpdate(); 
					    	System.out.println("coucou");
					    	
					    }
				    }
				}
			}
		}
		
		if(MBoxPanel.isImported()) {
			
			ArrayList<VertexInterface> mboxList = m.getAllVertices2();
			
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

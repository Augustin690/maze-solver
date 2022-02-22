package GUI;

import javax.swing.JLabel ;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import Dijkstra.VertexInterface;
import Maze.MBox;
import Maze.Maze;
import model.WindowModel;

import java.awt.* ;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

public class MBoxPanel extends JPanel  {
	
	private final MazeApp mazeApp;
	private String labelMPanel = "E";
	private MBox mbox;
	private static boolean imported = false;
	private static boolean solved = false;
	
	/*private JLabel image = new JLabel(new ImageIcon("data/BrickWall.jpg"));
	ImageIcon imageIcon = new ImageIcon("data/BrickWall.jpg");
	int width = imageIcon.getIconWidth() / 2;
	int height = imageIcon.getIconHeight() / 2;
	Image scaled = scaleImage(imageIcon.getImage(), width, height);
	
	private Image scaleImage(Image image, int w, int h) {

	    Image scaled = image.getScaledInstance(w+4, h+12, Image.SCALE_REPLICATE);

	    return scaled;
	}
	
	ImageIcon scaledIcon = new ImageIcon(scaled);

	JLabel newLabel = new JLabel(scaledIcon);*/
	
	public MBoxPanel(MazeApp mazeApp) {
		
		super();
		setBackground(Color.RED);
		
		this.mazeApp = mazeApp;
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void paint(Graphics g) {
			
			super.paint(g);
			
			int w = getWidth();
			int h = getHeight();
			System.out.println("yes1");
			boolean v = true;
			
			
				System.out.println("yes");
				g.setColor(mazeApp.getModel().getCurrentColor());
				g.fillRect(8,8,w-15,h-15);
				
				g.setColor(Color.BLACK);
				g.drawRect(8,8,w-15,h-15);
				/*v = false;*/
				/*if(!v) {
					break;
				}*/
		
	}
	
	public void MouseEntered(MouseEvent e) {
		
		setBackground(Color.GREEN);
	}
	
	public void refresh() {
		WindowModel model = mazeApp.getModel();
		
		if(solved) {
			
			setBackground(Color.cyan);
			
		}
		
		if(imported) {
			
                 if(labelMPanel == "A") {
				
		         setBackground(Color.YELLOW);
		         }
                 
                 if(labelMPanel == "D") {
				
				setBackground(Color.BLUE);
				}
                 
                 if(labelMPanel == "W") {
				
				setBackground(Color.GREEN);
				}
                 
                 if(labelMPanel == "E") {
				
				setBackground(Color.darkGray);
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
	
}

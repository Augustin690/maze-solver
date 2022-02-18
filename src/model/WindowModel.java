package model;

import java.awt.*;
import java.util.*;

public final class WindowModel extends Observable {
	
	private final ArrayList<Segment> editedSegments;
	private Color currentColor;
	private Segment currentSegment;
	private Segment selectedSegment;
	private Boolean modified;
	
	public WindowModel(){
		
		editedSegments = new ArrayList<Segment>();
		currentColor = Color.BLACK;
		currentSegment = null;
		selectedSegment = null;
		modified = false;
	}
	
	public final void paintSegments(Graphics g) {
		
		for (Segment s : editedSegments) {
			s.paintNormal(g);
		}
		
		if (selectedSegment != null) {
			selectedSegment.paintLarger(g);
		}
		
		if (currentSegment != null) {
			currentSegment.paintDashed(g);
		}
	}
	
	public final void removeEditedSegment(Segment editedSegment) {
		
		editedSegments.remove(editedSegment);
		modified = true;
		
		setChanged();
		notifyObservers();
	}
	
	public void addObserver(Observer observer) {
		
	}
	
	
	
	
	
	
	
	











	public Color getCurrentColor() {
		return currentColor;
	}










	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}










	public Segment getCurrentSegment() {
		return currentSegment;
	}










	public void setCurrentSegment(Segment currentSegment) {
		this.currentSegment = currentSegment;
	}










	public Segment getSelectedSegment() {
		return selectedSegment;
	}










	public void setSelectedSegment(Segment selectedSegment) {
		this.selectedSegment = selectedSegment;
	}










	public Boolean getModified() {
		return modified;
	}










	public void setModified(Boolean modified) {
		this.modified = modified;
	}

	public ArrayList<Segment> getEditedSegments() {
		return editedSegments;
	}

}

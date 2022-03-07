package model;

/**
 * Class that contains all the booleans needed to implement the GUI respecting the MVC 
 * @author Augustin
 *
 */
public class Ctrl {
	
	private static boolean imported = false;
	private static boolean solved = false;
	private static boolean modified = false;
	private static boolean startSelection = false;
	private static boolean endSelection = false;
	private static boolean wallsSelection = false;
	private static boolean resetActive = false;
	private static boolean removeStrt = false;
	private static boolean resetPath = false;
	
	
	
	public static boolean isImported() {
		return imported;
	}
	public static void setImported(boolean imported) {
		Ctrl.imported = imported;
	}
	public static boolean isSolved() {
		return solved;
	}
	public static void setSolved(boolean solved) {
		Ctrl.solved = solved;
	}
	public static boolean isModified() {
		return modified;
	}
	public static void setModified(boolean modified) {
		Ctrl.modified = modified;
	}
	public static boolean isStartSelection() {
		return startSelection;
	}
	public static void setStartSelection(boolean startSelection) {
		Ctrl.startSelection = startSelection;
	}
	public static boolean isEndSelection() {
		return endSelection;
	}
	public static void setEndSelection(boolean endSelection) {
		Ctrl.endSelection = endSelection;
	}
	public static boolean isWallsSelection() {
		return wallsSelection;
	}
	public static void setWallsSelection(boolean wallsSelection) {
		Ctrl.wallsSelection = wallsSelection;
	}
	public static boolean isResetActive() {
		return resetActive;
	}
	public static void setResetActive(boolean resetActive) {
		Ctrl.resetActive = resetActive;
	}
	public static boolean isRemoveStrt() {
		return removeStrt;
	}
	public static void setRemoveStrt(boolean removeStrt) {
		Ctrl.removeStrt = removeStrt;
	}
	public static boolean isResetPath() {
		return resetPath;
	}
	public static void setResetPath(boolean resetPath) {
		Ctrl.resetPath = resetPath;
	}

}

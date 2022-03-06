package Maze;

public class MazeReadingException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private int line;
	private String fileName;

	public MazeReadingException(String fileName, int line,String message) {
		
		super(message);
		this.fileName = fileName;
		this.message = message;
		this.line = line;
	}

}

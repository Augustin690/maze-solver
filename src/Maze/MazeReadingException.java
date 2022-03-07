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
		this.setFileName(fileName);
		this.setMessage(message);
		this.setLine(line);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}

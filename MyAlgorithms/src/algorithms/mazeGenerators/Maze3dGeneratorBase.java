package algorithms.mazeGenerators;

/**
* @author  Chen Hamdani and Yulia Kolk
* @version 1.0
* @since   15/09/2016 
* 
* <h1>Maze3dGeneratorBase</h1>
*/
public abstract class Maze3dGeneratorBase implements Maze3dGenerator{
	
	protected boolean isDone = false;
	
	public boolean isDone() {
		return isDone;
	}
	
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	/**
	 *  the Method measureAlgorithmTime return the time that take to create the  Searcher problem
	 */
	@Override
	public String measureAlgorithmTime(int cols, int rows, int floors) {
		long startTime = System.currentTimeMillis();
		generate(cols, rows, floors);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		return String.valueOf(duration);
	}
}

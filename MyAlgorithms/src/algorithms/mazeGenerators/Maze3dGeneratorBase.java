package algorithms.mazeGenerators;

public abstract class Maze3dGeneratorBase implements Maze3dGenerator{
	
	protected boolean isDone = false;
	
	public boolean isDone() {
		return isDone;
	}
	
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	@Override
	public String measureAlgorithmTime(int cols, int rows, int floors) {
		long startTime = System.currentTimeMillis();
		generate(cols, rows, floors);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		return String.valueOf(duration);
	}
}

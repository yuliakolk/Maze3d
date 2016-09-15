package algorithms.mazeGenerators;

public abstract class Maze3dGeneratorBase implements Maze3dGenerator{
	
	@Override
	public String measureAlgorithmTime(int cols, int rows, int floors) {
		long startTime = System.currentTimeMillis();
		generate(cols, rows, floors);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		return String.valueOf(duration);
	}
}

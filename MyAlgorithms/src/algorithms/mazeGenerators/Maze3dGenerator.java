package algorithms.mazeGenerators;

public interface Maze3dGenerator {

	Maze3d generate(int cols, int rows,int floors);

	String measureAlgorithmTime(int cols, int rows,int floors);

}
package algorithms.mazeGenerators;

/**
* @author  Yulia Kolk
* @version 1.0
* @since   30/08/2016
* 
* <h1>Maze3dGenerator</h1>
* This  interface define all the algorithms that can create a search problem
* This class Maze3d will implements this Interface.
* the Method measureAlgorithmTime return the time that take to create the  Searcher problem
*/

public interface Maze3dGenerator {
	Maze3d generate(int cols, int rows,int floors);
	String measureAlgorithmTime(int cols, int rows,int floors);
}

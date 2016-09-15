package model;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;

public interface Model {
	void generateMaze (String name, int cols, int rows, int floors);
	Maze3d displayMaze(String name);
	Solution solve(String name, String algo);
	void exit();
}

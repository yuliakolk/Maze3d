package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import controller.Command;
import controller.Controller;

public interface View {
	void notifyMazeIsReady(String name);
	void displayMaze(Maze3d maze);
	void setCommands(HashMap<String, Command> commands);
	void dir(String path);
	void displaySolution(Solution sol);
	void start();
	void setController(Controller controller);
	void printCrossSectionBy(String t, String name);
	void displayMessage(String msg);
}

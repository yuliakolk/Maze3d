package controller;

import java.util.HashMap;

import Model.Model;
import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import view.MyView;
import view.View;

public class CommandsManager {
	
	private Model model;
	private View view;
		
	public CommandsManager(Model model, View view) {
		this.model = model;
		this.view = view;		
	}
	
	public HashMap <String, Command> getCommandsMap() {
		HashMap<String, Command> commands = new HashMap<String, Command>();
		commands.put("dir", new Dir());
		commands.put("generate_3d_maze", new GenerateMazeCommand());
		commands.put("display", new DisplayMazeCommand());
		commands.put("display_cross_section", new DisplayCrossSectionCommand());
		commands.put("save_maze", new saveMazeCommand());
		commands.put("load_maze", new loadMazeCommand());
		commands.put("solve", new solveCommand());
		commands.put("display_solution", new displaySolutionCommand());
		commands.put("exit", new displaySolutionCommand());
		
		
		return commands;
	}
	
	public class Dir implements Command {
		
		@Override
		public void doCommand(String[] args) {
			//?????
//			((MyView) view).printMassege("plz enter the path");		
//			String path=((MyView) view).OnStringRecieved();
//			((MyView) view).dir(path);
			String path= args[0];
			view.dir(path);
		}		
	}
	
	public class GenerateMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			int cols = Integer.parseInt(args[1]);
			int rows = Integer.parseInt(args[2]);
			int floors = Integer.parseInt(args[3]);
			model.generateMaze(name, cols, rows, floors);
		}		
	}
	
	public class DisplayMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			Maze3d maze = model.displayMaze(name);
			view.displayMaze(maze);
		}
		
	}
	
	/**
	 * this command will print crossed 2d maze of the original 3d maze by the input parameter x for floor y for line and z for column 
	 */
	public class DisplayCrossSectionCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			System.out.println("enter by who you want to cross : X,Y,Z");
			String t=((MyView) view).OnStringRecieved();;
			/**
			* @param x|y|z level
			 * print crossed 2d maze of the original 3d maze,by the floor|line|column
			 */
			view.printCrossSectionBy(t, name);
		}
		
	}
	
	public class saveMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
// to do
		}
		
	}
	public class loadMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
// to do
		}
		
	}
	
	
	public class solveCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			System.out.println("please enter the name of the algorithem you want to use to solve the maze");
			String algo=((MyView) view).OnStringRecieved();
			Solution sol = model.solve(name,algo);
			
		}
		
	}
	
	public class displaySolutionCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			System.out.println("please enter the name of the algorithem you want to use to solve the maze");
			String algo=((MyView) view).OnStringRecieved();
			Solution sol = model.solve(name,algo);
			view.displaySolution(sol);
		}
		
	}
}

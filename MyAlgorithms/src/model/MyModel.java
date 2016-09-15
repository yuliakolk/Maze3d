package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import algorithms.search.Searcher;
import algorithms.demo.SearchableMaze3d;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Bfs;
import algorithms.search.CommonSearcher;
import algorithms.search.Dfs;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import controller.Controller;
import controller.MyController;

public class MyModel implements Model {
	
	private Controller controller;
	private Map<String, Maze3d> mazes = new ConcurrentHashMap<String,Maze3d>();
	private List<Thread> threads = new ArrayList<Thread>();
	
	public MyModel(Controller controller){
		this.controller = controller;
	}
	
	@Override
	public void generateMaze(String name, int cols, int rows, int floors) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run(){
				GrowingTreeGenerator generator = new GrowingTreeGenerator();
				Maze3d maze = generator.generate(cols, rows, floors);
				mazes.put(name, maze);
				
				controller.notifyMazeIsReady(name);
			}
		});
		thread.start();
	}

	@Override
	public Maze3d displayMaze(String name) {
		return mazes.get(name);
	}
	
	public Solution solve(String name, String algo){
		
		Solution sol=new Solution();
		
		if ((algo.equals("BFS"))||(algo.equals("bfs"))||(algo.equals("Bfs")))
		{
			//creating a searcher with BFS searcher
			Searcher tester=new Bfs();
			//saving the solution with the BFS algorithm on local var "sol"
			sol=tester.search(new SearchableMaze3d(controller.notifyMazeIsReady(name)));
		}
		else
			if (algo.equals("dfs")||algo.equals("DFS")||algo.equals("Dfs")) 
				{
				//creating a searcher with DFS searcher
				Searcher tester=new Dfs();
				//saving the solution with the DFS algorithm on local var "sol"
				sol=tester.search(new SearchableMaze3d(controller.notifyMazeIsReady(name)));
				}
     return sol;
	}

	

}

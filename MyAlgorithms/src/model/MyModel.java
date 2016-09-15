package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import algorithms.search.Solution;
import controller.Controller;
import controller.MyController;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel implements Model {
	
private List<GenerateMazeRunnable> generateMazeTasks = new ArrayList<GenerateMazeRunnable>();
	
	class GenerateMazeRunnable implements Runnable {

		private int floors, rows, cols;
		private String name;
		private GrowingTreeGenerator generator;
		public GenerateMazeRunnable(int cols, int rows, int floors, String name) {
			this.cols = cols;
			this.rows = rows;
			this.floors = floors;
			this.name = name;
		}
		
		@Override
		public void run() {
			generator = new GrowingTreeGenerator();
			Maze3d maze = generator.generate(cols, rows, floors);
			mazes.put(name, maze);
			
			controller.notifyMazeIsReady(name);			
		}
		
		public void terminate() {
			generator.setDone(true);
		}		
	}

	
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

	
	public void saveMaze(String name, String fileName) throws IOException{
		OutputStream out=new MyCompressorOutputStream(new FileOutputStream(fileName));
		Maze3d maze= mazes.get(name);
		out.write(maze.toByteArray());
		out.flush();
		out.close();
}
	
	
	public void loadMaze(String name, String fileName) throws IOException{
		InputStream in=new MyDecompressorInputStream(new FileInputStream(fileName));
		byte b[]=new byte[1000];
		in.read(b);
		in.close();
		Maze3d loaded=new Maze3d(b);
		mazes.put(name, loaded);
}
	
	public void exit() {
		for (GenerateMazeRunnable task : generateMazeTasks) {
			task.terminate();
		}
	}

	

}

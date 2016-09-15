//package algorithms.demo;
//
//import algorithms.mazeGenerators.Maze3d;
//import algorithms.mazeGenerators.Position;
//import algorithms.mazeGenerators.SimpleMaze3dGenerator;
//import algorithms.search.BFS;
//import algorithms.search.DFS;
//
//public class Demo {
//	
//	public void run(){
//		
//		/**
//		* @author  Yulia Kolk
//		* @version 1.0
//		* @since   30/08/2016 
//		*/
//		
//		Maze3d maze;
//		SimpleMaze3dGenerator mymaze=new SimpleMaze3dGenerator();
//		maze=mymaze.generate(10,20,30);
//
//		System.out.println(maze);
//		
//		SearchableMaze3d mys= new SearchableMaze3d(maze);
//				
//	    System.out.println("BFS: ");
//	    BFS<Position> bfs = new BFS<Position>();
//	    bfs.search(mys);
//	    
//	    System.out.println("the number of node that the algorithns evaluated: " + bfs.getNumberOfNodesEvaluated());
//	    
//	    System.out.println("DFS: ");
//	    DFS<Position> dfs = new DFS<Position>();
//	    dfs.search(mys);
//	    
//	    System.out.println("the number of node that the algorithns evaluated: " + dfs.getNumberOfNodesEvaluated());
//
//	}
//}

package algorithms.demo;




import algorithms.mazeGenerators.Maze3d;

import algorithms.mazeGenerators.Position;

import algorithms.mazeGenerators.SimpleMaze3dGenerator;

import algorithms.search.Bfs;

import algorithms.search.Dfs;




public class Demo {

	

	public void run(){

		

		/**

		* @author  Yulia Kolk

		* @version 1.0

		* @since   30/08/2016 

		*/

		

		Maze3d maze;

		SimpleMaze3dGenerator mymaze=new SimpleMaze3dGenerator();

		maze=mymaze.generate(10,20,30);

		

		System.out.println(maze);
		//test
		

		SearchableMaze3d mys= new SearchableMaze3d(maze);

				

	    System.out.println("BFS: ");

	    Bfs<Position> bfs = new Bfs<Position>();

	    bfs.search(mys);

	    

	    System.out.println("the number of node that the algorithns evaluated: " + bfs.getNumberOfNodesEvaluated());

	    

	    System.out.println("DFS: ");

	    Dfs<Position> dfs = new Dfs<Position>();

	    dfs.search(mys);

	    

	    System.out.println("the number of node that the algorithns evaluated: " + dfs.getNumberOfNodesEvaluated());




	}

}
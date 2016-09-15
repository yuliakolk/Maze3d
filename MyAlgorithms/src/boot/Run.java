
package boot;

import algorithms.demo.Demo;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;

public class Run {

//	public static void main(String[] args) {
		//Maze2d maze = new Maze2d(10, 10);
		//maze.setStartPosition(new Position(2, 2));
		//maze.setGoalPosition(new Position(5, 5));
		
		/*SimpleMaze2dGenerator generator = new SimpleMaze2dGenerator();
		Maze2d maze = generator.generate(10, 10);
		System.out.println(maze);*/
		
//		GrowingTreeGenerator gen = new GrowingTreeGenerator();
//		Maze3d maze = gen.generate(10, 10,10);
//		System.out.println(maze);
//		


		public static void main(String[] args){

			Demo main=new Demo();

			main.run();
	}
}

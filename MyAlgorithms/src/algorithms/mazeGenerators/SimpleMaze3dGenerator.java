package algorithms.mazeGenerators;

	/**
 	* @author  Yulia Kolk
	* @version 1.0
	* @since   30/08/2015 

	* <h1>SimpleMaze3dGenerator</h1>
	* This class will extends Maze3dGeneratorBase and will create a new maze white a random algorithms
	* this algo will Promise a start and goal position 
	*/


import java.util.Random;

public class SimpleMaze3dGenerator extends Maze3dGeneratorBase {

	private Random rand = new Random();
	private static final float WALLS_RATIO = 0.5F;
	
	private Position chooseRandomStartPosition(Maze3d mazeObj){
		int[][][] maze =mazeObj.getMaze();
		int x, y, z ;
		
		//Entrance on the bottom level
		z=0;
		
		do{
			x = rand.nextInt(mazeObj.getCols());
			y = rand.nextInt(mazeObj.getRows());
		}
		while (maze[x][y][z] == Maze3d.WALL);
		
		Position pos = new Position(x, y, z);
		return pos;
	}
	
	private Position chooseRandomGoalPosition(Maze3d mazeObj)
	{
		int[][][] maze =mazeObj.getMaze();
		int x, y, z;
		
		// Exit on the top level
		z=mazeObj.getRows()-1;
		
		do{
			x = rand.nextInt(mazeObj.getCols());
			y = rand.nextInt(mazeObj.getRows());
		}
		while (maze[x][y][z] == Maze3d.WALL);
		
		Position pos = new Position(x, y, z);
		return pos;
	}
	
	public Maze3d createPath(Maze3d maze3d){
		Position start = maze3d.getStartPosition();
		Position goal = maze3d.getGoalPosition();
		
		while (start.getY()<goal.getY())
			maze3d.setFree(start.getX(), start.getY()+1, start.getZ());
		
		while (start.getY()>goal.getY())
			maze3d.setFree(start.getX(), start.getY()-1, start.getZ());
		
		while (start.getX()<goal.getX())
			maze3d.setFree(start.getX()+1, start.getY(), start.getZ());
		
		while (start.getX()>goal.getX())
			maze3d.setFree(start.getX()-1, start.getY(), start.getZ());
		
		for (int i = goal.getZ() ; i >= 0 ; i--){
			maze3d.setFree(start.getX(), start.getY(), i);
		}
		
		return maze3d;
		
	}
	
	private Maze3d randomWalls(Maze3d maze3d){
		int wallsNum = (int)(WALLS_RATIO *maze3d.getFloors()*maze3d.getCols()*maze3d.getRows());
		int x,y,z;
		
		for(int i = 0 ; i < wallsNum ; i++){
			x = rand.nextInt(maze3d.getCols());
			y = rand.nextInt(maze3d.getRows());
			z = rand.nextInt(maze3d.getFloors());
			
			maze3d.setWall(x,y,z);
		}
		
		return maze3d;
	}
	
	@Override
	public Maze3d generate(int cols, int rows, int floors) {
		Maze3d maze3d = new Maze3d(cols, rows, floors);
		maze3d = randomWalls(maze3d);
		
		//Choose a random entrance on the bottom level , first row
		Position startPos = chooseRandomStartPosition(maze3d);
		maze3d.setStartPosition(startPos);
		
		//Choose a random exit on the top level , last row
		Position goalPos = chooseRandomGoalPosition(maze3d);
		maze3d.setGoalPosition(goalPos);

		return maze3d;
	}
}
	

	


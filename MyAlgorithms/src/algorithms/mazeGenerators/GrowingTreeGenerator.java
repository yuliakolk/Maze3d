package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GrowingTreeGenerator extends Maze3dGeneratorBase {
	
	private Random rand = new Random();	

	@Override
    public Maze3d generate(int cols, int rows, int floors) {
		Maze3d maze = new Maze3d(cols, rows, floors);
		List<Position> cells = new ArrayList<Position>();
		
		// Choose random start position and mark it as free
		Position startPos = chooseRandomStartPosition(maze);
		maze.setStartPosition(startPos);
		Position pos = startPos;
		
		// Place walls in every cell
		initialize(maze);

		cells.add(startPos);
		
		CellSelector selector = new CellSelector();
		
		int choice = rand.nextInt(2);
		ICellSelecting strategy;
		
		if (choice == 0)
		{
			strategy = new LastCellSelector();
		}
		else
		{
			strategy = new RandomCellSelector();
		}
		
		selector.SetSelector(strategy);
		
		while (!cells.isEmpty()){
		// Get all unvisited neighbors
		List<Position> neighbors = findUnvisitedNeighbors(maze, pos);
		if (neighbors.size() > 0){
			Position neighbor = selector.SelectCell(neighbors);
			
			// Carve a passage between current cell and the neighbor
			carvePassageBetweenCells(maze, pos, neighbor);
			cells.add(neighbor);
			pos=neighbor;
			
		}
		else {
			cells.clear();
		}
		}
		
		Position goalPosition = chooseRandomGoalPosition(maze);
		maze.setGoalPosition(goalPosition);
		
		return maze;
	}

	
	private void initialize(Maze3d maze) {
		for (int x = 0; x < maze.getCols(); x++) {
			for (int y = 0; y < maze.getRows(); y++) {
				for (int z = 0; z< maze.getFloors(); z++) {
				maze.setWall(x, y, z);
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @param mazeObj
	 * @return a random position to start the maze from
	 */
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
	
	/**
	 * 
	 * @param mazeObj
	 * @return a random position to be the end of the maze
	 */
	private Position chooseRandomGoalPosition(Maze3d mazeObj)
	{
		int[][][] maze =mazeObj.getMaze();
		int x, y, z;
		
		// Exit on the top level
		z=mazeObj.getFloors()-1;
		
		do{
			x = rand.nextInt(mazeObj.getCols());
			y = rand.nextInt(mazeObj.getRows());
		}
		while (maze[x][y][z] == Maze3d.WALL);
		
		Position pos = new Position(x, y, z);
		return pos;
	}
	
	private Position chooseRandomPosition(Maze3d maze) {	
		int x = rand.nextInt(maze.getCols());
		while (x % 2 != 0) {
			x = rand.nextInt(maze.getCols());
		}

		int y = rand.nextInt(maze.getRows());
		while (y % 2 != 0) {
			y = rand.nextInt(maze.getRows());
		}
		
		int z = rand.nextInt(maze.getFloors());
		while (z % 2 != 0) {
			z = rand.nextInt(maze.getFloors());
		}
		
		return new Position(x, y, z);
	}
	
	private List<Position> findUnvisitedNeighbors(Maze3d maze, Position pos) {
		int[][][] mat = maze.getMaze();
		List<Position> neighbors = new ArrayList<Position>();
		
		if (pos.x - 2 >= 0 && mat[pos.x - 2][pos.y][pos.z] == Maze3d.WALL) {
			neighbors.add(new Position(pos.x - 2, pos.y, pos.z));
		}
		
		if (pos.x + 2 < maze.getCols() && mat[pos.x + 2][pos.y][pos.z] == Maze3d.WALL) {
			neighbors.add(new Position(pos.x + 2, pos.y, pos.z));
		}
		
		if (pos.y - 2 >= 0 && mat[pos.x][pos.y - 2][pos.z] == Maze3d.WALL) {
			neighbors.add(new Position(pos.x, pos.y - 2, pos.z));
		}	
		
		if (pos.y + 2 < maze.getRows() && mat[pos.x][pos.y + 2][pos.z] == Maze3d.WALL) {
			neighbors.add(new Position(pos.x, pos.y + 2, pos.z));
		}
		
		if (pos.z - 2 >= 0 && mat[pos.x][pos.y][pos.z - 2] == Maze3d.WALL) {
			neighbors.add(new Position(pos.x, pos.y, pos.z - 2));
		}	
		
		if (pos.z + 2 < maze.getFloors() && mat[pos.x][pos.y][pos.z + 2] == Maze3d.WALL) {
			neighbors.add(new Position(pos.x, pos.y, pos.z + 2));
		}
		
		return neighbors;
	}	
	
	private void carvePassageBetweenCells(Maze3d maze, Position pos, Position neighbor) {
		if (neighbor.x == pos.x + 2) {
			maze.setFree(pos.x + 1, pos.y, pos.z);
			maze.setFree(pos.x + 2, pos.y, pos.z);
		}
		else if (neighbor.x == pos.x - 2) {
			maze.setFree(pos.x - 1, pos.y, pos.z);
			maze.setFree(pos.x - 2, pos.y, pos.z);
		}
		else if (neighbor.y == pos.y + 2) {
			maze.setFree(pos.x, pos.y + 1, pos.z);
			maze.setFree(pos.x, pos.y + 2, pos.z);
		}
		else if (neighbor.y == pos.y - 2) {
			maze.setFree(pos.x, pos.y - 1, pos.z);
			maze.setFree(pos.x, pos.y - 2, pos.z);
		}
		else if (neighbor.z == pos.z + 2) {
			maze.setFree(pos.x, pos.y , pos.z + 1);
			maze.setFree(pos.x, pos.y, pos.z + 2);
		}
		else if (neighbor.z == pos.z - 2) {
			maze.setFree(pos.x, pos.y, pos.z - 1);
			maze.setFree(pos.x, pos.y, pos.z - 2);
		}
	}
}

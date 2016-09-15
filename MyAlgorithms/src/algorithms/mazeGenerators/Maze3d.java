package algorithms.mazeGenerators;

import java.util.ArrayList;

import java.util.List;


public class Maze3d {

	private int cols;

	private int rows;

	private int floors;

	private Position startPosition;

	private Position goalPosition;

    private int[][][] maze;

	public static final int FREE = 0;

	public static final int WALL = 1;

	
	public Maze3d(int cols, int rows, int floors) {

		this.cols = cols;

		this.rows = rows;

		this.floors = floors;

		this.maze = new int[cols][rows][floors];

	}


	public int getRows() {

		return rows;

	}


	public int getCols() {

		return cols;

	}

	
	public int getFloors() {

		return floors;

	}

	
	public int[][][] getMaze() {

		return maze;

	}


	public void setMaze(int[][][] maze) {

		this.maze = maze;

	}


	public static int getFree() {

		return FREE;

	}


	public static int getWall() {

		return WALL;

	}	


	public void setWall(int x, int y, int z) {

		maze[x][y][z] = WALL;

	}


	public void setFree(int x, int y, int z) {

		maze[x][y][z] = FREE;

	}

	
	public int getValue(int x, int y, int z) {

		return maze[x][y][z];

	}


	public void setStartPosition(Position startPosition) {

		this.startPosition = startPosition;

	}

	public Position getStartPosition() {

		return startPosition;

	}
	
	public Position getGoalPosition() {

		return goalPosition;

	}

	public void setGoalPosition(Position goalPosition) {

		this.goalPosition = goalPosition;

	}

	@Override

	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int z = 0; z < floors; z++){

			for (int y = 0; y < rows; y++) {

				for (int x = 0; x < cols; x++) {

					if(y == startPosition.y && x == startPosition.x && z== startPosition.z)

						sb.append("E");

					else if (y == goalPosition.y && x == goalPosition.x && z== goalPosition.z)

						sb.append("x");

						else

							sb.append(maze[x][y][z] + " ");

				}

				sb.append("\n");

			}

			sb.append("\n");

		}

		return sb.toString();

	}

public List<Position> getPossibleMoves(Position currPos) {

		List<Position> directions = new ArrayList<Position>();


		if (currPos.x + 1 < cols)

				if(maze[currPos.x + 1][currPos.y][currPos.z] == FREE) {

			directions.add(new Position(currPos.x + 1,currPos.y,currPos.z));

		}
		
		if (currPos.x - 1 >= 0) 

				if(maze[currPos.x - 1][currPos.y][currPos.z] == FREE) {

			directions.add(new Position(currPos.x - 1,currPos.y,currPos.z));

		}
	
		if (currPos.y + 1 < rows) 

				if(maze[currPos.x][currPos.y  + 1][currPos.z] == FREE) {

			directions.add(new Position(currPos.x,currPos.y + 1,currPos.z));

		}

		if (currPos.y - 1 >= 0)

				if(maze[currPos.x][currPos.y  - 1][currPos.z] == FREE) {

			directions.add(new Position(currPos.x,currPos.y - 1,currPos.z));

		}

		if (currPos.z + 1 < floors) 

				if(maze[currPos.x][currPos.y][currPos.z + 1] == FREE) {

			directions.add(new Position(currPos.x,currPos.y,currPos.z + 1));

		}

		if (currPos.z - 1 >= 0) 

				if(maze[currPos.x][currPos.y][currPos.z - 1] == FREE) {

			directions.add(new Position(currPos.x,currPos.y,currPos.z - 1));

		}

		return directions;

	}

	public int[][] getCrossSectionByX(int x){

		int[][] tmpArr = new int[rows][floors];

		for (int z = 0 ; z < floors ; z++)

			for(int y = 0 ; y < rows ; y++)

				tmpArr[y][z]= maze[x][y][z];

		return tmpArr;
	}

	public int[][] getCrossSectionByY(int y){

		int[][] tmpArr = new int[cols][floors];

		for (int z = 0 ; z < floors ; z++)

			for(int x = 0 ; x < cols ; x++)

				tmpArr[x][z]= maze[x][y][z];

		return tmpArr;
	}

	public int[][] getCrossSectionByZ(int z){

		int[][] tmpArr = new int[cols][rows];

		for(int y = 0 ; y < rows ; y++)

			for(int x = 0 ; x < cols ; x++)

				tmpArr[x][y]= maze[x][y][z];

		return tmpArr;

	}

}
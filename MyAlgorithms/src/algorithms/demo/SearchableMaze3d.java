package algorithms.demo;

/**
* @author  Yulia Kolk
* @version 1.0
* @since   30/08/2015 
*/

/**
* <h1>Maze3dSearch</h1>
* this class define the problem
* This  Maze3dSearch class implements must Searchable Interface provide a start goal and an array list that represent AllPossibleStates from one state to otherand
*/

import java.util.ArrayList;
import java.util.List;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

public class SearchableMaze3d implements Searchable<Position> {
	
	private Maze3d maze;
	
	public SearchableMaze3d(Maze3d mymaze){
		this.maze = mymaze;
	}

	@Override
	public State<Position> getStartState() {
		Position p =maze.getStartPosition();
		return new State<Position>(maze.getStartPosition().toString(), 0, null, p);
	}

	@Override
	public State<Position> getGoalState() {
		return new State<Position>(maze.getGoalPosition());
	}

	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		Position currPos= s.getValue();
		
		List<Position> moves=maze.getPossibleMoves(currPos);
		ArrayList<State<Position>> stateList = new ArrayList<State<Position>>();
		
		for (Position pos:moves){
		stateList.add(new State<Position>(pos));
		}
		
		return stateList;
	}

	@Override
	public double getMoveCost(State<Position> currState, State<Position> neighbor) {
		return 1;
	}
	

}
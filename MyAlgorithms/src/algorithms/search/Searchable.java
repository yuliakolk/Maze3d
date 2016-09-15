package algorithms.search;

/**
* @author  Yulia Kolk
* @version 1.0
* @since   30/08/2015 
* 
* <h1>Searchable</h1>
* This  interface  Searchable define the Functionality of the problem
* every problem must provide the start and the goal state, when Given all possible move from state and the move cost
*/

import java.util.ArrayList;

public interface Searchable<T> {
	State<T> getStartState();
	State<T> getGoalState();
	ArrayList<State<T>> getAllPossibleStates(State<T> currState);
	double getMoveCost(State<T> currState, State<T> neighbor);
}

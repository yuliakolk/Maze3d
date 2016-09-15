package algorithms.search;

/**
* answers to the questions in the project:
* 1. Advantages of BFS :
*  - Takes advantage of domain information to guide search
*  - Greedy advance to the goal.
*    Advantages of DFS :
*  - If dfs finds solution without exploring much in a path then the time and space it takes will be very less.
*  - The memory requirement is only linear with respect to the search graph.
*  2. I have chosen to implement the bfs in that way which is based on the pseudu code given to us.
*/

/**
* @author  Yulia Kolk
* @version 1.0
* @since   30/08/2015 
*  <h1>BFS</h1>
* This class defining a BFS algorithm type of Searcher that can solve Problems.
* This class extends CommonSearcher
*/

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Bfs<T> extends CommonSearcher<T> {
	
	private PriorityQueue<State<T>> openList = new PriorityQueue<State<T>>();
	private PriorityQueue<State<T>> closedList = new PriorityQueue<State<T>>(); //PriorityQueue for all the members that has worked on

	@Override
	/**
	 * This method goal is to search and generate a instance of solution to a search-able problem.
	 *@param Searchable s instance represent the Problem you want to Solve.
	 *@return Solution that contains the path from the beginning to the end.        
	 */
	
	//the algorithms  of best first search - (BFS) will find the best path to goal state
	public Solution<T> search(Searchable<T> searchable) {
		State<T> startState = searchable.getStartState();
		startState.setCost(1);
		openList.add(startState); //adding to the open list (PriorityQueue) the start state 
		
		while (!openList.isEmpty()) { //while open list is not empty do
			State<T> currState = openList.poll(); //pop the first member on the open list
			this.evaluatedNodes++;
			closedList.add(currState);
			State<T> goalState = searchable.getGoalState();
			if (currState.equals(goalState)) { // if the state equal to the goal state
				return backTrace(currState); ////return the backTrace this method implements on CommonSearcher 
			}
			
			ArrayList<State<T>> neighbors = searchable.getAllPossibleStates(currState); //array list contains all possible state from current state
			
			for (State<T> neighbor : neighbors) { //for each possible state do
				if((!(openList.contains(neighbor)))&&(!(closedList.contains(neighbor)))){ //not on closeList and not on openList
					neighbor.setCameFrom(currState);
					neighbor.setCost(currState.getCost() + searchable.getMoveCost(currState, neighbor));
					openList.add(neighbor);
				}
				else{
					//how much its cost to come to state + the define cost for the specific Searchable
					double newPathCost = currState.getCost() + searchable.getMoveCost(currState, neighbor);
					if (neighbor.getCost() > newPathCost)
					{
						neighbor.setCost(newPathCost); //set the cost for state (how much its cost to come to state + the define cost for the specific Searchable)
						neighbor.setCameFrom(currState); //set for state that he came from currState
						
						if (!openList.contains(neighbor)){ //if state is not on openList
							//move from openList to closeList
							closedList.remove(neighbor);
							openList.add(neighbor);
						}
						else{ //if there is a better path
							openList.remove(neighbor);
							openList.add(neighbor);
						}
					}
				}
			}
		}
		System.out.println("There problem cant be solved" + evaluatedNodes);	//if the openList is empty and it not got to the goal state, then the problen cant be solved
		return null;
	}

	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
}

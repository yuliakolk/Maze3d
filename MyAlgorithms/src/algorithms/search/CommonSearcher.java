package algorithms.search;

/**
* @author  Yulia Kolk
* @version 1.0
* @since   30/08/2016
* 
* 
* * <h1>CommonSearcher</h1>
* This Abstract class define all the kind of searcher algorithms.
* This class Implements Searcher Interface.
* all kind of algorithms of CommonSearcher must implements a search method and this method define the algorithms
* this class will count how much Nodes the algorithms evaluated 
*/

import java.util.ArrayList;

public abstract class CommonSearcher<T> implements Searcher<T> {

	protected int evaluatedNodes;

	/**
	 * @param goalState
	 * @return the back trace between goal and start states
	 */
	protected Solution<T> backTrace(State<T> goalState) {
		Solution<T> sol = new Solution<T>();
		ArrayList<State<T>> toInsert = new ArrayList<State<T>>();
		State<T> current = goalState;

		while (!(current==null)){
			toInsert.add(current);
			current = current.getCameFrom();
		}

		//insert to solution
		sol.setStates(toInsert);

		return sol;
	}

	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}

	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}
}

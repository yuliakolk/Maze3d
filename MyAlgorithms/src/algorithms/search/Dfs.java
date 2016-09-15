package algorithms.search;

import java.util.List;
import java.util.ArrayList;

public class Dfs<T> extends CommonSearcher<T> {
	/**
	 * this is a Recursively function that find one way to solve the problem (not the best way)
	 * this is a depth search and this algorithm always go depth and check if there is more nodes down.
	 * if there is- and this last one is the goal- we find a way.
	 * else- we are come back to the last nodes and check is Other neighbors
	 */
	private ArrayList<State <T>> Visit=new ArrayList<State<T>>();
	Solution<T> sol=new Solution<T>();
	@Override
	public Solution<T> search(Searchable<T> s) {
		return DFSalgo(s.getStartState(),s);
	}
	
	public Solution<T> DFSalgo(State<T> currState,Searchable<T> s){
	if(currState.equals(s.getGoalState())){
		sol=backTrace(currState);
	}
	List<State<T>> neighbors=s.getAllPossibleStates(currState);
	for(State<T> neighbor:neighbors){
		setEvaluatedNodes(getEvaluatedNodes() + 1);
		if(!Visit.contains(neighbor)){
			neighbor.setCameFrom(currState);
			Visit.add(neighbor);
			DFSalgo(neighbor, s);
		}
	}
		return sol;
	}

	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
}


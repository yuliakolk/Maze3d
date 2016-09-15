package algorithms.search;




import java.util.ArrayList;




public abstract class CommonSearcher<T> implements Searcher<T> {




	protected int evaluatedNodes;




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
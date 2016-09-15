package algorithms.search;

import java.util.ArrayList;

import java.util.PriorityQueue;

public class Bfs<T> extends CommonSearcher<T> {

	
	private PriorityQueue<State<T>> openList = new PriorityQueue<State<T>>();

	private PriorityQueue<State<T>> closedList = new PriorityQueue<State<T>>();


	@Override

	public Solution<T> search(Searchable<T> searchable) {

		State<T> startState = searchable.getStartState();

		startState.setCost(1);

		openList.add(startState);

		
		while (!openList.isEmpty()) {

			State<T> currState = openList.poll();

			this.evaluatedNodes++;

			closedList.add(currState);

			State<T> goalState = searchable.getGoalState();

			if (currState.equals(goalState)) {

				return backTrace(currState);

			}

			ArrayList<State<T>> neighbors = searchable.getAllPossibleStates(currState);

			for (State<T> neighbor : neighbors) {

				if((!(openList.contains(neighbor)))&&(!(closedList.contains(neighbor)))){

					neighbor.setCameFrom(currState);

					neighbor.setCost(currState.getCost() + searchable.getMoveCost(currState, neighbor));

					openList.add(neighbor);

				}

				else{

					double newPathCost = currState.getCost() + searchable.getMoveCost(currState, neighbor);

					if (neighbor.getCost() > newPathCost)

					{

						neighbor.setCost(newPathCost);

						neighbor.setCameFrom(currState);

						

						if (!openList.contains(neighbor)){

							closedList.remove(neighbor);

							openList.add(neighbor);

						}

						else{

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

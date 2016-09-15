package algorithms.search;




import java.util.ArrayList;




public interface Searchable<T> {

	State<T> getStartState();

	State<T> getGoalState();

	ArrayList<State<T>> getAllPossibleStates(State<T> currState);

	double getMoveCost(State<T> currState, State<T> neighbor);

}
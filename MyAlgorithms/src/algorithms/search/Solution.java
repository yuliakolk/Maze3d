package algorithms.search;

/**
* @author  Yulia Kolk
* @version 1.0
* @since   30/08/2015 
*
* <h1>Solution</h1>
* this class define the solution
* This  Solution class represent the Solution of the problem this class contain a string to keep the solution generice
*/

import java.util.ArrayList;

public class Solution<T> {
	
	private ArrayList<State<T>> states;

	public ArrayList<State<T>> getStates() {
		return states;
	}

	public void setStates(ArrayList<State<T>> states) {
		this.states = states;
	}
}

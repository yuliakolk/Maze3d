package algorithms.search;




/**

* <h1>Searcher</h1>

* This  interface define searcher algorithms.

* This  interface  - searcher define the Functionality of the algorithms

* all kind of algorithms  must implements a search method and this method define the algorithms

*/




public interface Searcher<T> {

	/**

	 * @param s means any kind of Search problem

	 * @return solution 

	 */

	public Solution<T> search(Searchable<T> searchable);




	public int getNumberOfNodesEvaluated();




}
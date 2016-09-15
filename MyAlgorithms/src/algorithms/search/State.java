package algorithms.search;




public class State<T> implements Comparable<State<T>> {

	

	private String description;

	private double cost;

	private State<T> cameFrom;

	private T value;

	

	public State(String desc, double cost, State<T> came, T val){

		this.description = desc;

		this.cost = cost;

		this.cameFrom = came;

		this.value = val;

	}

	

	public State(T obj)

	{

		this.value = obj;

	}

	

	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;

	}

	public double getCost() {

		return cost;

	}

	public void setCost(double cost) {

		this.cost = cost;

	}

	public State<T> getCameFrom() {

		return cameFrom;

	}

	public void setCameFrom(State<T> cameFrom) {

		this.cameFrom = cameFrom;

	}

	@Override

	public int compareTo(State<T> o) {

		return (int)(this.cost - o.cost);		

	}

	public T getValue() {

		return value;

	}

	public void setValue(T value) {

		this.value = value;

	}

	

	@Override

	// we override Object's equals method

    public boolean equals(Object obj){ 

        return value.equals(((State<T>)obj).value);

    }

	

}
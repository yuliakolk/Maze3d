package algorithms.mazeGenerators;

import java.util.List;

public class CellSelector {
	
	private ICellSelecting strategy;
	
	// Executes the strategy
	public Position SelectCell(List<Position>neighbors)
	{
		return strategy.SelectCell(neighbors);
	}
	
	// Changes the strategy
	public void SetSelector(ICellSelecting strategy)
	{
		this.strategy = strategy;
	}
}

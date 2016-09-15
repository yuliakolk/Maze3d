package algorithms.mazeGenerators;

import java.util.List;

public class CellSelector {

	private ICellSelecting strategy;

	public Position SelectCell(List<Position>neighbors)

	{

		return strategy.SelectCell(neighbors);

	}

	
	public void SetSelector(ICellSelecting strategy)

	{

		this.strategy = strategy;

	}

}
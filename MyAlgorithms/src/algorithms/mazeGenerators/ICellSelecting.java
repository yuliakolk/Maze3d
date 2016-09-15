package algorithms.mazeGenerators;

import java.util.List;

// The interface for the cell selecting strategies
public interface ICellSelecting {
	public Position SelectCell(List<Position>neighbors);
}

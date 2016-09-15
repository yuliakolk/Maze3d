package algorithms.mazeGenerators;

import java.util.List;

// First Strategy: selects the last cell
public class LastCellSelector implements ICellSelecting{

	@Override
	public Position SelectCell(List<Position>neighbors) {
       Position pos = neighbors.get(neighbors.size() - 1);
		return pos;
	}

}

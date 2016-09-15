package algorithms.mazeGenerators;

import java.util.List;

public interface ICellSelecting {

	public Position SelectCell(List<Position>neighbors);

}

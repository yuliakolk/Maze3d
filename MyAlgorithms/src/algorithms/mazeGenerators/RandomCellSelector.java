package algorithms.mazeGenerators;

import java.util.List;
import java.util.Random;

// Second strategy: selects cell randomly
public class RandomCellSelector implements ICellSelecting{

	private Random rand = new Random();
	
	@Override
	public Position SelectCell(List<Position>neighbors) {
		int idx = rand.nextInt(neighbors.size());
		Position neighbor = neighbors.get(idx);
		return neighbor;
	}

}

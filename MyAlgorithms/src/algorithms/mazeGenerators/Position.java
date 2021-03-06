package algorithms.mazeGenerators;

/**

* @author  Yulia Kolk

* @version 1.0

* @since   30/08/2016 

*/

/**

* <h1>Position</h1>

* This class defining a position of a cell

* this cell represent by a point in a feald 

* this position have a 3 premtive paramter x,y,z

*/


public class Position {
	public int x; 
	public int y;
	public int z;
		
	
	public Position(int x, int y, int z) {		
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "{" + x + "," + y + "," + z + "}";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position))
			throw new IllegalArgumentException("Object must be position");
		
		Position p = (Position)obj;
		return x == p.x && y == p.y && z == p.z;			
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
}


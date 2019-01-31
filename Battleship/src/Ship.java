
public class Ship
{
	private String name;
	private int size;
	private BoardElement coord[];

	public Ship(String name, int size, BoardElement[] coord)
	{
		this.name = name;
		this.size = size;
		this.coord = coord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BoardElement[] getCoord() {
		return coord;
	}

	public void setCoord(BoardElement[] coord) {
		this.coord = coord;
	}
	
}
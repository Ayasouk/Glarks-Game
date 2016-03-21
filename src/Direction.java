
public class Direction {

	public static final String NORTH = "North";
	public static final String SOUTH = "South";
	public static final String EAST = "East";
	public static final String WEST = "West";
	
	private String direction;
	
	public Direction(String direction){
		this.direction = direction;
	}
	
	public void goNorth(){
		this.direction = NORTH;
	}
	
	public void goSouth(){
		this.direction = SOUTH;
	}
	
	public void goEast(){
		this.direction = EAST;
	}
	
	public void goWest(){
		this.direction = WEST;
	}
	
	public String toString(){
		return this.direction;
	}
}

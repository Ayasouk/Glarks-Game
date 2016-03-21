/**
 * 
 */

/**
 * @author oukache
 * Glark is a class that allows the game to build emulated creature 
 * it's able to move and to eat on the Damier
 * @see Damier
 * @see Game
 */
abstract public class Glark {
	//TODO: Voir pour les valeurs par defauts (ex: energie de depart, energie a ajouter si le glark mange un autre, etc...)
	private int energy;
	private Direction direction;
	/** the square must be free on the platform's Damier (FreeCase) **/
	private Case position;
	
	/** ------ Defaults Variables ------  **/
	protected static int MAX_ENERGY = 1000;
	
	
	/**
	 * Constructor of the Glark Class
	 * @param departureCase corresponds to the depart Square
	 */
	public Glark(Case departureCase){
		this.position = departureCase;
		departureCase.welcomeGlark(this);
		direction = new Direction(Direction.NORTH);
	}
	
	public Glark(Case departureCase, Direction direction){
		this.position = departureCase;
		this.direction = direction;
		departureCase.welcomeGlark(this);
	}
	
	/**
	 * Rise the glark energy
	 * @param supp corresponds to the energy rise
	 */
	public void riseEnergy(int supp){
		if ((this.energy + supp)<= MAX_ENERGY){
			this.energy += supp;
		}
		else if(true) //TODO: Toggle to false if GUI
			System.out.println("Energy max already reached");
	}
	
	/**
	 * Read access to the glark position
	 * @return Case
	 */
	public Case getPosition(){
		return this.position;
	}
	
	/**
	 * Read access to the glark direction
	 * @return Case
	 */
	public Direction getDirection(){
		return this.direction;
	}
	
	public String toString(){
		return "\ntype: "+this.getClass()+"\nPosition : "+this.position.getPosition()+"\nEnergie : "+this.energy+"/"+MAX_ENERGY+"\n";
	}
}

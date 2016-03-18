/**
 * 
 */

/**
 * @author oukache
 *	
 * the class Case is the class that allows to build square objects
 * it's an abstract class. the herited class are Free Case et Fence Case
 * @see FreeCase 
 * @see FenceCase
 */

abstract public class Case {
	private int posX;
	private int posY;
	
	
	/**
	 * Constructor of the Square
	 * @param x index on the X axis
	 * @param y index on the Y axis
	 */
	public Case(int x, int y){
		this.posX = new Integer(x);
		this.posY = new Integer(y);
	}
	
	/**
	 * Predicate to ask if the square is a fence or not
	 * @return boolean (default it returns false)
	 */
	public boolean isFence(){
		return false;
	}
	
	/**
	 * Read access to the index on the X axis of the square
	 * @return Integer
	 */
	public int getPosX(){
		return this.posX;
	}
	
	/**
	 * Read access to the index on the Y axis of the square
	 * @return Integer
	 */
	public int getPosY(){
		return this.posY;
	}
	
}

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author oukache
 * FreeCase is the class that allows the Damier's game to create
 * square that glarks can move on
 * @see Case
 * @see FenceCase
 */
public class FreeCase extends Case {
	/** Class Variables **/

	/** Instances Variables **/
	private ArrayList<Glark> listeDeGlarks; 
	private int nb_glarks;
	private Damier damier;
	private boolean hasBlurf;
	//TODO: prepare an extension list for others objects than blurf
	// that can use an interface and a composite pattern and perhaps a decorator pattern
	// private ArrayList<CaseObject> listeDesObjets;
	
	/**
	 * Constructor of the class FreeCase
	 * @param x : int
	 * @param y : int
	 */
	public FreeCase(int x, int y, Damier damier){
		super(x, y);
		this.listeDeGlarks = new ArrayList<Glark>();
		this.nb_glarks = 0;
		this.damier = damier;
		this.hasBlurf = false;
	}
	
	
	/** ------------ Objects or Glarks Management -------------- **/
	/**
	 * Add Case object 
	 * set the blurf
	 */
	//TODO: ADAPT the blurf system to extensible objects
	public void setBlurf(){
		this.hasBlurf = !this.hasBlurf;
	}
	
	public boolean hasBlurf(){
		return this.hasBlurf;
	}
	
	/**
	 * Welcome a new glark on the square
	 * @param new_glark
	 */
	public void welcomeGlark(Glark new_glark){
		this.listeDeGlarks.add(new_glark);
		this.nb_glarks += 1;
		//TODO: exception to prevent the fact that there is not enough places for the new glark?
	}
	
	/**
	 * Delete a leaving Glark
	 * @param leaving_glark
	 */
	public void leaveGlark(Glark leaving_glark){
		if(this.listeDeGlarks.contains(leaving_glark)){
			this.listeDeGlarks.remove(leaving_glark);
		}
		else //TODO: exception to prevent the fact that the glark was not on the square
			System.out.println("Glark non trouve dans la list");
	}
	
	/**
	 * Print the glarks on the square
	 * Maybe use a Iterator Pattern
	 * Maybe use a Composite pattern
	 */
	public void printGlarks(){
		Glark cur_glark;
		Iterator<Glark> ite = this.listeDeGlarks.iterator();
		System.out.println(this.nb_glarks+" glarks");
		while(ite.hasNext()){
			cur_glark = ite.next();
			System.out.println(cur_glark);
		}
	}
	
	/**
	 * Print the objects on the square 
	 * Now there is just blurf object 
	 */
	public void printObjects(){
		System.out.print("blurf");
	}
	
	
	/** --------- Access to the neighborhood ------------- **/
	/**
	 * Access to the North Neighbor
	 * @return Case
	 * @exception ArrayIndexOutOfBoundsException
	 */
	public Case NorthCase() throws ArrayIndexOutOfBoundsException {
		if(this.getPosY() == this.damier.getWidth())
			throw new ArrayIndexOutOfBoundsException();
		return this.damier.access(this.getPosX(), this.getPosY()+1);
	}
	
	/**
	 * Access to the South Neighbor
	 * @return Case
	 * @exception ArrayIndexOutOfBoundsException
	 */
	public Case SouthCase() throws ArrayIndexOutOfBoundsException {
		if(this.getPosY() == 0)
			throw new ArrayIndexOutOfBoundsException();
		return this.damier.access(this.getPosX(), this.getPosY()-1);
	}
	
	/**
	 * Access to the East Neighbor
	 * @return Case
	 * @exception ArrayIndexOutOfBoundsException
	 */
	public Case EastCase() throws ArrayIndexOutOfBoundsException {
		if(this.getPosX() == this.damier.getHeight())
			throw new ArrayIndexOutOfBoundsException();
		return this.damier.access(this.getPosX()+1, this.getPosY());
	}
	
	/**
	 * Access to the West Neighbor
	 * @return Case
	 * @exception ArrayIndexOutOfBoundsException
	 */
	public Case WestCase() throws ArrayIndexOutOfBoundsException {
		if(this.getPosX() == 0)
			throw new ArrayIndexOutOfBoundsException();
		return this.damier.access(this.getPosX()-1, this.getPosY());
	}
	
	
	public String toString(){
		if (this.hasBlurf())
			return "B";
		return " ";
	}
	/*public void addCaseObject(){
		hasBlurf = true;
	}*/
	
	/*public boolean hasCaseObjects(){
		return listeDesObjets.isEmpty();
	}*/
}

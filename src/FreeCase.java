import java.util.ArrayList;

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
	private static int MAX_GLARKS = 10;
	
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
	 * Add a new glark on the square
	 * @param new_glark
	 */
	public void addGlark(Glark new_glark){
		if(this.nb_glarks <= MAX_GLARKS){
			this.listeDeGlarks.add(new_glark);
			this.nb_glarks += 1;
		}
		else //TODO: exception to prevent the fact that there is not enough places for the new glark?
			System.out.println("Trop de Glarks sur cette case");
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
	
	
	/** --------- Access to the neighbors ------------- **/
	public Case NorthCase(){
		return this.damier.access(this.getPosX(), this.getPosY()+1);
	}
	
	public Case SouthCase(){
		return this.damier.access(this.getPosX(), this.getPosY()-1);
	}
	
	public Case EastCase(){
		return this.damier.access(this.getPosX()+1, this.getPosY());
	}
	
	public Case WestCase(){
		return this.damier.access(this.getPosX()-1, this.getPosY());
	}
	/*public void addCaseObject(){
		hasBlurf = true;
	}*/
	
	/*public boolean hasCaseObjects(){
		return listeDesObjets.isEmpty();
	}*/
}

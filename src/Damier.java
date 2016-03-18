/**
 * 
 */

/**
 * @author oukache
 *
 */
//import java.util.Arrays;

public class Damier {
	private Case[][] plateau;
	private int height;
	private int width;
	private static boolean exists = false;
	
	/**
	 * Private constructor of the class Damier
	 * Creates a double dimension array of squares and initialize dimensions' matrice
	 * @param lmax : the height of the matrice 
	 * @param hmax : the width of the matrice 
	 */
	private Damier(int lmax, int hmax){
		this.height = lmax;
		this.width = hmax;
		this.plateau = new Case[this.height][this.width];
		
		/**
		 * TODO: Possible to use an iterator
		 */
		for(int i=0; i<this.height; i++){
			for(int a=0; a<this.width; a++){
				this.plateau[i][a] = null;
			}
		}
	}
	
	@Overload
	private Damier(){
		new Damier(5,5);
	}
	
	/**
	 * Make the building of the unique platform's Damier 
	 * @param lmax the height of the matrice 
	 * @param hmax the width of the matrice 
	 * @return Damier
	 * @throws AlreadyInstanciatedException
	 */
	public Damier construire(int lmax, int hmax) throws AlreadyInstanciatedException {
		if (exists){
			throw new AlreadyInstanciatedException("Dalmier");
		}
		else{
			exists = true;
			return new Damier(lmax, hmax);
		}
	}
	
	@Overload
	public Damier construire() throws AlreadyInstanciatedException {
		if (exists){
			throw new AlreadyInstanciatedException("Dalmier");
		}
		else{
			exists= true;
			return new Damier(5, 5);
		}
	}
	
	/**
	 * Give access to a Case of the platform
	 * @param i
	 * @param j
	 * @return Case
	 */
	public Case access(int i, int j){
		return this.plateau[i][j];
	}
	
}

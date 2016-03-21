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
				this.plateau[i][a] = new FreeCase(i, a, this);
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
	public static Damier construire(int lmax, int hmax) throws AlreadyInstanciatedException {
		if (exists){
			throw new AlreadyInstanciatedException("Dalmier");
		}
		else{
			exists = true;
			return new Damier(lmax, hmax);
		}
	}
	
	@Overload
	public static Damier construire() throws AlreadyInstanciatedException {
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
		if(i > this.height||j > this.width)
			return null;
		return this.plateau[i][j];
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}
	
	public String toString(){
		String s_platform = "";
		for(int i=0; i<this.height; i++){
			for(int a=0; a<this.width; a++)
				System.out.print("___");
			System.out.print("\n|");
			for(int j=0; j<this.width; j++){
				System.out.print(this.access(i, j)+"|");
			}
			System.out.println("|");
		}
		return s_platform;
	}

	/**
	 * Set an Fence Case on the platform
	 * @param a
	 * @param b
	 */
	public void setFence(int a, int b) {
		// TODO Auto-generated method stub
		if(a < this.height && b < this.width && a>= 0 && b>= 0)
			this.plateau[a][b] = new FenceCase(a,b);
	}

}

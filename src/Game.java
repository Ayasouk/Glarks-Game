import java.util.ArrayList;

/**
 * @author oukache
 *
 */


public class Game {
	
	private Damier damier;
	private ArrayList<Glark> listeDeGlarks;
	
	public Game(Damier damier, int nbGlark){
		this.damier = damier;
		this.listeDeGlarks = new ArrayList<Glark>(nbGlark);
		
		try{
			this.damier = damier.construire(5,5);
		}
		catch(AlreadyInstanciatedException e){
			System.out.println(e);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

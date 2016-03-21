import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/**
 * @author oukache
 *
 */


public class Game {
	
	private Damier damier;
	private ArrayList<Glark> listeDeGlarks;
	
	private Game(Damier damier, int nbGlarks){
		this.damier = damier;
		this.listeDeGlarks = new ArrayList<Glark>(nbGlarks);
	}

	private Game(Damier damier){
		this.damier = damier;
		this.listeDeGlarks = new ArrayList<Glark>();
	}
	
	public static Game initialiseToi(){
		try{
			Damier damier = Damier.construire(5,5);
			Game game = new Game(damier);
			game.putFenceCase(2);
			/** Interface posable ? certainement mieux pour disposer tout type dobjets ou glarks dans le damier **/
			game.putGlark(new GlarkBorne(damier.access(1,3)));
			game.putGlark(new GlarkPirate(damier.access(2,4)));
			game.putGlark(new GlarkGlouton(damier.access(3,3)));
			return game;
		}
		catch(AlreadyInstanciatedException e){
			System.out.println(e);
		}
		return null;
	}

	
	private void putGlark(Glark glark) {
		// TODO Auto-generated method stub
		Case fcase;
		if(!(fcase = this.damier.access(glark.getPosition().getPosX(),glark.getPosition().getPosX())).isFence())
			((FreeCase) fcase).welcomeGlark(glark);
	}

	/**
	 * put a FenceCases on the platform (Random way)
	 * @param nbC corresponds to the number of Fence Case you want to put
	 */
	private void putFenceCase(int nbC) {
		int a = 0;
		int b = 0;
		Random rand = new Random();
		// TODO Auto-generated method stub
		for(int i=0; i<nbC; i++){
			do{
			    a = rand.nextInt(this.damier.getHeight() - 1) + 1;
				b = rand.nextInt(this.damier.getWidth() - 1) + 1;
			}while(this.damier.access((a%this.damier.getHeight()), b%this.damier.getWidth()).isFence());
			this.damier.setFence(a,b);
		}
	}

	/**
	 * Print the glarks presents on the platform
	 * @see Glark
	 */
	public void printGlarks(){
		Glark current_glark;
		Iterator<? extends Glark> ite = listeDeGlarks.iterator();
		do{
			current_glark = ite.next();
			System.out.println(current_glark);
		}while(ite.hasNext());
	}
	
	/**
	 * Print the platform
	 * @see Damier
	 */
	public void printDamier(){
		System.out.println(this.damier);
	}

}

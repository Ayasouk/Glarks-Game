
public class Test {
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Game game;

			game = Game.initialiseToi();
			System.out.println("------ Test jeu Glark -------");
			System.out.println(game);
			game.printDamier();
			game.printGlarks();
		}

}

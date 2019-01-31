import enigma.core.Enigma;



public class GameTest
{
	public static void main(String[] args)
	{
		Enigma.getConsole("GameTest");
		
		Game game=new Game();
		game.play();
	}

}


import enigma.core.Enigma;

import java.util.*;

public class Game
{
	public static Player player = new Player(0, "Player");
	public static Player computer = new Player(0, "Computer");

	public void play()
	{
		enigma.console.Console cn = Enigma.getConsole("Board");
		Scanner scn = new Scanner(System.in);
		Board board = new Board();

		board.GuessBoardEstablisher();
		board.board();

		board.ShipBoardEstablisher();
		
		int targetx = 0;
		int targety = 0;
		int ch = 0;
		
		player.filling_hit();
		do
		{
			do
			{
				cn.getTextWindow().setCursorPosition(18, 20);
				cn.getTextWindow().output("X: ");
				targetx = scn.nextInt();

				cn.getTextWindow().setCursorPosition(18, 20);
				cn.getTextWindow().output("Y:  ");
				targety = scn.nextInt();

				player.player_hit_score(targetx, targety);
				board.board();

				computer.computer_hit_score();
				
				board.board();

				Board.round++;

			} while (player.getScore() != 300 && computer.getScore() != 300);
			Clear();
			
			cn.getTextWindow().setCursorPosition(0, 0);
			
			if (player.getScore() > computer.getScore())
			{
				player.setScore(player.getScore() - computer.getScore());
				computer.setScore(0);
				cn.getTextWindow().setCursorPosition(20, 20);
				cn.getTextWindow().output("Player Won with  " + player.getScore() + " point in " + Board.round + " rounds", board.yellow);
			}
			else
			{
				computer.setScore(computer.getScore() - player.getScore());
				player.setScore(0);
				cn.getTextWindow().setCursorPosition(20, 20);
				cn.getTextWindow().output("Computer Won with " + computer.getScore() + " point in " + Board.round + " rounds", board.yellow);
			}

			cn.getTextWindow().setCursorPosition(20, 23);
			cn.getTextWindow().output("1-Play Again ");
			cn.getTextWindow().setCursorPosition(20, 24);
			cn.getTextWindow().output("2-Exit ");
			ch = scn.nextInt();
			
			if (ch != 1)
			{
				System.exit(0);
			}
		} while (ch == 1);
	}

	// /////////////

	public static void Clear()
	{
		enigma.console.Console cn = Enigma.getConsole("Board");
		for (int i = 0; i < 75; i++) {
			for (int j = 0; j < 75; j++) {
				cn.getTextWindow().setCursorPosition(i, j);
				cn.getTextWindow().output(" ");
			}
		}
	}
}


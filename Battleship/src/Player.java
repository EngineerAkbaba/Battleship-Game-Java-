
import java.util.Random;

public class Player
{
	private int score;
	private String name;

	public Player(int score, String name)
	{
		super();
		this.score = score;
		this.name = name;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	boolean[][] hit = new boolean[9][9];

	public void filling_hit()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				hit[i][j] = false;
			}
		}
	}

	public void player_hit_score(int x, int y)
	{
		boolean patrol = false;
		boolean	destroyer = false;
		boolean	aircraft = false;
		boolean	battleship = false;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		
		for (int i = 0; i < Board.patrol_boat2.getSize(); i++)
		{
			if (Board.patrol_boatCoord2[i].getX_coord() == x
					&& Board.patrol_boatCoord2[i].getY_coord() == y)
			{
				patrol = true;
				count1 = i;
				break;
			}
		}
		for (int j = 0; j < Board.destroyer2.getSize(); j++)
		{
			if (Board.destroyerCoord2[j].getX_coord() == x
					&& Board.destroyerCoord2[j].getY_coord() == y)
			{
				destroyer = true;
				count2 = j;
				break;
			}
		}
		for (int k = 0; k < Board.battleship2.getSize(); k++)
		{
			if (Board.battleshipCoord2[k].getX_coord() == x
					&& Board.battleshipCoord2[k].getY_coord() == y)
			{
				battleship = true;
				count3 = k;
				break;
			}
		}
		for (int l = 0; l < Board.aircraft_carrier2.getSize(); l++)
		{
			if (Board.aircraft_carrierCoord2[l].getX_coord() == x
					&& Board.aircraft_carrierCoord2[l].getY_coord() == y)
			{
				aircraft = true;
				count4 = l;
				break;
			}
		}
		if (patrol == true)
		{
			Board.patrol_boatCoord2[count1].setX_coord(x);
			Board.patrol_boatCoord2[count1].setY_coord(y);
			Board.patrol_boatCoord2[count1].setValue('+');
			Board.guessboard[x][y] = '+';

		}
		else if (destroyer == true)
		{
			Board.destroyerCoord2[count2].setX_coord(x);
			Board.destroyerCoord2[count2].setY_coord(y);
			Board.destroyerCoord2[count2].setValue('+');
			Board.guessboard[x][y] = '+';
		}
		else if (battleship == true)
		{
			Board.battleshipCoord2[count3].setX_coord(x);
			Board.battleshipCoord2[count3].setY_coord(y);
			Board.battleshipCoord2[count3].setValue('+');
			Board.guessboard[x][y] = '+';
		}
		else if (aircraft == true)
		{
			Board.aircraft_carrierCoord2[count4].setX_coord(x);
			Board.aircraft_carrierCoord2[count4].setY_coord(y);
			Board.aircraft_carrierCoord2[count4].setValue('+');
			Board.guessboard[x][y] = '+';
		}
		else
		{
			Board.guessboard[x][y] = '-';
		}
		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		setScore(0);
		// To calculate Player's Score for every type of ships:
		for (int i = 0; i < Board.patrol_boat2.getSize(); i++)
		{
			if (Board.patrol_boatCoord2[i].getValue() == '+')
			{
				count1++;
			}
		}
		if (count1 == Board.patrol_boat2.getSize())
		{
			setScore(getScore() + count1 * 10 + 40);
		}
		else
	    {
			setScore(getScore() + count1 * 10);
		}
		for (int i = 0; i < Board.destroyer2.getSize(); i++)
		{
			if (Board.destroyerCoord2[i].getValue() == '+')
			{
				count2++;
			}
		}
		if (count2 == Board.destroyer2.getSize())
		{
			setScore(getScore() + count2 * 10 + 40);
		}
		else
		{
			setScore(getScore() + count2 * 10);
		}
		for (int i = 0; i < Board.battleship2.getSize(); i++)
		{
			if (Board.battleshipCoord2[i].getValue() == '+')
			{
				count3++;
			}
		}
		if (count3 == Board.battleship2.getSize())
		{
			setScore(getScore() + count3 * 10 + 40);
		}
		else
		{
			setScore(getScore() + count3 * 10);
		}
		for (int i = 0; i < Board.aircraft_carrier2.getSize(); i++)
		{
			if (Board.aircraft_carrierCoord2[i].getValue() == '+')
			{
				count4++;
			}
		}
		if (count4 == Board.aircraft_carrier2.getSize())
		{
			setScore(getScore() + count4 * 10 + 40);
		}
		else
		{
			setScore(getScore() + count4 * 10);
		}
	}
	
	private int x;
	private int y;

	public void computer_hit_score()
	{
		Random rnd = new Random();
		x = rnd.nextInt(8);
		y = rnd.nextInt(8);
		
		while (hit[x][y] == true)
		{
			x = rnd.nextInt(8);
			y = rnd.nextInt(8);
		}
		
		hit[x][y] = true;

		boolean patrol = false;
		boolean	destroyer = false;
		boolean	aircraft = false;
		boolean	battleship = false;
		int count1 = 0;
		int	count2 = 0;
		int	count3 = 0;
		int	count4 = 0;
		
		for (int i = 0; i < Board.patrol_boat.getSize(); i++)
		{
			if (Board.patrol_boatCoord[i].getX_coord() == x && Board.patrol_boatCoord[i].getY_coord() == y)
			{
				patrol = true;
				count1 = i;
				break;
			}
		}
		for (int j = 0; j < Board.destroyer.getSize(); j++)
		{
			if (Board.destroyerCoord[j].getX_coord() == x && Board.destroyerCoord[j].getY_coord() == y)
			{
				destroyer = true;
				count2 = j;
				break;
			}
		}
		for (int k = 0; k < Board.battleship.getSize(); k++)
		{
			if (Board.battleshipCoord[k].getX_coord() == x
					&& Board.battleshipCoord[k].getY_coord() == y)
			{
				battleship = true;
				count3 = k;
				break;
			}
		}
		for (int l = 0; l < Board.aircraft_carrier.getSize(); l++)
		{
			if (Board.aircraft_carrierCoord[l].getX_coord() == x && Board.aircraft_carrierCoord[l].getY_coord() == y)
			{
				aircraft = true;
				count4 = l;
				break;
			}
		}
		if (patrol == true)
		{
			Board.patrol_boatCoord[count1].setX_coord(x);
			Board.patrol_boatCoord[count1].setY_coord(y);
			Board.patrol_boatCoord[count1].setValue('+');
			Board.shipboard[x][y] = '+';
		}
		else if (destroyer == true)
		{
			Board.destroyerCoord[count2].setX_coord(x);
			Board.destroyerCoord[count2].setY_coord(y);
			Board.destroyerCoord[count2].setValue('+');
			Board.shipboard[x][y] = '+';
		}
		else if (battleship == true)
		{
			Board.battleshipCoord[count3].setX_coord(x);
			Board.battleshipCoord[count3].setY_coord(y);
			Board.battleshipCoord[count3].setValue('+');
			Board.shipboard[x][y] = '+';
		}
		else if (aircraft == true)
		{
			Board.aircraft_carrierCoord[count4].setX_coord(x);
			Board.aircraft_carrierCoord[count4].setY_coord(y);
			Board.aircraft_carrierCoord[count4].setValue('+');
			Board.shipboard[x][y] = '+';
		}
		else
		{
			Board.shipboard[x][y] = '-';
		}
		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		setScore(0);
		// ///////////////////// Calculating Computer's Score
		for (int i = 0; i < Board.patrol_boat.getSize(); i++)
		{
			if (Board.patrol_boatCoord[i].getValue() == '+') 
			{
				count1++;
			}
		}
		if (count1 == Board.patrol_boat.getSize())
		{
			setScore(getScore() + count1 * 10 + 40);
		}
		else
		{
			setScore(getScore() + count1 * 10);
		}

		// //////////////////////

		for (int i = 0; i < Board.destroyer.getSize(); i++) 
		{
			if (Board.destroyerCoord[i].getValue() == '+')
			{
				count2++;
			}
		}
		if (count2 == Board.destroyer.getSize())
		{
			setScore(getScore() + count2 * 10 + 40);
		}
		else
		{
			setScore(getScore() + count2 * 10);
		}

		// ////////////////////////

		for (int i = 0; i < Board.battleship.getSize(); i++)
		{
			if (Board.battleshipCoord[i].getValue() == '+')
			{
				count3++;
			}
		}
		if (count3 == Board.battleship.getSize())
		{
			setScore(getScore() + count3 * 10 + 40);
		}
		else
		{
			setScore(getScore() + count3 * 10);
		}

		// ///////////////////////////

		for (int i = 0; i < Board.aircraft_carrier.getSize(); i++) 
		{
			if (Board.aircraft_carrierCoord[i].getValue() == '+') 
			{
				count4++;
			}
		}
		if (count4 == Board.aircraft_carrier.getSize())
		{
			setScore(getScore() + count4 * 10 + 40);
		}
		else
		{
			setScore(getScore() + count4 * 10);
		}
	}
}

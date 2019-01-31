
import java.util.Scanner;
import java.awt.Color;
import enigma.console.TextAttributes;
import enigma.core.Enigma;
import java.util.*;

public class Board
{
	static TextAttributes green = new TextAttributes(Color.green, Color.blue);
	static TextAttributes blue = new TextAttributes(Color.blue, Color.green);
	TextAttributes yellow = new TextAttributes(Color.yellow, Color.red);
	static TextAttributes brown = new TextAttributes(Color.DARK_GRAY, Color.white);
			
	public static int x = 0;
	public static int y = 0;
	public static int direction;
	public static int round = 1;;
	public static char shipboard[][] = new char[9][9];
	public static char guessboard[][] = new char[9][9];

	public static BoardElement aircraft_carrierCoord[] = new BoardElement[5];
	public static BoardElement battleshipCoord[] = new BoardElement[4];
	public static BoardElement destroyerCoord[] = new BoardElement[3];
	public static BoardElement patrol_boatCoord[] = new BoardElement[2];

	public static BoardElement aircraft_carrierCoord2[] = new BoardElement[5];
	public static BoardElement battleshipCoord2[] = new BoardElement[4];
	public static BoardElement destroyerCoord2[] = new BoardElement[3];
	public static BoardElement patrol_boatCoord2[] = new BoardElement[2];
	
	public static Ship aircraft_carrier = new Ship("Aircraft Carrier", 5, aircraft_carrierCoord);
	public static Ship battleship = new Ship("Battleship", 4, battleshipCoord);
	public static Ship destroyer = new Ship("Destroyer", 3, destroyerCoord);
	public static Ship patrol_boat = new Ship("Patrol Boat", 2, destroyerCoord);

	public static Ship aircraft_carrier2 = new Ship("Aircraft Carrier", 5, aircraft_carrierCoord2);
	public static Ship battleship2 = new Ship("Battleship", 4, battleshipCoord2);
	public static Ship destroyer2 = new Ship("Destroyer", 3, destroyerCoord2);
	public static Ship patrol_boat2 = new Ship("Patrol Boat", 2, destroyerCoord2);
			
	enigma.console.Console cn = Enigma.getConsole("Board");

	public boolean flag = false;
	Scanner scn = new Scanner(System.in);

	public void board()
	{
		boolean flag = false;

		cn.getTextWindow().setCursorPosition(10, 2);
		cn.getTextWindow().output("Ship Board");
		cn.getTextWindow().setCursorPosition(35, 2);
		cn.getTextWindow().output("Guess Board");
		
		int a = 0, b = 0;
		
		for (int k = 0; k < 2; k++)
		{
			for (int i = 0; i < 11; i++)
			{
				for (int j = 0; j < 11; j++)
				{
					a = i + 10;
					b = j + 5;
					if (k == 1)
					{
						a += 25;
					}
					if (i + j == 20 || i - j == -10 || i - j == 10 || i + j == 0)
					{
						flag = true;
					}
					else
						flag = false;
					if (flag == true)
					{
						cn.getTextWindow().setCursorPosition(a, b);
						cn.getTextWindow().output("+", yellow);
					}
					else if ((flag == false && j == 0) || (flag == false && j == 10))
					{
						cn.getTextWindow().setCursorPosition(a, b);
						cn.getTextWindow().output("-", green);
					}
					else if ((flag == false && i == 0) || (flag == false && i == 10))
					{
						cn.getTextWindow().setCursorPosition(a, b);
						cn.getTextWindow().output("|", blue);
					}
				}
			}
		}

		cn.getTextWindow().setCursorPosition(55, 4);
		cn.getTextWindow().output("Round : " + round);
		cn.getTextWindow().setCursorPosition(55, 7);
		cn.getTextWindow().output("Score");
		cn.getTextWindow().setCursorPosition(55, 8);
		cn.getTextWindow().output("----------------- ", yellow);
		cn.getTextWindow().setCursorPosition(55, 9);
		cn.getTextWindow().output(Game.player.getName() + "   : " + Game.player.getScore());
		cn.getTextWindow().setCursorPosition(55, 10);
		cn.getTextWindow().output(Game.computer.getName() + " : " + Game.computer.getScore());
		cn.getTextWindow().setCursorPosition(4, 20);
		cn.getTextWindow().output("Human Target : ");

		char ch = '0';
		
		for (int i = 0; i < 9; i++)
		{
			cn.getTextWindow().setCursorPosition(9, i + 6);
			cn.getTextWindow().output(ch++);
		}

		cn.getTextWindow().setCursorPosition(11, 4);
		cn.getTextWindow().output("012345678");
		
		ch = '0';
		
		for (int i = 0; i < 9; i++)
		{
			cn.getTextWindow().setCursorPosition(34, i + 6);
			cn.getTextWindow().output(ch++);
		}

		cn.getTextWindow().setCursorPosition(36, 4);
		cn.getTextWindow().output("012345678");

		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				cn.getTextWindow().setCursorPosition(i + 11, j + 6);
				cn.getTextWindow().output(shipboard[i][j], brown);
			}
		}
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				cn.getTextWindow().setCursorPosition(i + 36, j + 6);
				cn.getTextWindow().output(guessboard[i][j], brown);
			}
		}
	}

	public void Generator()
	{
		Random rnd = new Random();
		while (flag == false)
		{
			x = rnd.nextInt(8);
			y = rnd.nextInt(8);
			for (int i = 0; i < 9; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (shipboard[x][y] == 'X')
					{
						flag = false;
						break;
					}
					else if (x + 1 < 9 && x - 1 > -1 && y + 1 < 9 && y - 1 > -1)
					{
						if (shipboard[x + 1][y] == 'X'
								|| shipboard[x - 1][y] == 'X'
								|| shipboard[x][y + 1] == 'X'
								|| shipboard[x][y - 1] == 'X'
								|| shipboard[x + 1][y + 1] == 'X'
								|| shipboard[x - 1][y - 1] == 'X'
								| shipboard[x + 1][y - 1] == 'X'
								| shipboard[x - 1][y + 1] == 'X') {
							flag = false;
							break;
						}
					}
					else
					{
						flag = true;

					}
				}
			}
		}
	}
// Random yerleþtirme kontrolü
	/*
	 * public void control(int size) { int a = x, b = y;
	 * 
	 * while (xplus == false && xminus == false && yplus == false && yminus ==
	 * false) { Generator(); if (x + 1 < 9) { for (int i = 0; i < size; i++) {
	 * 
	 * if (shipboard[x][y] != 'X' || shipboard[x - 1][y] != 'X' ||
	 * shipboard[x][y + 1] != 'X' || shipboard[x][y - 1] != 'X' || shipboard[x +
	 * 1][y + 1] != 'X' || shipboard[x - 1][y - 1] != 'X' || shipboard[x + 1][y
	 * - 1] != 'X' || shipboard[x - 1][y + 1] != 'X') { xplus = true; } else {
	 * x++; xplus = false; break; } } } if (x - 1 > -1) { for (int i = 0; i <
	 * size; i++) {
	 * 
	 * if (shipboard[x][y] != 'X' || shipboard[x - 1][y] != 'X' ||
	 * shipboard[x][y + 1] != 'X' || shipboard[x][y - 1] != 'X' || shipboard[x +
	 * 1][y + 1] != 'X' || shipboard[x - 1][y - 1] != 'X' || shipboard[x + 1][y
	 * - 1] != 'X' || shipboard[x - 1][y + 1] != 'X') { xminus = true; } else {
	 * x--; xminus = false; break; } } } if (y + 1 < 9) { for (int i = 0; i <
	 * size; i++) {
	 * 
	 * if (shipboard[x][y] != 'X' || shipboard[x - 1][y] != 'X' ||
	 * shipboard[x][y + 1] != 'X' || shipboard[x][y - 1] != 'X' || shipboard[x +
	 * 1][y + 1] != 'X' || shipboard[x - 1][y - 1] != 'X' || shipboard[x + 1][y
	 * - 1] != 'X' || shipboard[x - 1][y + 1] != 'X') { yplus = true; } else {
	 * y++; yplus = false; break; } } } if (y - 1 > -1) { for (int i = 0; i <
	 * size; i++) {
	 * 
	 * if (shipboard[x][y] != 'X' || shipboard[x - 1][y] != 'X' ||
	 * shipboard[x][y + 1] != 'X' || shipboard[x][y - 1] != 'X' || shipboard[x +
	 * 1][y + 1] != 'X' || shipboard[x - 1][y - 1] != 'X' || shipboard[x + 1][y
	 * - 1] != 'X' || shipboard[x - 1][y + 1] != 'X') { yminus = true; } else {
	 * y--; yminus = false; break; } } } }
	 * 
	 * }
	 */

	
	public void GuessBoardEstablisher()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				shipboard[i][j] = '.';
				guessboard[i][j] = '.';
			}
		}

		for (int i = 0; i < patrol_boatCoord2.length; i++)
		{
			patrol_boatCoord2[i] = new BoardElement(0, 0, ' ');
		}
		for (int i = 0; i < aircraft_carrierCoord2.length; i++)
		{
			aircraft_carrierCoord2[i] = new BoardElement(0, 0, ' ');
		}
		for (int i = 0; i < battleshipCoord2.length; i++)
		{
			battleshipCoord2[i] = new BoardElement(0, 0, ' ');
		}
		for (int i = 0; i < destroyerCoord2.length; i++)
		{
			destroyerCoord2[i] = new BoardElement(0, 0, ' ');
		}
		
		Random rnd = new Random();
		direction = rnd.nextInt(2);

		for (int i = 0; i < patrol_boat2.getSize(); i++)
		{
			patrol_boatCoord2[i].setX_coord(x);
			patrol_boatCoord2[i].setY_coord(y);
			patrol_boatCoord2[i].setValue('X');

			if (direction == 0)
			{
				if (y + patrol_boat2.getSize() < 9)
				{
					y++;
				}
				else
				{
					y--;
				}
			}

			if (direction == 1)
			{
				if (x + patrol_boat2.getSize() < 9)
				{
					x++;
				}
				else
				{
					x--;
				}
			}
		}

		x = 0;
		y = rnd.nextInt(1) + 4;
		direction = (direction + 1) % 2;

		for (int i = 0; i < aircraft_carrier2.getSize(); i++)
		{
			aircraft_carrierCoord2[i].setX_coord(x);
			aircraft_carrierCoord2[i].setY_coord(y);
			aircraft_carrierCoord2[i].setValue('X');

			if (direction == 0)
			{
				y++;
			}
			if (direction == 1)
			{
				x++;
			}
		}
		
		direction = (direction + 1) % 2;
		x = rnd.nextInt(2) + 6;
		y = rnd.nextInt(1);
		
		for (int i = 0; i < battleship2.getSize(); i++)
		{
			battleshipCoord2[i].setX_coord(x);
			battleshipCoord2[i].setY_coord(y);
			battleshipCoord2[i].setValue('X');

			if (direction == 0)
			{
				y++;
			}
			if (direction == 1)
			{
				x--;
			}
		}
		direction = (direction + 1) % 2;
		x = 8;
		y = rnd.nextInt(1) + 7;
		
		for (int i = 0; i < destroyer2.getSize(); i++)
		{
			destroyerCoord2[i].setX_coord(x);
			destroyerCoord2[i].setY_coord(y);
			destroyerCoord2[i].setValue('X');

			if (direction == 0)
			{
				y--;
			}
			if (direction == 1)
			{
				x--;
			}
		}
	}

	public void ShipBoardEstablisher()
	{
		for (int i = 0; i < patrol_boatCoord.length; i++)
		{
			patrol_boatCoord[i] = new BoardElement(0, 0, ' ');
		}
		for (int i = 0; i < aircraft_carrierCoord.length; i++)
		{
			aircraft_carrierCoord[i] = new BoardElement(0, 0, ' ');
		}
		for (int i = 0; i < battleshipCoord.length; i++)
		{
			battleshipCoord[i] = new BoardElement(0, 0, ' ');
		}
		for (int i = 0; i < destroyerCoord.length; i++)
		{
			destroyerCoord[i] = new BoardElement(0, 0, ' ');
		}
		
		int startx, starty, direction;
		
		for (int i = 2; i < 6; i++)
		{
			cn.getTextWindow().setCursorPosition(0, 21);
				cn.getTextWindow().output("Start_X:");
				startx = scn.nextInt();
				cn.getTextWindow().output("Start_Y:");
				starty = scn.nextInt();
				cn.getTextWindow().output("Right,Left,Down,Up(1,2,3,4): ");
				direction = scn.nextInt();
			
			if (i == 2)
			{
				for (int j = 0; j < i; j++)
				{
					shipboard[startx][starty] = 'X';
					patrol_boatCoord[j].setX_coord(startx);
					patrol_boatCoord[j].setY_coord(starty);
					patrol_boatCoord[j].setValue('X');

					if (direction == 1)
					{
						startx++;
					} else if (direction == 2)
					{
						startx--;
					} else if (direction == 3)
					{
						starty++;
					} else if (direction == 4)
					{
						starty--;
					}
				}
			}

			if (i == 3)
			{
				for (int j = 0; j < i; j++)
				{
					shipboard[startx][starty] = 'X';
					destroyerCoord[j].setX_coord(startx);
					destroyerCoord[j].setY_coord(starty);
					destroyerCoord[j].setValue('X');
					if (direction == 1)
					{
						startx++;
					}
					else if (direction == 2)
					{
						startx--;
					}
					else if (direction == 3)
					{
						starty++;
					}
					else if (direction == 4)
					{
						starty--;
					}
				}
			}

			if (i == 4)
			{
				for (int j = 0; j < i; j++)
				{
					shipboard[startx][starty] = 'X';
					battleshipCoord[j].setX_coord(startx);
					battleshipCoord[j].setY_coord(starty);
					battleshipCoord[j].setValue('X');
					
					if (direction == 1)
					{
						startx++;
					}
					else if (direction == 2) 
					{
						startx--;
					} 
					else if (direction == 3)
					{
						starty++;
					}
					else if (direction == 4)
					{
						starty--;
					}
				}
			}

			else if (i == 5)
			{
				for (int j = 0; j < i; j++)
				{
					shipboard[startx][starty] = 'X';
					aircraft_carrierCoord[j].setX_coord(startx);
					aircraft_carrierCoord[j].setY_coord(starty);
					aircraft_carrierCoord[j].setValue('X');
					
					if (direction == 1)
					{
						startx++;
					}
					else if (direction == 2)
					{
						startx--;
					}
					else if (direction == 3)
					{
						starty++;
					}
					else if (direction == 4)
					{
						starty--;
					}
				}
			}
			
			for (int j = 0; j < 4; j++)
			{
				cn.getTextWindow().setCursorPosition(0, j + 20);
				cn.getTextWindow().output("                               ");
			}
			board();
		}
	}
}

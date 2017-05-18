/**
 * @author thewrenchess
 */

import java.util.*;
import java.util.concurrent.TimeUnit;

public class	Controller {
	private int			size = 0;
	private Game		game = new Game();
	private Scanner		scan = new Scanner(System.in);

	private int			mainMenu() {
		while (size < 1 || size > 30) {
			System.out.print("Please enter an integer (between 1 and 30) representing the amount of disks you would like to play with, or 'exit' to exit ");
			String	input = scan.nextLine();
			if (input.equals("exit"))
				return 0;
			if (input.matches("[0-9]+"))
				size = Integer.parseInt(input);
			if (size < 1 || size > 30) {
				System.out.println("\n-----------------------------------------------------------");
				System.out.println("Please enter an integer between 1 and 30, or 'exit' to exit");
				System.out.println("-----------------------------------------------------------\n");
			}
		}
		return size;
	}
	private int			solutionOrGame() {
		int	loop = 1;
	
		System.out.println(	"\nEnter 'play' to play the Tower of Hanoi game," +
							"or enter 'solution' to see solution to current towers");
		while (loop == 1) {
			String	input = scan.nextLine();
			if (input.equals("play"))
				return 1;
			if (input.equals("solution"))
				return 2;
			System.out.println("\n----------------------------------------");
			System.out.println("Please enter either 'play' or 'solution'");
			System.out.println("----------------------------------------\n");
		}
		return 0;
	}
	
	public static void	main(String[] args) throws InterruptedException {
		Controller	c = new Controller();
		int			loop = 1, result;

		System.out.println("Welcome to the Towers of Hanoi game.\n");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("The goal of this game is to move the entire stack of disks from tower A to tower C.\n");
		TimeUnit.SECONDS.sleep(1);
		while (loop == 1) {
			result = c.mainMenu();
			if (result == 0) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Thank you for playing Tower of Hanoi.\nExiting...");
				return ;
			}
			result = c.solutionOrGame();
			if (result == 1) {
				c.game.menu(c.size);
			}else if (result == 2) {
				c.game.solution(c.size);
			}
			c.size = 0;
		}
	}

}

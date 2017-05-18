/**
 * @author thewrenchess
 */

import java.util.*;

public class	Controller {
	private int			size = 0;
	private Game			game = new Game();

	private int			mainMenu() {
		Scanner		scan = new Scanner(System.in);
		
		while (size < 1 || size > 30) {
			System.out.println("Welcome to the Towers of Hanoi game.");
			System.out.print("Please enter an integer (between 1 and 30) of disks you would like to play with, or 'exit' to exit ");
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

	public static void	main(String[] args) {
		Controller	c = new Controller();
		int			loop = 1;

		while (loop == 1) {
			if (c.mainMenu() == 0) {
				System.out.println("Exiting...");
				return ;
			}
			if (c.game.menu(c.size) == 0) {
				System.out.println("Exiting...");
				return ;
			}
		}
	}

}

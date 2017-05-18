/**
 * @author thewrenchess
 */

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {
	
	private Towers	towers;
	private Scanner	scan = new Scanner(System.in);
	
	private void	printrules() {
		System.out.println("\n\nGoal:");
		System.out.println("-You goal is to move the entire stack of disks from tower A to tower C.\n");
		System.out.println("\nRules:");
		System.out.println("-Only one disk can be moved at a time.");
		System.out.println("-Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack");
		System.out.println("-No disk may be placed on top of a smaller disk.");
	}
	
	private int		getChoice() {
		int		choice = 0;
		
		while (choice < 1 || choice > 3) {
			System.out.println("\nWhat would you like to do next?");
			int i = 1;
			if (towers.towerA.size() == 0) {
				System.out.println("(" + i + ")Move disk from B to A");
				i++;
			} else if (towers.towerB.size() == 0) {
				System.out.println("(" + i + ")Move disk from A to B");
				i++;
			} else if (towers.towerA.get(towers.towerA.size() - 1).length() > towers.towerB.get(towers.towerB.size() - 1).length()) {
				System.out.println("(" + i + ")Move disk from B to A");
				i++;
			} else if (towers.towerA.get(towers.towerA.size() - 1).length() < towers.towerB.get(towers.towerB.size() - 1).length()) {
				System.out.println("(" + i + ")Move disk from A to B");
				i++;
			}
			if (towers.towerA.size() == 0 && towers.towerC.size() == 0) {
			} else if (towers.towerA.size() == 0 && towers.towerC.size() != 0) {
				System.out.println("(" + i + ")Move disk from C to A");
				i++;
			} else if (towers.towerC.size() == 0 && towers.towerA.size() != 0) {
				System.out.println("(" + i + ")Move disk from A to C");
				i++;
			} else if (towers.towerA.get(towers.towerA.size() - 1).length() > towers.towerC.get(towers.towerC.size() - 1).length()) {
				System.out.println("(" + i + ")Move disk from C to A");
				i++;
			} else if (towers.towerA.get(towers.towerA.size() - 1).length() < towers.towerC.get(towers.towerC.size() - 1).length()) {
				System.out.println("(" + i + ")Move disk from A to C");
				i++;
			}
			if (towers.towerB.size() == 0 && towers.towerC.size() == 0) {
			} else if (towers.towerB.size() == 0 && towers.towerC.size() != 0) {
				System.out.println("(" + i + ")Move disk from C to B");
			} else if (towers.towerC.size() == 0 && towers.towerB.size() != 0) {
				System.out.println("(" + i + ")Move disk from B to C");
			} else if (towers.towerB.get(towers.towerB.size() - 1).length() > towers.towerC.get(towers.towerC.size() - 1).length()) {
				System.out.println("(" + i + ")Move disk from C to B");
			} else if (towers.towerB.get(towers.towerB.size() - 1).length() < towers.towerC.get(towers.towerC.size() - 1).length()) {
				System.out.println("(" + i + ")Move disk from B to C");
			}
			System.out.println("Enter the integer representing move, 'rules' to see rules, 'restart' to restart the game, 'exit' to exit");
			String	input = scan.nextLine();
			if (input.equals("exit"))
				return 0;
			if (input.equals("restart"))
				return -1;
			if (input.equals("rules"))
				return -2;
			if (input.matches("[0-9]+"))
				choice = Integer.parseInt(input);
			if (choice < 1 || choice > 3) {
				System.out.println("\n--------------------------------------------");
				System.out.println("Please enter an 1, 2, 3, 'exit' or 'restart'");
				System.out.println("--------------------------------------------\n");
			}
		}
		return choice;
	}
	
	private void	solveEven() throws InterruptedException {
		if (towers.towerA.size() == 0 && towers.towerB.size() == 0)
			return ;
		
		towers.moveBetweenAAndB();
		towers.printTowers();
		System.out.println();
		TimeUnit.SECONDS.sleep(2);
		if (towers.towerA.size() == 0 && towers.towerB.size() == 0)
			return ;
		towers.moveBetweenAAndC();
		towers.printTowers();
		System.out.println();
		TimeUnit.SECONDS.sleep(2);
		if (towers.towerA.size() == 0 && towers.towerB.size() == 0)
			return ;
		towers.moveBetweenBAndC();
		towers.printTowers();
		System.out.println();
		TimeUnit.SECONDS.sleep(2);
		if (towers.towerA.size() == 0 && towers.towerB.size() == 0)
			return ;
		solveEven();
	}
	
	private void solveOdd() throws InterruptedException {
		towers.moveBetweenAAndC();
		towers.printTowers();
		System.out.println();
		TimeUnit.SECONDS.sleep(2);
		if (towers.towerA.size() == 0 && towers.towerB.size() == 0)
			return ;
		towers.moveBetweenAAndB();
		towers.printTowers();
		System.out.println();
		TimeUnit.SECONDS.sleep(2);
		if (towers.towerA.size() == 0 && towers.towerB.size() == 0)
			return ;
		towers.moveBetweenBAndC();
		towers.printTowers();
		System.out.println();
		TimeUnit.SECONDS.sleep(2);
		if (towers.towerA.size() == 0 && towers.towerB.size() == 0)
			return ;
		solveOdd();
	}
	
	public void		solution(int size) throws InterruptedException {
		String	input;
		
		System.out.println("Would you like to see the solution?(y/n)");
		input = scan.nextLine();
		if (input.equals("y")) {
			towers = new Towers(size);
			towers.printTowers();
			System.out.println();
			TimeUnit.SECONDS.sleep(2);
			if (size % 2 == 0)
				solveEven();
			else
				solveOdd();
		}
	}
	
	public void		menu(int size) throws InterruptedException {
		towers = new Towers(size);
		int	loop = 1, choice;
		
		System.out.println("Settint up new Towers...");
		TimeUnit.SECONDS.sleep(1);
		while (loop > 0) {
			if (loop < 2) {
				TimeUnit.SECONDS.sleep(1);
				printrules();
				TimeUnit.SECONDS.sleep(1);
				loop++;
			}
			System.out.println();
			towers.printTowers();
			System.out.println();
			choice = getChoice();
			if (choice == -1) {
				System.out.println("Settint up new Towers...");
				towers = new Towers(size);
			} else if (choice == -2) {
				loop--;
			} else if (choice == 1) {
				towers.moveBetweenAAndB();
			} else if (choice == 2) {
				towers.moveBetweenAAndC();
			} else if (choice == 3) {
				towers.moveBetweenBAndC();
			}
			if (choice == 0)
				return ;
			if (towers.towerA.size() == 0 && towers.towerB.size() == 0)
				loop = 0;
		}
		System.out.println();
		towers.printTowers();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(	"\nSuccessful! You used "
							+ towers.steps
							+ " steps, and ideally it takes only "
							+ (int)(Math.pow(2, size) - 1)
							+ " steps.\n");
		System.out.println();
		TimeUnit.SECONDS.sleep(1);
		solution(size);
		System.out.println();
	}
}

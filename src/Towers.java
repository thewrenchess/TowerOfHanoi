/**
 * @author thewrenchess
 */

import java.util.*;

public class	Towers {
	List<String>	towerA, towerB, towerC;
	int				size, steps;
	
	public			Towers(int size) {
		this.towerA = new ArrayList<>();
		this.towerB = new ArrayList<>();
		this.towerC = new ArrayList<>();
		this.size = size;
		this.steps = 0;
		String	result;
		int		i, j;
		
		for (i = 0; i < size; i++) {
			result = new String();
			for (j = 0; j < size - i; j++) {
				result += "|";
			}
			result += Integer.toString(size - i);
			for (j = 0; j < size - i; j++) {
				result += "|";
			}
			towerA.add(new String(result));
		}
	}

	public void		moveBetweenAAndB() {
		if (towerA.size() == 0) {
			towerA.add(new String(towerB.get(towerB.size() - 1)));
			towerB.remove(towerB.size() - 1);
		} else if (towerB.size() == 0) {
			towerB.add(new String(towerA.get(towerA.size() - 1)));
			towerA.remove(towerA.size() - 1);
		} else if (towerA.get(towerA.size() - 1).length() > towerB.get(towerB.size() - 1).length()) {
			towerA.add(new String(towerB.get(towerB.size() - 1)));
			towerB.remove(towerB.size() - 1);
		} else if (towerA.get(towerA.size() - 1).length() < towerB.get(towerB.size() - 1).length()) {
			towerB.add(new String(towerA.get(towerA.size() - 1)));
			towerA.remove(towerA.size() - 1);
		}
		steps++;
	}
	
	public void		moveBetweenAAndC() {
		if (towerA.size() == 0 && towerC.size() == 0) {
			System.out.println("There is nothing in A and C");
			return ;
		}
		if (towerA.size() == 0) {
			towerA.add(new String(towerC.get(towerC.size() - 1)));
			towerC.remove(towerC.size() - 1);
		} else if (towerC.size() == 0) {
			towerC.add(new String(towerA.get(towerA.size() - 1)));
			towerA.remove(towerA.size() - 1);
		} else if (towerA.get(towerA.size() - 1).length() > towerC.get(towerC.size() - 1).length()) {
			towerA.add(new String(towerC.get(towerC.size() - 1)));
			towerC.remove(towerC.size() - 1);
		} else if (towerA.get(towerA.size() - 1).length() < towerC.get(towerC.size() - 1).length()) {
			towerC.add(new String(towerA.get(towerA.size() - 1)));
			towerA.remove(towerA.size() - 1);
		}
		steps++;
	}
	
	public void		moveBetweenBAndC() {
		if (towerB.size() == 0 && towerC.size() == 0) {
			System.out.println("There is nothing in B and C");
			return ;
		}
		if (towerB.size() == 0) {
			towerB.add(new String(towerC.get(towerC.size() - 1)));
			towerC.remove(towerC.size() - 1);
		} else if (towerC.size() == 0) {
			towerC.add(new String(towerB.get(towerB.size() - 1)));
			towerB.remove(towerB.size() - 1);
		} else if (towerC.get(towerC.size() - 1).length() > towerB.get(towerB.size() - 1).length()) {
			towerC.add(new String(towerB.get(towerB.size() - 1)));
			towerB.remove(towerB.size() - 1);
		} else if (towerC.get(towerC.size() - 1).length() < towerB.get(towerB.size() - 1).length()) {
			towerB.add(new String(towerC.get(towerC.size() - 1)));
			towerC.remove(towerC.size() - 1);
		}
		steps++;
	}
	
	private void	printTower(List<String> tower, int towerWidth) {
		int	i;
		
		for (i = 0; i < (towerWidth - tower.get(tower.size() - 1).length()) / 2; i++)
			System.out.print(" ");
		System.out.print(tower.get(tower.size() - 1));
		for (i += tower.get(tower.size() - 1).length(); i < towerWidth; i++)
			System.out.print(" ");
	}
	
	private void	printTowerName(String towerName, int towerWidth) {
		int	i;
		
		for (i = 0; i < (towerWidth - towerName.length()) / 2; i++)
			System.out.print(" ");
		System.out.print(towerName);
		for (i += towerName.length(); i < towerWidth; i++)
			System.out.print(" ");
	}
	
	public void		printTowers() {
		List<String>	tmpA = new ArrayList<>(towerA),
						tmpB = new ArrayList<>(towerB),
						tmpC = new ArrayList<>(towerC);
		int				towerWidth = Math.max(9, size * 2 + 3), topDeck = Math.max(tmpA.size(), tmpB.size());
		
		topDeck = Math.max(topDeck, tmpC.size());
		System.out.println("STEP: " + steps + '\n');
		while (topDeck > 0) {
			if (topDeck == tmpA.size()) {
				printTower(tmpA, towerWidth);
				tmpA.remove(tmpA.size() - 1);
			} else {
				for (int i = 0; i < towerWidth; i++)
					System.out.print(" ");
			}
			if (topDeck == tmpB.size()) {
				printTower(tmpB, towerWidth);
				tmpB.remove(tmpB.size() - 1);
			} else {
				for (int i = 0; i < towerWidth; i++)
					System.out.print(" ");
			}
			if (topDeck == tmpC.size()) {
				printTower(tmpC, towerWidth);
				tmpC.remove(tmpC.size() - 1);
			}
			System.out.println();
			topDeck--;
		}
		printTowerName("Tower A", towerWidth);
		printTowerName("Tower B", towerWidth);
		printTowerName("Tower C", towerWidth);
		System.out.println();
	}
}

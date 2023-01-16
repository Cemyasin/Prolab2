package proLab2;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player {

	Object[] nesneler = new Object[] { new Rock(20, 0, 2), new Paper(20, 0, 2), new Scissors(20, 0, 2) };

	public Computer() {
		super();
	}

	public Computer(int playerID, String playerName, int score, ArrayList<Object> objectList) {
		super(playerID, playerName, score, objectList);
		playerName = "Computer";
	}

	@Override
	public int showScore() {
		return getScore();

	}

	ArrayList<Object> updateListComputer = new ArrayList<>();

	@Override
	public ArrayList<Object> selectObject() {
		// Random atama yapmalı
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			int rn = rnd.nextInt(3);

			if (rn == 0) {
				objectList.add(new Rock());
				updateListComputer.add(new HeavyRock(20, 0, 2, 2));
			}else if (rn == 1) {
				objectList.add(new Paper());
				updateListComputer.add(new SpecialPaper(20, 0, 2, 2));
			} else if (rn == 2) {
				objectList.add(new Scissors());
				updateListComputer.add(new MasterScissors(20, 0, 2, 2));
			}
		}

		// objectList.get(rnd.nextInt(5));
		return objectList;

	}

}

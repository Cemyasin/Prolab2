package proLab2;

import java.util.ArrayList;

public class User extends Player{

	public User() {
		super();
	}

	public User(int playerID, String playerName, int score, ArrayList<Object> objectList) {
		super(playerID, playerName, score, objectList);
	}


	@Override
	public int showScore() {
		
		return getScore();
	}

	@Override
	public ArrayList<Object> selectObject() {
		return objectList;
		
	}
	//ArrayList<Nesne> objects= new ArrayList<>();


}

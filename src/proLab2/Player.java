package proLab2;

import java.util.ArrayList;

public abstract class Player {
	

	public abstract int showScore();
	public abstract ArrayList<Object> selectObject();

	
	public Player() {
		super();
	}

	public Player(int playerID, String playerName, int score, ArrayList<Object> objectList) {
		super();
		this.playerID = playerID;
		this.playerName = playerName;
		this.score = score;
		this.objectList = objectList;
	}

	private int playerID;
	private String playerName;
	private int score=0;
	public ArrayList<Object> objectList= new ArrayList<>();

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	

}

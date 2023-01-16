package proLab2;

public abstract class Object {

	public abstract String showObjectScore();

	public abstract double calculateEffect(HeavyRock rock, MasterScissors scissors, SpecialPaper paper);

	public abstract void statusUpdate();

	public Object() {
		super();
	}

	
	public Object(double durability, double levelScore) {
		this.durability = durability;
		this.levelScore = levelScore;
	}

	private double durability = 20; // dayanıklılık
	private double levelScore = 0; // seviye puanı

	public double getDurability() {
		return durability;
	}

	public void setDurability(double durability) {
		this.durability = durability;
	}

	public double getLevelScore() {
		return levelScore;
	}

	public void setLevelScore(double levelScore) {
		this.levelScore = levelScore;
	}

}

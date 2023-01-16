package proLab2;

public class HeavyRock extends Rock {

	public HeavyRock(double durability, double levelScore, double rigidity, double temperature) {
		super(durability, levelScore, rigidity);
		this.temperature = temperature;
	}

	public HeavyRock(double durability, double levelScore, double rigidity) {
		super(durability, levelScore, rigidity);
	}

	public HeavyRock() {
		super();
	}

	private double temperature;
	double rockEffect;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String showObjectScore() {
		//System.out.println("Dayniklilik : " + this.getDurability());
		//System.out.println("Level Score : " + this.getLevelScore());
		return "<html><br/>&emsp;Ağır Taş Dayanıklılık"  + this.getDurability() +
				"<br/>&emsp;Seviye Puanı: "+this.getLevelScore()+"<br/>&ensp;&nbsp;</html>";
		}

	@Override
	public double calculateEffect(HeavyRock rock, MasterScissors scissors, SpecialPaper paper) {
		double a = 0.2;
		 rockEffect = (this.getRigdity() * this.getTemperature()) / (((1 - a) * paper.getInfluence() * paper.getThickness())
				+ (a * scissors.getSharpness() * scissors.getResistance()));
		System.out.println("Agir tas etkisi hesaplandi : " + rockEffect);
		return rockEffect;
	}

	@Override
	public void statusUpdate() {
		//this.setDurability(this.getDurability() - rockEffect);
		System.out.println("Agir Tas Yeni dayaniklilik : " + this.getDurability());
	}

}

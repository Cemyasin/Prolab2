package proLab2;

public class Scissors extends Object {

	public Scissors() {
	}

	public Scissors(double durability, double levelScore, double sharpness) {
		super(durability, levelScore);
		this.sharpness = sharpness;
	}


	private double sharpness=2; // keskinlik
	double scissorsEffect;

	public double getSharpness() {
		return sharpness;
	}

	public void setSharpness(double sharpness) {
		this.sharpness = sharpness;
	}

	@Override
	public String showObjectScore() {
		// System.out.println("Dayniklilik : " + this.getDurability());
		// System.out.println("Level Score : " + this.getLevelScore());
		return "<html><br/>&emsp; Makas Dayanıklılık:"  + this.getDurability() +
				 "<br/>&emsp;Seviye Puanı: "+this.getLevelScore()+"<br/>&ensp;&nbsp;</html>";
	}

	@Override
	public double calculateEffect(HeavyRock rock, MasterScissors scissors, SpecialPaper paper) {
		double a = 0.2;
		scissorsEffect = this.getSharpness() / ((a * paper.getInfluence() * paper.getThickness())
				+ ((1 - a) * rock.getRigdity() * rock.getTemperature()));
		System.out.println("Makas etkisi hesaplandi : " + scissorsEffect);
		return scissorsEffect;
	}

	@Override
	public void statusUpdate() {
		// this.setDurability(this.getDurability() - scissorsEffect);
		System.out.println("Makas Yeni dayaniklilik : " + this.getDurability());
	}

}

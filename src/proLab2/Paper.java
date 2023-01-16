package proLab2;

public class Paper extends Object {

	public Paper() {

	}

	public Paper(double durability, double levelScore, double influence) {
		super(durability, levelScore);
		this.influence = influence;
	}

	public double getInfluence() {
		return influence;
	}

	public void setInfluence(double influence) {
		this.influence = influence;
	}

	
	private double influence=2; // nüfuz
	double paperEffect;

	@Override
	public String showObjectScore() {
		// System.out.println("Kagit Dayniklilik : " + this.getDurability()+" Kagit
		// Level Score : " + this.getLevelScore());
		return "<html><br/>&emsp; Kağıt Dayanıklılık:"  + this.getDurability() +
				 "<br/>&emsp;Seviye Puanı: "+this.getLevelScore()+"<br/>&ensp;&nbsp;</html>";
	}

	@Override
	public double calculateEffect(HeavyRock rock, MasterScissors scissors, SpecialPaper paper) {
		double a = 0.2;
		paperEffect = this.getInfluence() / ((a * rock.getRigdity() * rock.getTemperature())
				+ ((1 - a) * (scissors.getSharpness() * scissors.getResistance())));
		System.out.println("Kagit etkisi hesaplandi : " + paperEffect);
		return paperEffect;
	}

	@Override
	public void statusUpdate() {
		// this.setDurability(this.getDurability() - paperEffect);
		System.out.println("Kagit Yeni dayaniklilik : " + this.getDurability());
	}

}

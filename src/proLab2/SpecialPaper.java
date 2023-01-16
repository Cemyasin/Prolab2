package proLab2;

public class SpecialPaper extends Paper {

	

	private double thickness; // kalınlık
	double paperEffect;

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	public SpecialPaper(double durability, double levelScore, double influence,double thickness) {
		super(durability, levelScore,influence);
		this.thickness = thickness;
	}

	public SpecialPaper() {

	}

	public SpecialPaper(double durability, double levelScore, double influence) {
		super(durability, levelScore,influence);
	}

	@Override
	public String showObjectScore() {
		//System.out.println("Dayniklilik : " + this.getDurability());
		//System.out.println("Level Score : " + this.getLevelScore());
		return "<html><br/>&emsp;Özel Kağıt Dayanıklılık"  + this.getDurability() +
				"<br/>&emsp;Seviye Puanı: "+this.getLevelScore()+"<br/>&ensp;&nbsp;</html>";
	}

	@Override
	public double calculateEffect(HeavyRock rock, MasterScissors scissors, SpecialPaper paper) {
		double a = 0.2;
		 paperEffect = (this.getInfluence() * this.getThickness()) / ((a * rock.getRigdity() * rock.getTemperature())
				+ ((1 - a) * (scissors.getSharpness() * scissors.getResistance())));
		System.out.println("Ozel Kagit etkisi hesaplandi : " + paperEffect);
		return paperEffect;
	}

	@Override
	public void statusUpdate() {
		//this.setDurability(this.getDurability() - paperEffect);
		System.out.println("Ozel Kagit Yeni dayaniklilik : " + this.getDurability());
	}

}

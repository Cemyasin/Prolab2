package proLab2;

public class Rock extends Object {

	public Rock() {
		super();
	}

	public Rock(double durability, double levelScore, double rigidity) {
		super(durability, levelScore);
		this.rigidity = rigidity;
	}

	double rockEffect;

	@Override
	public String showObjectScore() {
	//	System.out.println("Tas Dayniklilik : " + this.getDurability() + " Tas Level Score : " + this.getLevelScore());
		return"<html><br/>&emsp; Taş Dayanıklılık:"  + this.getDurability() +
				 "<br/>&emsp;Seviye Puanı: "+this.getLevelScore()+"<br/>&ensp;&nbsp;</html>";
	}

	@Override
	public double calculateEffect(HeavyRock rock, MasterScissors scissors, SpecialPaper paper) {
		double a = 0.2;

		rockEffect = (this.getRigdity()) / (((1 - a) * paper.getInfluence() * paper.getThickness())
				+ (a * scissors.getSharpness() * scissors.getResistance()));

		System.out.println("Tas etkisi hesaplandi : " + rockEffect);
		return rockEffect;
	}

	@Override
	public void statusUpdate() {
		//this.setDurability(this.getDurability() - rockEffect);
		
		System.out.println("Tas Yeni dayaniklilik : " + this.getDurability());
	}
	

	
	double rigidity=2; // katılık

	public double getRigdity() {
		return rigidity;
	}

	public void setRigidity(double rigidity) {
		this.rigidity = rigidity;
	}

}

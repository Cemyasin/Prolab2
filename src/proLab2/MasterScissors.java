package proLab2;

public class MasterScissors extends Scissors {

	

	public MasterScissors() {

	}

	public MasterScissors(double durability, double levelScore,double sharpness) {
		super(durability, levelScore, sharpness);
	}

	public MasterScissors(double durability, double levelScore,double sharpness,double resistance) {
		super(durability, levelScore, sharpness);
		this.resistance = resistance;
	}

	private double resistance; // direnç
	double scissorsEffect;

	public double getResistance() {
		return resistance;
	}

	public void setResistance(double resistance) {
		this.resistance = resistance;
	}

	@Override
	public String showObjectScore() {
	//	 System.out.println("Dayniklilik : " + this.getDurability());
		//System.out.println("Level Score : " + this.getLevelScore());
		return "<html><br/>&emsp;Usta Makas Dayanıklılık"  + this.getDurability() +
			"<br/>&emsp;Seviye Puanı: "+this.getLevelScore()+"<br/>&ensp;&nbsp;</html>";
	}

	@Override
	public double calculateEffect(HeavyRock rock, MasterScissors scissors, SpecialPaper paper) {
		double a = 0.2;
		 scissorsEffect = (this.getSharpness() * this.getResistance()) / ((a * paper.getInfluence() * paper.getThickness())
				+ ((1 - a) * rock.getRigdity() * rock.getTemperature()));
		System.out.println("Usta Makas etkisi hesaplandi : " + scissorsEffect);
		return scissorsEffect;
	}

	@Override
	public void statusUpdate() {
		//this.setDurability(this.getDurability() - scissorsEffect);
		System.out.println("Usta Makas Yeni dayaniklilik : " + this.getDurability());
	}

}

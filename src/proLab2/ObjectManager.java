package proLab2;

public class ObjectManager {
	private Object nesne;
	Object nesne1;
	HeavyRock rock;	
	SpecialPaper paper;	
	MasterScissors scissors;
	double effect1;
	double effect2;

	public ObjectManager(Object nesne, Object nesne1) {
		this.nesne = nesne;
		this.nesne1 = nesne1;
	}



	public void calculate(HeavyRock rock, MasterScissors scissors, SpecialPaper paper) {
		
		this.rock=rock;
		this.paper=paper;
		this.scissors=scissors;
		
		if ((nesne.toString().contains("Rock") || nesne1.toString().contains("Rock"))
				&& (nesne.toString().contains("Paper") || nesne1.toString().contains("Paper"))) {
			scissors.setSharpness(0);
			scissors.setResistance(1);
			
		} else if ((nesne.toString().contains("Rock") || nesne1.toString().contains("Rock"))
				&& (nesne.toString().contains("Scissors") || nesne1.toString().contains("Scissors"))) {
			paper.setInfluence(0);
			paper.setThickness(1);
		} else if ((nesne.toString().contains("Paper") || nesne1.toString().contains("Paper"))
				&& (nesne.toString().contains("Scissors") || nesne1.toString().contains("Scissors"))) {
			rock.setRigidity(0);
			rock.setTemperature(1);
		}
		
			effect1 = nesne.calculateEffect(rock, scissors, paper);
			effect2 = nesne1.calculateEffect(rock, scissors, paper);
		
		
	

	}

	public String update(Player user,Player computer) {
		nesne.setDurability(nesne.getDurability() - effect2);
		nesne1.setDurability(nesne1.getDurability() - effect1);
		nesne.statusUpdate();
		nesne1.statusUpdate();

		if (effect1 > effect2) {
			nesne.setLevelScore(nesne.getLevelScore() + 20);
			user.setScore(user.getScore() + 1);
		} else if(effect2>effect1) {
			nesne1.setLevelScore(nesne1.getLevelScore() + 20);
			computer.setScore(computer.getScore() + 1);
		}else {
			
		}
		
		if (nesne.getLevelScore() > 30) {
			if (nesne.toString().contains("Rock")) {
				rock.setTemperature(2);
				System.out.println(" Agir tas geldi");
			} else if (nesne.toString().contains("Paper")) {
				paper.setThickness(2);
				System.out.println(" Ozel kagit geldi");
			} else if (nesne.toString().contains("Scissors")) {
				scissors.setResistance(2);
				System.out.println(" Usta makas geldi");
			}
		}
		
		if (nesne1.getLevelScore() > 30) {
			if (nesne1.toString().contains("Rock")) {
				rock.setTemperature(2);
				System.out.println("Pc Agir tas geldi");
			} else if (nesne1.toString().contains("Paper")) {
				paper.setThickness(2);
				System.out.println("Pc Ozel kagit geldi");
			} else if (nesne1.toString().contains("Scissors")) {
				scissors.setResistance(2);
				System.out.println("Pc Usta makas geldi");
			}
		}

		return user.showScore() + " -- Computer1: " + computer.showScore();
	}

	public String showScore(Object nes) {
		return nes.showObjectScore();
	}




}

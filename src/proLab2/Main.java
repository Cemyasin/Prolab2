package proLab2;

import java.awt.Color; 
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main implements Runnable {

	static String ss;
	static Thread thread;
	static int sayi = 0;
	static double sum = 0;
	static double sum1 = 0;
	static String win;
	static int counter = 0;
	public static int totalCounter = 0;
	public static int totalCounter2 = 5;
	public static int rockCounter = 0;
	public static int paperCounter = 0;
	public static int scissorsCounter = 0;
	static String[] buttonName = new String[5];
	public static int[] computerSelections = new int[5];
	static Object userObject;
	static Object computerObject;
	static Object computerObject2;
	static ObjectManager objectManager;
	static ArrayList<Object> updateList = new ArrayList<>();
	static Computer computer = new Computer();
	static Computer computer2 = new Computer();
	static User user = new User();
	static JLabel lblScore = new JLabel();
	static JLabel lblObj2 = new JLabel();
	static JLabel lblObj1 = new JLabel();
	static JOptionPane pane = new JOptionPane();

	public static void main(String[] args) {

		System.out.println("\n\n");
		JOptionPane pane = new JOptionPane();
		String s = pane.showInputDialog("Lutfen Hamle sayisini giriniz:");
		sayi = Integer.parseInt(s);
		System.out.println("girilen sayi: " + sayi);
		JFrame frm = new JFrame("Hamle Secimi");
		frm.setSize(800, 800);
		JFrame frm1 = new JFrame("Secim Yap");
		frm1.setSize(400, 400);
		JFrame userVsPc = new JFrame("Kullanici-Bilgisayar");
		userVsPc.setSize(350, 178);
		JFrame frmGameOn = new JFrame("Tas-Kagit-Makas");
		frmGameOn.setSize(1000, 700);
		
		Main main =new Main();
		JLabel lblBack = new JLabel();
		Image img = new ImageIcon(main.getClass().getResource("/peakss.jpg")).getImage();
		frmGameOn.setContentPane(lblBack);
		lblBack.setBounds(0,0,1000,700);
//		lblBack.setText("text yazıyor mu?");
		lblBack.setIcon(new ImageIcon(img));
		lblBack.setVisible(true);
//		frmGameOn.add(lblBack);
		
		lblObj1.setBounds(50, 100, 300, 50);
		lblObj1.setFont(new Font(null, Font.BOLD, 18));
		lblObj1.setForeground(Color.white);
		lblObj1.setOpaque(false);

		lblObj2.setBounds(350, 100, 300, 50);
		lblObj2.setForeground(Color.WHITE);
		lblObj2.setFont(new Font(null, Font.BOLD, 18));
		lblObj2.setOpaque(false);

		JLabel lblWin = new JLabel();
		lblWin.setBounds(200, 300, 400, 50);

		lblScore.setBounds(150, 250, 400, 100);
		lblScore.setOpaque(false);
		lblScore.setForeground(Color.RED);
		lblScore.setFont(new Font("Verdana",Font.ROMAN_BASELINE,22));

		JButton btnRock = new JButton("TAŞ");
		btnRock.setBounds(10, 10, 100, 50);
		userVsPc.add(btnRock);
		
		JButton btnRockPlus = new JButton("+");
		btnRockPlus.setBounds(15,65,45,20);
		userVsPc.add(btnRockPlus);
		
		JButton btnRockMinus = new JButton("-");
		btnRockMinus.setBounds(60,65,45,20);
		userVsPc.add(btnRockMinus);

		JButton btnPaper = new JButton("KAĞIT");
		btnPaper.setBounds(125, 10, 100, 50);
		userVsPc.add(btnPaper);
		
		JButton btnPaperPlus = new JButton("+");
		btnPaperPlus.setBounds(130,65,45,20);
		userVsPc.add(btnPaperPlus);
		
		JButton btnPaperMinus = new JButton("-");
		btnPaperMinus.setBounds(175,65,45,20);
		userVsPc.add(btnPaperMinus);
		
		JButton btnScissors = new JButton("MAKAS");
		btnScissors.setBounds(240, 10, 100, 50);
		userVsPc.add(btnScissors);
		
		JButton btnScissorsPlus = new JButton("+");
		btnScissorsPlus.setBounds(245,65,45,20);
		userVsPc.add(btnScissorsPlus);
		
		JButton btnScissorsMinus = new JButton("-");
		btnScissorsMinus.setBounds(290,65,45,20);
		userVsPc.add(btnScissorsMinus);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setBounds(125, 92, 100, 50);
		userVsPc.add(btnPlay);

		JButton btnComputer = new JButton("BİLGİSAYAR - BİLGİSAYAR");
		btnComputer.setBounds(75, 200, 250, 50);
		frm1.add(btnComputer);

		JButton btnUser = new JButton("KULLANICI - BİLGİSAYAR");
		btnUser.setBounds(75, 100, 250, 50);
		frm1.add(btnUser);

		JButton btnObj1 = new JButton("");
		btnObj1.setBounds(75, 25, 110, 50);
		frmGameOn.add(btnObj1);
		
		JButton btnObj2 = new JButton("");
		btnObj2.setBounds(260, 25, 110, 50);
		frmGameOn.add(btnObj2);

		JButton btnObj3 = new JButton("");
		btnObj3.setBounds(445, 25, 110, 50);
		frmGameOn.add(btnObj3);

		JButton btnObj4 = new JButton("");
		btnObj4.setBounds(630, 25, 110, 50);
		frmGameOn.add(btnObj4);

		JButton btnObj5 = new JButton("");
		btnObj5.setBounds(815, 25, 110, 50);
		frmGameOn.add(btnObj5);

		ss="Dayanılık:20 Score:0.0";

		JButton[] buttons = new JButton[] { btnObj1, btnObj2, btnObj3, btnObj4, btnObj5 };

		btnUser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				userVsPc.setVisible(true);
				btnPlay.setEnabled(false);
				btnRockMinus.setEnabled(false);
				btnPaperMinus.setEnabled(false);
				btnScissorsMinus.setEnabled(false);
				frm1.setVisible(false);
			}
		});

		btnRock.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});	
		btnRockPlus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				rockCounter++;
				if((rockCounter + paperCounter + scissorsCounter) == 5) {
					btnRockPlus.setEnabled(false);
					btnPaperPlus.setEnabled(false);
					btnScissorsPlus.setEnabled(false);
					btnPlay.setEnabled(true);
				}
				else {
//					btnRockMinus.setEnabled(true);
//					btnPaperMinus.setEnabled(true);
//					btnScissorsMinus.setEnabled(true);
				}
				
				if(rockCounter == 0) {
					btnRockMinus.setEnabled(false);
				}
				else
				{
					btnRockMinus.setEnabled(true);
				}
				if(paperCounter == 0) {
					btnPaperMinus.setEnabled(false);
				}
				else
				{
					btnPaperMinus.setEnabled(true);
				}
				if(scissorsCounter == 0) {
					btnScissorsMinus.setEnabled(false);
				}
				else
				{
					btnScissorsMinus.setEnabled(true);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnPlay.setEnabled(false);
				}
				
				btnRock.setText("Rock: " + rockCounter);
				btnPaper.setText("Paper: " + paperCounter);
				btnScissors.setText("Scissors: " + scissorsCounter);
				
			}
		});	
		btnRockMinus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				rockCounter--;
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnRockPlus.setEnabled(true);
					btnPaperPlus.setEnabled(true);
					btnScissorsPlus.setEnabled(true);
				}
				else {
					btnRockPlus.setEnabled(false);
					btnPaperPlus.setEnabled(false);
					btnScissorsPlus.setEnabled(false);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnPlay.setEnabled(false);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) == 0) {
					btnRockMinus.setEnabled(false);
					btnPaperMinus.setEnabled(false);
					btnScissorsMinus.setEnabled(false);
				}
				
				if(rockCounter == 0) {
					btnRockMinus.setEnabled(false);
				}
				if(paperCounter == 0) {
					btnPaperMinus.setEnabled(false);
				}
				if(scissorsCounter == 0) {
					btnScissorsMinus.setEnabled(false);
				}
				
				btnRock.setText("Rock: " + rockCounter);
				btnPaper.setText("Paper: " + paperCounter);
				btnScissors.setText("Scissors: " + scissorsCounter);
			}
		});	
		btnPaper.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		btnPaperPlus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				paperCounter++;
				if((rockCounter + paperCounter + scissorsCounter) == 5) {
					btnRockPlus.setEnabled(false);
					btnPaperPlus.setEnabled(false);
					btnScissorsPlus.setEnabled(false);
					btnPlay.setEnabled(true);
				}
				else {
//					btnRockMinus.setEnabled(true);
//					btnPaperMinus.setEnabled(true);
//					btnScissorsMinus.setEnabled(true);
				}
				
				if(rockCounter == 0) {
					btnRockMinus.setEnabled(false);
				}
				else
				{
					btnRockMinus.setEnabled(true);
				}
				if(paperCounter == 0) {
					btnPaperMinus.setEnabled(false);
				}
				else
				{
					btnPaperMinus.setEnabled(true);
				}
				if(scissorsCounter == 0) {
					btnScissorsMinus.setEnabled(false);
				}
				else
				{
					btnScissorsMinus.setEnabled(true);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnPlay.setEnabled(false);
				}
				
				btnRock.setText("Rock: " + rockCounter);
				btnPaper.setText("Paper: " + paperCounter);
				btnScissors.setText("Scissors: " + scissorsCounter);
			}			
		});
		btnPaperMinus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				paperCounter--;
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnRockPlus.setEnabled(true);
					btnPaperPlus.setEnabled(true);
					btnScissorsPlus.setEnabled(true);
				}
				else {
					btnRockPlus.setEnabled(false);
					btnPaperPlus.setEnabled(false);
					btnScissorsPlus.setEnabled(false);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnPlay.setEnabled(false);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) == 0) {
					btnRockMinus.setEnabled(false);
					btnPaperMinus.setEnabled(false);
					btnScissorsMinus.setEnabled(false);
				}
				
				btnRock.setText("Rock: " + rockCounter);
				btnPaper.setText("Paper: " + paperCounter);
				btnScissors.setText("Scissors: " + scissorsCounter);
				
				if(rockCounter == 0) {
					btnRockMinus.setEnabled(false);
				}
				if(paperCounter == 0) {
					btnPaperMinus.setEnabled(false);
				}
				if(scissorsCounter == 0) {
					btnScissorsMinus.setEnabled(false);
				}
			}
			
		});
		btnScissors.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		btnScissorsPlus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				scissorsCounter++;
				if((rockCounter + paperCounter + scissorsCounter) == 5) {
					btnRockPlus.setEnabled(false);
					btnPaperPlus.setEnabled(false);
					btnScissorsPlus.setEnabled(false);
					btnPlay.setEnabled(true);
				}
				else {
//					btnRockMinus.setEnabled(true);
//					btnPaperMinus.setEnabled(true);
//					btnScissorsMinus.setEnabled(true);
				}
				
				if(rockCounter == 0) {
					btnRockMinus.setEnabled(false);
				}
				else
				{
					btnRockMinus.setEnabled(true);
				}
				if(paperCounter == 0) {
					btnPaperMinus.setEnabled(false);
				}
				else
				{
					btnPaperMinus.setEnabled(true);
				}
				if(scissorsCounter == 0) {
					btnScissorsMinus.setEnabled(false);
				}
				else
				{
					btnScissorsMinus.setEnabled(true);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnPlay.setEnabled(false);
				}
				
				btnRock.setText("Rock: " + rockCounter);
				btnPaper.setText("Paper: " + paperCounter);
				btnScissors.setText("Scissors: " + scissorsCounter);
			}
			
		});
		btnScissorsMinus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				scissorsCounter--;
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnRockPlus.setEnabled(true);
					btnPaperPlus.setEnabled(true);
					btnScissorsPlus.setEnabled(true);
				}
				else {
					btnRockPlus.setEnabled(false);
					btnPaperPlus.setEnabled(false);
					btnScissorsPlus.setEnabled(false);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) != 5) {
					btnPlay.setEnabled(false);
				}
				
				if((rockCounter + paperCounter + scissorsCounter) == 0) {
					btnRockMinus.setEnabled(false);
					btnPaperMinus.setEnabled(false);
					btnScissorsMinus.setEnabled(false);
				}
				
				btnRock.setText("Rock: " + rockCounter);
				btnPaper.setText("Paper: " + paperCounter);
				btnScissors.setText("Scissors: " + scissorsCounter);
				
				if(rockCounter == 0) {
					btnRockMinus.setEnabled(false);
				}
				if(paperCounter == 0) {
					btnPaperMinus.setEnabled(false);
				}
				if(scissorsCounter == 0) {
					btnScissorsMinus.setEnabled(false);
				}
			}
			
		});
		btnPlay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frmGameOn.setVisible(true);
				userVsPc.setVisible(false);

				for (int i = 0, j = 1; i < rockCounter; i++, j++) {
					buttonName[i]="ROCK " + j;
					buttons[i].setText(buttonName[i]);
					user.objectList.add(new Rock());
					updateList.add(new HeavyRock(20, 0, 2, 2));

				}

				for (int i = rockCounter, j = 1; i < rockCounter + paperCounter; i++, j++) {
					buttonName[i]="PAPER " + j;
					buttons[i].setText(buttonName[i]);
					user.objectList.add(new Paper());
					updateList.add(new SpecialPaper(20, 0, 2, 2));
				}

				for (int i = rockCounter + paperCounter,
						j = 1; i < rockCounter + paperCounter + scissorsCounter; i++, j++) {
					buttonName[i]="SCISSORS " + j;
					buttons[i].setText(buttonName[i]);
					user.objectList.add(new Scissors());
					updateList.add(new MasterScissors(20, 0, 2, 2));
				}

			}
		});
		computer.selectObject();
		computer2.selectObject();
	
		buttons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userObject = user.objectList.get(0);
				if (userObject.getLevelScore() > 30) {
					userObject = updateList.get(0);
				}
				Random rnd = new Random();
				int rn = rnd.nextInt(computer.objectList.size());
				computerObject = computer.objectList.get(rn);
				objectManager = new ObjectManager(userObject, computerObject);
				objectManager.calculate(new HeavyRock(20, 0, 2, 1), new MasterScissors(20, 0, 2, 1),
						new SpecialPaper(20, 0, 2, 1));
				lblScore.setText("User: " + objectManager.update(user, computer));
				lblObj1.setText(objectManager.showScore(userObject));
				lblObj2.setText(objectManager.showScore(computerObject));
				if (userObject.getDurability() <= 0) {
					buttons[0].setVisible(false);
					totalCounter--;
					totalCounter2--;
				}
				if (computer.objectList.get(rn).getLevelScore() > 30) {
					computer.objectList.remove(rn);
					computer.objectList.add(rn, computer.updateListComputer.get(rn));
				}
				if (userObject.getLevelScore() > 30) {
					buttonName[0]=updateList.get(0).toString().substring(8, updateList.get(0).toString().indexOf('@'));
					buttons[0].setText(buttonName[0]);
				}
				if (computerObject.getDurability() <= 0) {
					computer.objectList.remove(rn);
					computer.updateListComputer.remove(rn);

				}
				if (totalCounter2 == 0) {
					pane.showMessageDialog(pane, "Pc kazandi");
					frmGameOn.setVisible(false);
				} else if (computer.objectList.size() == 0) {
					pane.showMessageDialog(pane, "Kullanici kazandi");
					frmGameOn.setVisible(false);
				}
				ss=objectManager.showScore(userObject);
				System.out.println();
				counter++;
				if (counter == sayi) {
					for (int k = 0; k < computer.objectList.size(); k++) {
						sum = sum + computer.objectList.get(k).getDurability();
					}
					for (int k = 0; k < user.objectList.size(); k++) {
						sum1 = sum1 + user.objectList.get(k).getDurability();
					}
					win = "User: " + sum1 + "\n Computer: " + sum;
					pane.showMessageDialog(pane, win);
					frmGameOn.setVisible(false);
				}
				totalCounter++;
				buttons[0].setEnabled(false);
				if(totalCounter==totalCounter2) {
					buttons[0].setEnabled(true);
					buttons[1].setEnabled(true);
					buttons[2].setEnabled(true);
					buttons[3].setEnabled(true);
					buttons[4].setEnabled(true);
					totalCounter=0;
				}
				
			}
		});
		buttons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userObject = user.objectList.get(1);
				if (userObject.getLevelScore() > 30) {
					userObject = updateList.get(1);
				}

				Random rnd = new Random();
				int rn = rnd.nextInt(computer.objectList.size());
				computerObject = computer.objectList.get(rn);
				objectManager = new ObjectManager(userObject, computerObject);
				objectManager.calculate(new HeavyRock(20, 0, 2, 1), new MasterScissors(20, 0, 2, 1),
						new SpecialPaper(20, 0, 2, 1));
				lblScore.setText("User: " + objectManager.update(user, computer));
				lblObj1.setText(objectManager.showScore(userObject));
				lblObj2.setText(objectManager.showScore(computerObject));
				if (userObject.getDurability() <= 0) {
					buttons[1].setVisible(false);
					totalCounter--;
					totalCounter2--;
				}
				if (computer.objectList.get(rn).getLevelScore() > 30) {
					computer.objectList.remove(rn);
					computer.objectList.add(rn, computer.updateListComputer.get(rn));
				}
				if (userObject.getLevelScore() > 30) {
					buttonName[1]=updateList.get(1).toString().substring(8, updateList.get(1).toString().indexOf('@'));
					buttons[1].setText(buttonName[1]);
				}
				if (computerObject.getDurability() <= 0) {
					computer.objectList.remove(rn);
					computer.updateListComputer.remove(rn);

				}
				if (totalCounter2 == 0) {
					pane.showMessageDialog(pane, "Pc kazandi");
					frmGameOn.setVisible(false);
				} else if (computer.objectList.size() == 0) {
					pane.showMessageDialog(pane, "Kullanici kazandi");
					frmGameOn.setVisible(false);
				}
				System.out.println();
				counter++;
				if (counter == sayi) {
					for (int k = 0; k < computer.objectList.size(); k++) {
						sum = sum + computer.objectList.get(k).getDurability();
					}
					for (int k = 0; k < user.objectList.size(); k++) {
						sum1 = sum1 + user.objectList.get(k).getDurability();
					}
					win = "User: " + sum1 + "\n Computer: " + sum;
					pane.showMessageDialog(pane, win);
					frmGameOn.setVisible(false);
				}
				totalCounter++;
				buttons[1].setEnabled(false);
				if(totalCounter==totalCounter2) {
					buttons[0].setEnabled(true);
					buttons[1].setEnabled(true);
					buttons[2].setEnabled(true);
					buttons[3].setEnabled(true);
					buttons[4].setEnabled(true);
					totalCounter=0;
				}
			}
		});
		buttons[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userObject = user.objectList.get(2);
				if (userObject.getLevelScore() > 30) {
					userObject = updateList.get(2);
				}

				Random rnd = new Random();
				int rn = rnd.nextInt(computer.objectList.size());
				computerObject = computer.objectList.get(rn);
				objectManager = new ObjectManager(userObject, computerObject);
				objectManager.calculate(new HeavyRock(20, 0, 2, 1), new MasterScissors(20, 0, 2, 1),
						new SpecialPaper(20, 0, 2, 1));
				lblScore.setText("User: " + objectManager.update(user, computer));
				lblObj1.setText(objectManager.showScore(userObject));
				lblObj2.setText(objectManager.showScore(computerObject));
				if (userObject.getDurability() <= 0) {
					buttons[2].setVisible(false);
					totalCounter--;
					totalCounter2--;
				}
				if (computer.objectList.get(rn).getLevelScore() > 30) {
					computer.objectList.remove(rn);
					computer.objectList.add(rn, computer.updateListComputer.get(rn));
				}
				if (userObject.getLevelScore() > 30) {
					buttonName[2]=updateList.get(2).toString().substring(8, updateList.get(2).toString().indexOf('@'));
					buttons[2].setText(buttonName[2]);
				}
				if (computerObject.getDurability() <= 0) {
					computer.objectList.remove(rn);
					computer.updateListComputer.remove(rn);

				}
				if (totalCounter2 == 0) {
					pane.showMessageDialog(pane, "Pc kazandi");
					frmGameOn.setVisible(false);
				} else if (computer.objectList.size() == 0) {
					pane.showMessageDialog(pane, "Kullanici kazandi");
					frmGameOn.setVisible(false);
				}
				System.out.println();
				counter++;
				if (counter == sayi) {
					for (int k = 0; k < computer.objectList.size(); k++) {
						sum = sum + computer.objectList.get(k).getDurability();
					}
					for (int k = 0; k < user.objectList.size(); k++) {
						sum1 = sum1 + user.objectList.get(k).getDurability();
					}
					win = "User: " + sum1 + "\n Computer: " + sum;
					pane.showMessageDialog(pane, win);
					frmGameOn.setVisible(false);
				}
				totalCounter++;
				buttons[2].setEnabled(false);
				if(totalCounter==totalCounter2) {
					buttons[0].setEnabled(true);
					buttons[1].setEnabled(true);
					buttons[2].setEnabled(true);
					buttons[3].setEnabled(true);
					buttons[4].setEnabled(true);
					totalCounter=0;
				}
			}
		});
		buttons[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userObject = user.objectList.get(3);
				if (userObject.getLevelScore() > 30) {
					userObject = updateList.get(3);
				}

				Random rnd = new Random();
				int rn = rnd.nextInt(computer.objectList.size());
				computerObject = computer.objectList.get(rn);
				objectManager = new ObjectManager(userObject, computerObject);
				objectManager.calculate(new HeavyRock(20, 0, 2, 1), new MasterScissors(20, 0, 2, 1),
						new SpecialPaper(20, 0, 2, 1));
				lblScore.setText("User: " + objectManager.update(user, computer));
				lblObj1.setText(objectManager.showScore(userObject));
				lblObj2.setText(objectManager.showScore(computerObject));
				if (userObject.getDurability() <= 0) {
					buttons[3].setVisible(false);
					totalCounter--;
					totalCounter2--;
				}
				if (computer.objectList.get(rn).getLevelScore() > 30) {
					computer.objectList.remove(rn);
					computer.objectList.add(rn, computer.updateListComputer.get(rn));
				}
				if (userObject.getLevelScore() > 30) {
					buttonName[3]=updateList.get(3).toString().substring(8, updateList.get(3).toString().indexOf('@'));
					buttons[3].setText(buttonName[3]);
				}
				if (computerObject.getDurability() <= 0) {
					computer.objectList.remove(rn);
					computer.updateListComputer.remove(rn);

				}
				if (totalCounter2 == 0) {
					pane.showMessageDialog(pane, "Pc kazandi");
					frmGameOn.setVisible(false);
				} else if (computer.objectList.size() == 0) {
					pane.showMessageDialog(pane, "Kullanici kazandi");
					frmGameOn.setVisible(false);
				}
				System.out.println();
				counter++;
				if (counter == sayi) {
					for (int k = 0; k < computer.objectList.size(); k++) {
						sum = sum + computer.objectList.get(k).getDurability();
					}
					for (int k = 0; k < user.objectList.size(); k++) {
						sum1 = sum1 + user.objectList.get(k).getDurability();
					}
					win = "User: " + sum1 + "\n Computer: " + sum;
					pane.showMessageDialog(pane, win);
					frmGameOn.setVisible(false);
				}
				totalCounter++;
				buttons[3].setEnabled(false);
				if(totalCounter==totalCounter2) {
					buttons[0].setEnabled(true);
					buttons[1].setEnabled(true);
					buttons[2].setEnabled(true);
					buttons[3].setEnabled(true);
					buttons[4].setEnabled(true);
					totalCounter=0;
				}
			}
		});
		buttons[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userObject = user.objectList.get(4);
				if (userObject.getLevelScore() > 30) {
					userObject = updateList.get(4);
				}

				Random rnd = new Random();
				int rn = rnd.nextInt(computer.objectList.size());
				computerObject = computer.objectList.get(rn);
				objectManager = new ObjectManager(userObject, computerObject);
				objectManager.calculate(new HeavyRock(20, 0, 2, 1), new MasterScissors(20, 0, 2, 1),
						new SpecialPaper(20, 0, 2, 1));
				lblScore.setText("User: " + objectManager.update(user, computer));
				lblObj1.setText(objectManager.showScore(userObject));
				lblObj2.setText(objectManager.showScore(computerObject));
				if (userObject.getDurability() <= 0) {
					buttons[4].setVisible(false);
					totalCounter--;
					totalCounter2--;
				}
				if (computer.objectList.get(rn).getLevelScore() > 30) {
					computer.objectList.remove(rn);
					computer.objectList.add(rn, computer.updateListComputer.get(rn));
				}
				if (userObject.getLevelScore() > 30) {
					buttonName[4]=updateList.get(4).toString().substring(8, updateList.get(4).toString().indexOf('@'));
					buttons[4].setText(buttonName[4]);
				}
				if (computerObject.getDurability() <= 0) {
					computer.objectList.remove(rn);
					computer.updateListComputer.remove(rn);

				}
				if (totalCounter2 == 0) {
					pane.showMessageDialog(pane, "Pc kazandi");
					frmGameOn.setVisible(false);
				} else if (computer.objectList.size() == 0) {
					pane.showMessageDialog(pane, "Kullanici kazandi");
					frmGameOn.setVisible(false);
				}
				System.out.println();
				counter++;
				if (counter == sayi) {
					for (int k = 0; k < computer.objectList.size(); k++) {
						sum = sum + computer.objectList.get(k).getDurability();
					}
					for (int k = 0; k < user.objectList.size(); k++) {
						sum1 = sum1 + user.objectList.get(k).getDurability();
					}
					win = "User: " + sum1 + "\n Computer: " + sum;
					pane.showMessageDialog(pane, win);
					frmGameOn.setVisible(false);
				}
				totalCounter++;
				buttons[4].setEnabled(false);
				if(totalCounter==totalCounter2) {
					buttons[0].setEnabled(true);
					buttons[1].setEnabled(true);
					buttons[2].setEnabled(true);
					buttons[3].setEnabled(true);
					buttons[4].setEnabled(true);
					totalCounter=0;
				}
			}
		});

		buttons[0].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttons[0].setFont(new Font("Verdana", Font.BOLD,8 ));
				ss = "<html><br/>&emsp;Dayanıklılık: " +user.objectList.get(0).getDurability()  
						+ "<br/>&emsp;Seviye Puanı: " +user.objectList.get(0).getLevelScore() + "<br/>&ensp;&nbsp;</html>";
				buttons[0].setText(ss);
			}
			public void mouseExited(MouseEvent e) {
				buttons[0].setFont(new Font("Verdana", Font.BOLD,11 ));
				buttons[0].setText(buttonName[0]);
			}
		});
		buttons[1].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttons[1].setFont(new Font("Verdana", Font.BOLD,8 ));
				ss = "<html><br/>&emsp;Dayanıklılık: " +user.objectList.get(1).getDurability()  
						+ "<br/>&emsp;Seviye Puanı: " +user.objectList.get(1).getLevelScore() + "<br/>&ensp;&nbsp;</html>";
				buttons[1].setText(ss);
			}
			public void mouseExited(MouseEvent e) {
				buttons[1].setFont(new Font("Verdana", Font.BOLD,11 ));
				buttons[1].setText(buttonName[1]);
			}
		});
		buttons[2].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttons[2].setFont(new Font("Verdana", Font.BOLD,8 ));
				ss = "<html><br/>&emsp;Dayanıklılık: " +user.objectList.get(2).getDurability()  
						+ "<br/>&emsp;Seviye Puanı: " +user.objectList.get(2).getLevelScore() + "<br/>&ensp;&nbsp;</html>";
				buttons[2].setText(ss);
			}
			public void mouseExited(MouseEvent e) {
				buttons[2].setFont(new Font("Verdana", Font.BOLD,11 ));
				buttons[2].setText(buttonName[2]);
			}
		});
		buttons[3].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttons[3].setFont(new Font("Verdana", Font.BOLD,8 ));
				ss = "<html><br/>&emsp;Dayanıklılık: " +user.objectList.get(3).getDurability()  
						+ "<br/>&emsp;Seviye Puanı: " +user.objectList.get(3).getLevelScore() + "<br/>&ensp;&nbsp;</html>";
				buttons[3].setText(ss);
			}
			public void mouseExited(MouseEvent e) {
				buttons[3].setFont(new Font("Verdana", Font.BOLD,11 ));
				buttons[3].setText(buttonName[3]);
			}
		});
		buttons[4].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttons[4].setFont(new Font("Verdana", Font.BOLD,8 ));
				ss = "<html><br/>&emsp;Dayanıklılık: " +user.objectList.get(4).getDurability()  
						+ "<br/>&emsp;Seviye Puanı: " +user.objectList.get(4).getLevelScore() + "<br/>&ensp;&nbsp;</html>";
				
				buttons[4].setText(ss);
			}
			public void mouseExited(MouseEvent e) {
				buttons[4].setFont(new Font("Verdana", Font.BOLD,11 ));
				buttons[4].setText(buttonName[4]);
			}
		});	
		btnComputer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmGameOn.setVisible(true);
				btnPlay.setVisible(false);
				frm1.setVisible(false);
				buttons[0].setVisible(false);
				buttons[1].setVisible(false);
				buttons[2].setVisible(false);
				buttons[3].setVisible(false);
				buttons[4].setVisible(false);
				Main main = new Main();
				main.start();

			}
		});
		frmGameOn.add(lblWin);
		frmGameOn.add(lblObj2);
		frmGameOn.add(lblObj1);
		frmGameOn.add(lblScore);
		frm.setLayout(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameOn.setLayout(null);
		frmGameOn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userVsPc.setLayout(null);
		userVsPc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm1.setLayout(null);
		frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm1.setVisible(true);
	}
	@Override
	public void run() {
		try {
			Random rnd = new Random();
			int rn = 0;
			int rn2 = 0;
			for (int i = 0; i < sayi; i++) {
				rn = rnd.nextInt(computer.objectList.size());
				computerObject = computer.objectList.get(rn);
				rn2 = rnd.nextInt(computer2.objectList.size());
				computerObject2 = computer2.objectList.get(rn2);
				objectManager = new ObjectManager(computerObject, computerObject2);
				objectManager.calculate(new HeavyRock(20, 0, 2, 1), new MasterScissors(20, 0, 2, 1),
						new SpecialPaper(20, 0, 2, 1));
				lblScore.setText("Computer: " + objectManager.update(computer, computer2));
				lblObj1.setText(objectManager.showScore(computerObject));
				lblObj2.setText(objectManager.showScore(computerObject2));
				System.out.println(computer.objectList);
				System.out.println(computer2.objectList);

				if (computerObject.getDurability() <= 0) {
					System.out.println("c1 girdi");
					// System.out.println(computer.objectList.get(rn));
					computer.objectList.remove(rn);
					computer.updateListComputer.remove(rn);
					// System.out.println("kalti mi" + computer.objectList.get(rn));
				} else if (computerObject.getLevelScore() > 30) {
					computer.objectList.remove(rn);
					computer.objectList.add(rn, computer.updateListComputer.get(rn));
				}
				if (computerObject2.getDurability() <= 0) {
					System.out.println("c2 girdi..");
					// System.out.println(computer2.objectList.get(rn2));
					computer2.objectList.remove(rn2);
					computer2.updateListComputer.remove(rn2);
					// System.out.println("kalkti mi.." + computer2.objectList.get(rn2));
				} else if (computerObject2.getLevelScore() > 30) {
					computer2.objectList.remove(rn2);
					computer2.objectList.add(rn2, computer2.updateListComputer.get(rn2));
				}
				Thread.sleep(1000);
				System.out.println();
				if (computer.objectList.size() == 0 || computer2.objectList.size() == 0)
					break;
			}
			for (int k = 0; k < computer2.objectList.size(); k++) {
				sum = sum + computer2.objectList.get(k).getDurability();
			}
			for (int k = 0; k < computer.objectList.size(); k++) {
				sum1 = sum1 + computer.objectList.get(k).getDurability();
			}
			win = "Computer1: " + sum1 + "\n Computer2: " + sum;
			if (computer2.objectList.size() == 0) {
				pane.showMessageDialog(pane, "Pc1 kazandi");
			} else if (computer.objectList.size() == 0) {
				pane.showMessageDialog(pane, "Pc2 kazandi");
			} else
				pane.showMessageDialog(pane, win);

		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
}
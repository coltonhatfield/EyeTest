
import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 42L;//idk what this does but it makes an error go away
	
	
	JLabel letter;
	int fontSize;
	int numLettersDisplayed;
	int score;
	JButton correct;
	JButton incorrect;
	static char lastLetter;
	//testing if the pushing is working
	
	
	
	public static String randomLetterPicker() {
		char[] letters = {'C', 'D', 'E', 'F', 'L', 'O', 'P', 'T', 'Z'};
		int randomNum = (int)(Math.random() * 9);
		if(lastLetter == letters[randomNum]) {
			return randomLetterPicker();
		}
		lastLetter = letters[randomNum];
		return Character.toString(letters[randomNum]);
	}
	
	
	public String interpretResults(int fontWrong) {
		return Integer.toString(50-fontSize/2);
	}
	
	
	MyFrame() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new BorderLayout(10,10));
		frame.setTitle("Prescription Finder");
		frame.setResizable(false);
		frame.setVisible(true);

		JPanel title = new JPanel();
		JPanel main = new JPanel();
		
		title.setBackground(Color.gray);
		main.setBackground(Color.white);
		
				
		title.setPreferredSize(new Dimension(100,100));
		main.setPreferredSize(new Dimension(100,100));
		
		frame.add(title,BorderLayout.NORTH);
		frame.add(main,BorderLayout.CENTER);
		
		//text for the title
		JLabel titleText = new JLabel("Welcome to your eye exam");
		titleText.setFont(new Font("Verdana",1,30));
		title.add(titleText);
		
		//buttons yippeeeeeee
		correct = new JButton();
		correct.setBounds(100,100,250,100);
		correct.addActionListener(this);
		correct.setText("Correct");
		
		incorrect = new JButton();
		incorrect.setBounds(100,100,250,100);
		incorrect.addActionListener(this);
		incorrect.setText("Incorrect");
		
		title.add(correct);
		title.add(incorrect);
		
		
		
		
		
		
		

		
		fontSize = 100;
		numLettersDisplayed = 1;
		score = 0;
		letter = new JLabel(randomLetterPicker());
		letter.setFont(new Font("Verdana",1,fontSize));
		main.add(letter);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==incorrect) {
			System.out.print(interpretResults(fontSize));
			System.exit(0);

		}
		
		
		
		
		if(numLettersDisplayed == 3) {
			fontSize -= 10;
			letter.setFont(new Font("Verdana",1,fontSize));
			numLettersDisplayed = 0;
		}
		letter.setText(randomLetterPicker());
		numLettersDisplayed++;
		
		if(fontSize < 10) {
			System.exit(0);
		}

		
		
	}
	
}
package Singh_Gursharan_100312495_Lab6_7_Exercise1;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Application extends JFrame implements ActionListener{
	JPanel mainPanel = new JPanel();
	JPanel textAreaPanel = new JPanel();
	JPanel labelPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	JTextArea inputArea = new JTextArea(15,25);
	
	JLabel wordCountLabel = new JLabel("Number Of Words:");
	JLabel averageLabel = new JLabel("Average word Length:");
	JLabel vowelCount = new JLabel("Number Of vowels:");
	
	JTextField averageLabelFeild = new JTextField();
	JTextField wordCountFeild = new JTextField();
	JTextField vowelCountFeild = new JTextField();
	
	public Application(String name) {
		createFrame(name);
		addTextArea();
		addLabels();
		addButton();
		addAllPanels();
		setVisible();
	}
	
	public void createFrame(String name) {
		setTitle(name);
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(0,2,10,10));
	}
	
	public void addTextArea() {
		textAreaPanel.add(inputArea);
	}
	
	public void addLabels() {
		labelPanel.setLayout(new GridLayout(3,2));
		labelPanel.setBorder(BorderFactory.createTitledBorder("Statictics"));
		
		labelPanel.add(wordCountLabel);
		wordCountFeild.setEditable(false);
		labelPanel.add(wordCountFeild);
		
		labelPanel.add(averageLabel);
		averageLabelFeild.setEditable(false);
		averageLabelFeild.setSize(20,5);
		labelPanel.add(averageLabelFeild);
		
		
		labelPanel.add(vowelCount);
		vowelCountFeild.setEditable(false);
		vowelCountFeild.setSize(20,5);
		labelPanel.add(vowelCountFeild);
	}
	
	public void addButton() {
		JButton countButton = new JButton("Compute Statistics");
		buttonPanel.add(countButton);
		countButton.addActionListener(this);
	}
	
	public void addAllPanels() {
		mainPanel.add(textAreaPanel);
		mainPanel.add(labelPanel);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(mainPanel,BorderLayout.NORTH);
		add(buttonPanel,BorderLayout.CENTER);
	}
	
	public void setVisible() {
		setVisible(true);
	}
	
	public int countWords(String text) {
		int count=0;
		text = text.trim();
		count = text.split("\\s+").length;
		return count;
	}

	public double findAverage(String text,int words) {
		int characters = 0;
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i) != (char)32 || text.charAt(i) != (char)13) {
				characters++;
			}
		}
		return characters/words;
	}
	
	public int countVowels(String text) {
		int count=0;
		for(int i=0;i<text.length();i++) {
			char ch = text.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
			   ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U') {
				count++;
			}
		}
		return count;
	}
	
	public void actionPerformed(ActionEvent e) {
		String inputText = inputArea.getText();
		int words = countWords(inputText);
		wordCountFeild.setText(Integer.toString(words));
		double average = findAverage(inputText,words);
		averageLabelFeild.setText(Double.toString(average));
		int vowels = countVowels(inputText);
		vowelCountFeild.setText(Integer.toString(vowels));
	}
}

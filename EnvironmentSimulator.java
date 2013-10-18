
/*****************************************************
* Date : March 6, 2013
* File : EnvironmentSimulator.java
* Language : java
****************************************************/
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EnvironmentSimulator{
	static JFrame myFrame;
	static JLabel[] labelArray, targetLabelArray;

	public EnvironmentSimulator() {
		myFrame = new JFrame("Simulator");
		myFrame.setLayout(null);
		myFrame.setPreferredSize(new Dimension(800, 800));
		myFrame.getContentPane().setBackground(Color.black);
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
	}
	public static void createJlabels(int numOfLabels) {
		labelArray = new JLabel[numOfLabels];
		for (int i = 0; i < numOfLabels; i++) {
			labelArray[i] = new JLabel("" + i);
		}
	}

	public static void initializeLabels(){
		int length = labelArray.length;
		Random generator = new Random();
		int x, y;
		for (int i = 0; i < length; i++){
			x = generator.nextInt(800);
			y = generator.nextInt(800);
			labelArray[i].setForeground(Color.white);
			labelArray[i].setBounds(x, y, 10, 10);
			myFrame.add(labelArray[i], 0);
		}
	}
	
	public static void update(int index, int x, int y) {
		labelArray[index].setBounds(x, y, 10, 10);
	}
	public static void move(int index, int x, int y) throws InterruptedException {
		labelArray[index].setBounds(x, y, 10, 10);
	}
	public static void deactivate(int index) throws InterruptedException {
		labelArray[index] = null;
	}
	public static void moveALL(ActualEntity[] theCOPE) {
		ActualEntity[] cope = theCOPE;
		int index = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < theCOPE.length; i++) {
			index = theCOPE[i].getIndex();
			x = theCOPE[i].getX();
			y = theCOPE[i].getY();
			if (x == 0 && y == 0) {
				labelArray[index].setBounds(10, 10, 10, 10);
			} else if (labelArray[index]!=null) {
				labelArray[index].setBounds(x, y, 10, 10);
			}
		}
	}
}


/*****************************************************
* Date : March 6, 2013
* File : COPE.java
* Language : java
****************************************************/
import java.awt.Point;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class COPE{
	static final int ROWS = 800;
	static final int COLUMNS = 800;
	static final int MEMNUM = 10; //need to be able to change
	static int x, y;
	static int num, group;
	static ActualEntity[][] actualEntities = new ActualEntity[ROWS][COLUMNS];
	static ActualEntity[] theCOPE = new ActualEntity[MEMNUM];
	static EnvironmentSimulator simulator = new EnvironmentSimulator();

	public static void main(String [] args) throws IOException, InterruptedException {
		simulator.createJlabels(MEMNUM);
		simulator.initializeLabels();
		int[][] result = new int[MEMNUM][3];
		Scanner in = new Scanner(System.in);
		Environment.setEnvironment();
		int count = 0;
		Thread.sleep(10000);

		while (checkConvergence()) {
			System.out.println(num);
			count++;
			//ActualEntity.prehend(theCOPE, simulator);
			//simulator.moveALL(theCOPE);
			Thread.sleep(200);
		}
	}

	public static boolean checkConvergence(){
		return true;
	}

	public static int getMEMNUM(){
		return MEMNUM;
	}
	
	public static void setTheCopeArray(ActualEntity[] cope){
		theCOPE = cope
;	}

	//Set Up initial environment
	public static class Environment{
		static Random generator = new Random();

		public static void setEnvironment(){
		//sets empty grid displayed as a 2 dim array
			for (int row = 0; row < ROWS; row++) {
				for (int col = 0; col < COLUMNS; col++) {
					actualEntities[row][col] = null;
				}
			}
			int inc = 1;
			for (int i = 0; i < MEMNUM; i++) {
				ActualEntity actualEntity;
				Point point;
				point = simulator.labelArray[i].getLocation();
				x = (int)(point.getX());
				y = (int)(point.getY());
				while (actualEntities[x][y] != null) {
					simulator.update(i, x, y);
				}
				//get random group number
				int group = generator.nextInt(100);
				actualEntity = new ActualEntity(i, x, y, group);
				actualEntities[x][y] = actualEntity;
				theCOPE[i] = actualEntity;
				inc++;
			}
		}
	}
}

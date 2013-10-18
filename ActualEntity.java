
/*****************************************************
* Date : March 6, 2013
* File : ActualEntity.java
* Language : java
****************************************************/
public class ActualEntity{

	public static final int ACTIVE = 1;
	public static final int INACTIVE = 0;
	public static final int INNERTHRESHOLD = 0;
	public static final int OUTERTHRESHOLD = 60;
	public static final int SIZE = 800;

	public int index, x, y, group, status;
	//add variables here for model
	public int timeCount;

	public ActualEntity (int index, int xCoor, int yCoor, int group){
		this.index = index;
		this.x = xCoor;
		this.y = yCoor;
		this.group = group;
		this.status = ACTIVE;

		//add variable creation here
	}

	public int getIndex(){
		return this.index;
	}

	public int getX(){
		return this.x;
	}

	public void setX(int xCoor){
		this.x = xCoor;
	}

	public int getY(){
		return this.y;
	}

	public void setY(int yCoor){
		this.y = yCoor;
	}

	public int getGroup(){
		return this.group;
	}

	public void setGroup(int group){
		this.group = group;
	}

	public int getStatus(){
		return this.status;
	}

	public void setStatus(int status){
		this.status = status;
	}

	//add get/set for variables from model

	public static boolean toPrehendOrNot(ActualEntity mem1, ActualEntity mem2){
		int finalX, finalY;
		int x1 = mem1.getX();
		int y1 = mem1.getY();
		int x2 = mem2.getX();
		int y2 = mem2.getY();
		if (x1 > x2){
			finalX = x1 - x2;
		} else {
			finalX = x2 - x1;
		}
		
		if (y1 > y2){
			finalY = y1 - y2;
		} else {
			finalY = y2 - y1;
		}
	
		if (finalX < OUTERTHRESHOLD && finalX > INNERTHRESHOLD && finalY < OUTERTHRESHOLD && finalY > INNERTHRESHOLD){
			return true;
		} else{
			return false;
		}
	}

	public static int moveX(int oldX, int newX) {
		if (oldX > newX) {
			return 1;
		} else {
			return 2;
		}
	}

	public static int moveY(int oldY, int newY) {
		if (oldY > newY) {
			return 1;
		} else {
			return 2;
		}
	
	}

	public static void prehend(ActualEntity[] theCOPE, EnvironmentSimulator simulator) throws InterruptedException{
		int index = 0;
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		int x, y;
		ActualEntity mem1, mem2;
		for (int i = 0; i < theCOPE.length; i++){
			mem1 = theCOPE[i];
			if (mem1.getStatus() == ACTIVE){
				x1 = mem1.getX();
				y1 = mem1.getY();
				x = x1;
				y = y1;

				for (int j = 0; j < theCOPE.length; j++){
					if (i != j && theCOPE[j].getStatus() == ACTIVE){
						mem2 = theCOPE[j];
						x2 = mem2.getX();
						y2 = mem2.getY();
						if (toPrehendOrNot(mem1, mem2)){
							//prehension function
					
						} // close to prehend or not
					} //close if active
				} //close cope prehending

				mem1.setX(x1);
				mem1.setY(y1);

				//make sure cope array is passed back
				theCOPE[i] = mem1;
				COPE.setTheCopeArray(theCOPE);
			} //close if active
		} //close mem1 loop
	} //close method
} //close AE

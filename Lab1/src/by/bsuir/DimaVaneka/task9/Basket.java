package by.bsuir.DimaVaneka.task9;

import by.bsuir.DimaVaneka.task9.Ball;

import java.util.LinkedList;

public class Basket {
	
	private LinkedList<Ball> ballsList ;
	
	public Basket() {
		ballsList = new LinkedList<Ball>();
	}
	
	public LinkedList<Ball> getBallsList () {
		return ballsList;
	} 
	
	public void addBall (Ball ball) {
		ballsList.add(ball);
	}
	
	public int getSize() {
		return ballsList.size();
	}
	
	public void clearBasket () {
		ballsList.clear();
		
	}
	
	 
}

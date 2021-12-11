package by.bsuir.DimaVaneka.task9;


import by.bsuir.DimaVaneka.input.InputData;

public class StartTask {
	
	public static void main(String[] args) {
		
		Basket basket = new Basket();
		fill(basket);
		
		try {
		System.out.println("Total ball's weight in basket is: " + DoTask.getBallsWeight(basket));
		System.out.println("Count of blue balls is: "+ DoTask.getCountOfColoredBalls(basket, "blue"));
		}catch(IllegalArgumentException e) {
			System.out.println( e.getMessage() );
		}
		
	}
	
	public static  void fill(Basket basket) {
        int ballsCount;
        double ballWeight;
        String ballColor;

        System.out.print("Enter balls amount: ");
        ballsCount = InputData.inputPositiveInt();
        
        for (int i = 0; i < ballsCount; i++) {
            System.out.println("Ball " + (i + 1) + " of " + ballsCount);
            
            System.out.print("Enter ball's weight: ");
            ballWeight = InputData.inputPositiveDouble();
            
            System.out.print("Enter ball's color: ");
            ballColor = InputData.inputString();
            
            basket.addBall(new Ball(ballColor, ballWeight));
        }
    }
}

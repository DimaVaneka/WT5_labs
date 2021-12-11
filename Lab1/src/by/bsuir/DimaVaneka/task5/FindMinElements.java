package by.bsuir.DimaVaneka.task5;

public class FindMinElements {
	
	public static int getMinElements(int[] sequence) {
		
        int maxIncLen = 0, curInLen = 0;
        boolean isIncrease;

        if (sequence == null) {
            throw new IllegalArgumentException("Array is empty");
        }

        for (int i = 0; i < sequence.length; i++) {
            isIncrease = true;
            curInLen = 1;
            for (int j = i + 1; (j < sequence.length) && isIncrease; j++) {
                if (sequence[j - 1] < sequence[j]) {
                	curInLen++;
                } else {
                    isIncrease = false;
                }
            }
            maxIncLen = Math.max(maxIncLen, curInLen);
        }
        return sequence.length - maxIncLen;
    }
}

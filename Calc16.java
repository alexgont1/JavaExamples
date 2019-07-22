
public class Calc16 {
	
	public int getSum(int i, int j) {//parameters
		int res = i + j;
		return res;
	}
	
	public int getSub(int i, int j) {
		int res = i - j;
		return res;
	}
	
	public int getMul(int i, int j) {
		int res = i * j;
		return res;
	}
	
	public int getDiv(int i, int j) {
		int res = i / j;
		return res;
	}	

	public static void main(String[] args) {
		Calc16 c = new Calc16();
		
		int result = c.getSum(5, 5);//arguments
		System.out.println("Result 5 + 5 = " + result);
		
		result = c.getSub(10, 5);
		System.out.println("Result 10 - 5 = " + result);
		
		result = c.getMul(5, 5);
		System.out.println("Result 5 * 5 = " + result);
		
		result = c.getDiv(50, 5);
		System.out.println("Result 50 / 5 = " + result);		

	}

}

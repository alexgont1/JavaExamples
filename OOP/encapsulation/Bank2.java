package encapsulation;

public class Bank2 {

	
	public int accNo=12345;
	private int pinNo=1234;
	private int balance=1000;
	
	

	public void withdraw (int acc, int pin, int amount) {
		
		if(acc==accNo && pin==pinNo) {
			
			if(amount<=balance) {
				balance=balance-amount;
				System.out.println("New balance="+balance);
			}else {
				System.out.println("Not enough money!");
			}
			
		}else {
			System.out.println("Invalid credentials!");
		}
		
	}
	
	public void updatePin(int acc, int oldPin, int newPin) {
		
		if(acc==accNo && oldPin==pinNo) {
			pinNo = newPin;
			System.out.println("Pin changed");
		}else {
			System.out.println("Invalid data");
		}
	}
	
}

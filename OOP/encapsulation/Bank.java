package encapsulation;

public class Bank {
	
	public int accNo=12345;
	public int pinNo=1234;
	public int balance=1000;

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
	
}

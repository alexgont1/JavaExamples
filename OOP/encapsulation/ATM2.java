package encapsulation;

public class ATM2 {

	public static void main(String[] args) {
		
		Bank2 obj = new Bank2();
		
		//obj.pinNo=12;//impossible
		//to updade - use special method
		obj.updatePin(12345, 1234, 12);

		
		//obj.balance=0////impossible
		
		obj.withdraw(12345, 12, 100);
	}

}

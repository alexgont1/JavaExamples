package encapsulation;

public class ATM {

	public static void main(String[] args) {
		
		Bank obj = new Bank();
		
		obj.pinNo=12;//BAD-anybody can change pin!!!
		//to fix - change variable to private
		//good example = Bank2
		
		obj.withdraw(12345, 1234, 10000);
	}

}

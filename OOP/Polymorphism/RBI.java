package Polymorphism;

public class RBI {
	
	public void getHomeLoanROI (String bankName) {
		
	}
	
	public void getHomeLoanROI () {//different signature
		
	}
	
	public void getHomeLoanROI (String bankName, int amount) {
		
	}
	
	public void getHomeLoanROI (int amount, String bankName) {
		//different order of parameters
	}
	
	///////////////////////////////////////// overriding
	
	public int getHomeLoanROI1() {
		return 8;
	}
	
	public int getCarLoanROI1() {
		return 10;
	}

}

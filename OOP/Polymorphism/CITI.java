package Polymorphism;

public class CITI extends RBI{
	
	public static void main(String[] args) {
		
		CITI obj = new CITI();
		System.out.println(obj.getHomeLoanROI1());
		
	}
	
	//signature here = signature from RBI, but return different
	//this own method overrides method from RBI
	//and we see Sys.out from main, but return from here
	public int getHomeLoanROI1() {
		return 10;
	}
	
}

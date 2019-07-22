package Polymorphism;

public class HSBC extends RBI {
	
	public static void main(String[] args) {
		
		HSBC obj = new HSBC();
		System.out.println(obj.getHomeLoanROI1());
		
	}
	
	//signature here = signature from RBI, but return different
		//this own method overrides method from RBI
		//and we see Sys.out from main, but return from here
		public int getHomeLoanROI1() {
			return 13;
		}

}


public class Arrays {

	public static void main(String[] args) {

		/*int[] salary;
		salary = new int[10];*/
		
		/*for(int i=0; i<10; i++) {
		salary[i] = i;
		System.out.println(salary[i]);
		//System.out.println("Array length=" + salary.length);
		}*/
		
		//OR:
		int table[][]=new int[5][5];
		
		int ind=0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				ind++;
				table[i][j]=ind;
				System.out.println("["+i+"]["+j+"]="+ind);
			}
			
		}
		
		
		/*String month[] = {"Jan", "Feb", "Mar"};

		for(int i=0; i<month.length; i++) {
			System.out.println(month[i]);
		}*/
		
	}

}

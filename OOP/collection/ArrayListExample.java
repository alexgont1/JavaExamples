package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		System.out.println(list);
		
		//size
		System.out.println(list.size());
		
		//add elements of all types to ArrayList
		//autoBoxing for all elements, they all are objects
		list.add(10);
		list.add("Text");
		list.add(10.101);
		list.add('c');
		list.add("Text");
		list.add(true);
		list.add(null);
		
		System.out.println(list);
		System.out.println(list.size());

		//get object from ArrayList
		System.out.println("ArrayList object: "+list.get(0));
		
		//remove object from ArrayList
		list.remove(5);
		System.out.println(list);
		System.out.println(list.size());	
		
		//show all object in ArrayList
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+"\t");
		}
		System.out.println();
		
		//OR MORE UNIVERSAL METHOD:
		for(Object var:list) {
			System.out.print(var+"\t");
		}
		System.out.println();
		
		//OR 1 MORE METHOD:
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+"\t");
		}
		
		//ArrayList with 1 data type:
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(null);
		//list1.add('c');//impossible here

	}

}

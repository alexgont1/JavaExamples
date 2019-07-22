package Demo1;

import Demo2.Test;
import pckg1.ClassA;//to use ClassA from pckg1 package
import pckg1.TestCase;;

//import pckg1.ClassB//impossible to use default ClassB

public class TC2 {
	
	ClassA obj = new ClassA();
	
	Test obj5 = new Test();

	public class TC3 extends TestCase {
		
		C obj1 = new C();
		D obj2 = new D();
	}
}

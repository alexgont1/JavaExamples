package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test {
	
	public void show(int a) {		
	}
	
	public void add(int b, float d) {		
	}
	
	public void print(int c) {		
	}

	public static void main(String[] args) {
		
		Test t = new Test();
		//print className:
		System.out.println(t.getClass().getSimpleName());
		 		
		//print all information about class:
		Class clazz = t.getClass();
		System.out.println(clazz);//put '.' to print any info
		
		//show all class methods:
		Method[] allMethods = clazz.getDeclaredMethods();
		System.out.println("Methods: "+allMethods.length);
		
		for(Method m:allMethods) {
			System.out.println(m.getName());
			Parameter[] pars = m.getParameters();
			System.out.print("Params: "+m.getParameterCount()+". List:");
			
			for(Parameter par:pars) {
				System.out.print(par+"\t");
			}
			System.out.println();
		}
		
	/*We need log files during execution for our tests, like
	 * Test -> Object -> Class oblect 
		 * Log in log files - log4j
		 * log.debug(doLogin test executed)
		 * log.debug(doUserReg test executed)
		 * 
		 * @BeforeMethod
		 * public void beforeMethod(Method m) {
		 * 		(Test case executed is: + m.getName)
		 * }
		 * 
		 * @Test
		 * doLogin () {}
		 * 
		 * @Test
		 * doUserReg () {}	
		 * 
		 */

	}

}

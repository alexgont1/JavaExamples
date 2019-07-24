package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapExamples {

	public static void main(String[] args) {
		
		//hash with 'string' key and value
		Map<String,String> map = new HashMap<String,String>();
		map.put("FirstName", "Alex");
		map.put("Language", "Java");
		map.put("Why?", "For Automation");
		
		System.out.println(map);
		System.out.println(map.size());
		
		System.out.println(map.get("FirstName"));

		Set<String> keys = map.keySet();
		for(String key:keys) {
			System.out.println("Key: "+key+" Value: "+map.get(key));
		}
		
		//more complex:
		Map<String,List<String>> map1 = new HashMap<String,List<String>>();
		List<String> emailsList = new ArrayList<String>();
		emailsList.add("test1@mail.com");
		emailsList.add("test2@mail.com");
		emailsList.add("test3@mail.com");
		
		map1.put("email", emailsList);
		
	}

}

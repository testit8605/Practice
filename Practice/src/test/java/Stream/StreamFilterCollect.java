package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterCollect {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Akshay");
		al.add("Sanjay");
		al.add("Swapnil");
		al.add("Vaibhav");
		al.add("Kiku");
		
		System.out.println("******************************************");
		System.out.println(al);
		al.forEach(s-> System.out.println(s));
		System.out.println("******************************************");
		
		al.stream().filter(s-> s.length()>6).forEach(s-> System.out.println(s));
		System.out.println("**********************&&&&&&************************");
		
		List<String> k = al.stream().filter(s-> !s.equals("Vaibhav")).collect(Collectors.toList());
		//System.out.println(k);
		k.forEach(j->System.out.println(j));
		
		System.out.println("******************************************");
		
		al.stream().filter(s-> !s.equals("Akshay")).forEach(s->System.out.println(s));
		
		System.out.println("*****************%%%%%*************************");
		
		String d = al.stream().filter(s-> s.equals("Akshay")).findAny().orElse(null);
		System.out.println(d);
		
		System.out.println("*****************%%%%%*************************");
		
		
		
		
	}

}

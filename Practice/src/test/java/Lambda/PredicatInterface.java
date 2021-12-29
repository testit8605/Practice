package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatInterface 
{
	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(20);
		l.add(200);
		l.add(2);
		l.add(3);
		l.add(20);
		l.add(200);
		l.add(2);
		l.add(3);
				
		Predicate<Integer> fun = x-> x>5;
		
		List<Integer> j = l.stream().filter(fun).collect(Collectors.toList());
		System.out.println(j);
		
		//***********************************************************************************************
		
		List<Integer> k = l.stream().filter(x-> x>5 && x<100).collect(Collectors.toList());
		System.out.println(k);
		
		//***********************************************************************************************

		List<String> u = new ArrayList<String>();
		u.add("Akshay");
		u.add("Swapnil");
		u.add("Sanjay");
		
		//Neglect the name
		Predicate<String> p = n -> n.startsWith("Aks");
		List<String> o = u.stream().filter(p.negate()).collect(Collectors.toList());
		System.out.println(o);
		
		
		
		
	}
	
	

}

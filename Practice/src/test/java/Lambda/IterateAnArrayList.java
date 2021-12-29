package Lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IterateAnArrayList {

	public static void main(String[] args) 
	{
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Akshay");
		al.add("Sanjay");
		al.add("Swapnil");
		al.add("Vaibhav");
		al.add("Kiku");
		//********************************************************************************************
		al.forEach(s-> {
			System.out.println(s);
		});
		System.out.println("*******************************************");
		Iterator<String> k = al.iterator();
		while(k.hasNext())
		{
			System.out.println(k.next());
		}
		
		System.out.println("*******************************************");
		
		Iterator<String> it = al.iterator();
		it.forEachRemaining(s-> {
			System.out.println(s);
		});
		
		System.out.println("*******************&&&************************");
		
		for(String st:al)
		{
			System.out.println(st);
		}
		
		System.out.println("*******************************************");
		
		for(int i=0; i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
		
		System.out.println("*******************Reverse Order************************");
		ListIterator<String> itr = al.listIterator(al.size());
		while(itr.hasPrevious())
		{
			System.out.println(itr.previous());
		}
		
		
		
	}

}

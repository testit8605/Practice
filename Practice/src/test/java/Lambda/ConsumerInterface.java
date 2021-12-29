package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class ConsumerInterface 
{
	public static void main(String[] args) {

		Consumer<String> fun = x-> System.out.println(x);
		fun.accept("Akshay");
		
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(20);
		l.add(200);
		l.add(2);
		l.add(3);
		l.add(20);
		l.add(200);
		l.add(2);
		l.add(3);
		
		l.forEach(x-> System.out.print(x+ " "));
		
	}
	
	

}

package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorPractice {

	public static void main(String[] args) {
		
		UnaryOperator<Integer> fun = x -> x*2;
		int res = fun.apply(10);
		System.out.println(res);
		
		Function<Integer, Integer> fun1 = x1-> x1*10;
		int r = fun1.apply(40);
		System.out.println(r);
		
		List<String> l = new ArrayList<String>();
		l.add("Akshay");
		l.add("Swapnil");
		l.add("Sanjay");
		
		System.out.println(l);
		
		l.replaceAll(e-> e+" Bhagat");
		
		System.out.println(l);
		
		
	}

}

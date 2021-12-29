package Lambda;

import java.util.function.Function;

public class FunctionInterface 
{
	public static void main(String args[])
	{
		//Function
		Function<String, Integer> func1 = x-> x.length();
		int len = func1.apply("Akshay");
		System.out.println(len);
		
		//Chaining
		Function<Integer, Integer> func2 = x-> x * 2;
		int result = func1.andThen(func2).apply("This is");
		System.out.println(result);
		
	}
	
	
	
	
	
	
	

}

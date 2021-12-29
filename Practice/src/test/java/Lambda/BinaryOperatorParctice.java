package Lambda;

import java.util.function.BiFunction;

public class BinaryOperatorParctice 
{
	public static void main(String args[])
	{
		
		
//	BinaryOperator<Integer> func = (x1, x2)-> x1+x2;
//	int sum  = func.apply(10,20);
//		System.out.println(sum);
		
		BiFunction<Integer,Integer,Integer> func1 = (x1, x2) -> x1+x2;
		int result = func1.apply(30,40);
		System.out.println(result);
	}
}

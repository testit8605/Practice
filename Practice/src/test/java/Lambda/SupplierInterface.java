package Lambda;

import java.util.function.Supplier;

public class SupplierInterface {

	public static void main(String[] args) {
		
		
		getText(()-> "Akshay");		
		getText(()-> "Akash");	
		getText(()-> "Sanjay");	
	}
	
	
	public static void getText(Supplier<String> x)
	{
		System.out.println(x.get());
	}
}

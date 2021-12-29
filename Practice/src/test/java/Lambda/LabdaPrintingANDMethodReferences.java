package Lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LabdaPrintingANDMethodReferences {

	public static void main(String[] args) {
		
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Akshay");
		al.add("Sanjay");
		al.add("Swapnil");
		al.add("Vaibhav");
		al.add("Kiku");
		
		al.forEach(new Consumer<String>() {
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		System.out.println("*******************************************");
		
		al.forEach(s-> System.out.println(s));
		
		System.out.println("*******************************************");
		
		al.forEach(System.out :: println);
		
		System.out.println("*******************************************");
		
	}

}

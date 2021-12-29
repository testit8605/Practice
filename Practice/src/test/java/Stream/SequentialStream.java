package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialStream {

	public static void main(String[] args) {
		Stream stream = Stream.of("Akshay", "Bhagat", "Vaibhav");
		stream.forEach(s-> System.out.println(s));
		
		//stream().findFirst().ifPresent(System.out::println);
		
		Arrays.asList("A", "B", "c").stream().findFirst().ifPresent(System.out::println);
		
		
		//range 1 to 5
		IntStream.range(1,11).forEach(System.out::println);
		
		//Average
		Arrays.stream(new int[] {1,2,3,4}).map(s-> 2*s+1).average().ifPresent(s-> System.out.println(s));
		
		//String data object
		Stream.of("A1", "b6", "c30").map(s->s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
		
		//doubles to string object
		Stream.of(1.0,2.0,3.0,4.0,5.0,3.0,8.0).mapToInt(Double::intValue).mapToObj(s->"a"+s).forEach(s->System.out.println(s));
	
		//Limit
		Stream.iterate(0, n->n+1).limit(10).forEach(s->System.out.println(s));
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&7");
		//Even numbers
		Stream.iterate(0, n->n+1).limit(10).filter(x-> x%2==0).forEach(s->System.out.println(s));
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&7");
		//Odd numbers
		Stream.iterate(0, n->n+1).limit(10).filter(x-> x%2!=0).forEach(s->System.out.println(s));
		
		
		//Odd numbers
		System.out.println("&&&&&&&&&&&&******&&&&&&&&&&&&&&&7");
		int data[] = {1,2,3,4,4,5,6,7,7,9};
		Stream.of(data).flatMapToInt(x-> Arrays.stream(x)).filter(x->x%2!=0).forEach(s-> System.out.println(s));
		
		//Parallel Execution
		//Odd numbers
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&7");
		int data1[] = {1,2,3,4,4,5,6,7,7,9};
		Stream.of(data1).parallel().flatMapToInt(x->Arrays.stream(x)).filter(x-> x%2==0).forEach(s->System.out.println(s));
		
		//Parallel execution
		System.out.println("&&&&&&&&&&&&&&&&7");
		
		Stream.of("Akshay", "Bhagat", "Vaibhav", "Bhagat").forEach(s-> System.out.println(s));
		System.out.println("&&&&&&&&&&&&&&&&7");
		
		Stream.of("Akshay", "Bhagat", "Vaibhav", "Bhagat").parallel().forEach(s-> System.out.println(s));
		
		//parallel stream on collection
		System.out.println("&&&&&&&&&&&&&&&&7");
		Arrays.asList("Akshay", "Bhahgat", "vainbhag", "Kal").parallelStream().forEach(s-> System.out.println(s));
		
		//1 to 10 sequential
		System.out.println("&&&&&&&&&&&&&&&&7");
		IntStream.rangeClosed(1, 11).forEach(s-> System.out.println(s));
		
		//1 to 10 sequential
		System.out.println("&&&&&&&&************************8&&&&&&&&7");
		IntStream.rangeClosed(1, 11).parallel().forEach(s-> System.out.println(s));
		
		System.out.println("&&&&&&&&************************8&&&&&&&&7");
		//to print from a to z
		//System.out.println(getAlphabetslist());
		getAlphabetslist().stream().forEach(s-> System.out.println(s));
		System.out.println("&&&&&&&&************************8&&&&&&&&7");
		getAlphabetslist().stream().parallel().forEach(s-> System.out.println(s));
		
		System.out.println("&&&&&&&&************************8&&&&&&&&7");
		//Check stream is running in parallel or not
		IntStream range = IntStream.rangeClosed(1, 10);
		range.parallel();
		System.out.println(range.isParallel());
		
		System.out.println("&&&&&&8&&&&&&&&7");
		long ii = Stream.of(1,2,3,4,5,6,7,5,4,3,2,2).filter(s-> s.equals(88)).findAny().orElse(0);
		System.out.println(ii);
		
	}
	
	
	
	public static List<String> getAlphabetslist()
	{
		List<String> alpha = new ArrayList<String>();
		int n =97;
		while(n<=122)
		{
			char c = (char)n;
			alpha.add(String.valueOf(c));
			n++;
		}
		return alpha;
	}

}

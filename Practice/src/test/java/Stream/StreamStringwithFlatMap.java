package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class StreamStringwithFlatMap {

	public static void main(String[] args) {
		
		
		String data[][] = new String[][]
				{
			{"a", "b"},
			{"c", "d"},
			{"e", "f"},
				};
		
		Stream<String[]> dataStream = Arrays.stream(data);
		Stream<String> map = dataStream.flatMap(x-> Arrays.stream(x));
		Stream<String> filter = map.filter(x-> "a".equals(x.toString()));
		filter.forEach(System.out::println);
		
		System.out.println("************alternate******************");
		Stream<String> filter1 = Arrays.stream(data).flatMap(x-> Arrays.stream(x)).filter(x-> "a".equals(x.toString()));
		filter1.forEach(System.out::println);
		
		
		
	}

}

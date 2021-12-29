package RahulSheetyClasses;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamTopic {

	@Test(enabled=false)
	public void regular() 
	{
		String[] arr = {"Akshay", "Bhagat", "Akshay", "Man", "Aksh"};
		
		List<String> ar = new ArrayList<String>();
		ar.add("Aksahay");
		ar.add("Bhagat");
		ar.add("kAl");
		ar.add("Akshay");
		ar.add("Akah");
		
		//Traditional way 
		int count=0;
		for(int i=0;i<ar.size();i++)
		{
			String text = ar.get(i);
			if(text.startsWith("A"))
			{
				count++;
				System.out.println(text);
			}
		}
		System.out.println(count);
	}
	
	@Test(enabled=false)
	public void usingStream() 
	{
		List<String> ar = new ArrayList<String>();
		ar.add("Aksahay");
		ar.add("Bhagat");
		ar.add("kAl");
		ar.add("Akshay");
		ar.add("Akah");
		
		long c = ar.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		
		long s = Stream.of("Akshay", "Bhagat", "Akshay", "Man", "Aksh").filter(k -> k.startsWith("A")).count();
		System.out.println(s);
		
		ar.stream().filter(j-> j.length()>4).forEach(j-> System.out.println(j));
		ar.stream().filter(j-> j.length()>4).limit(1).forEach(j-> System.out.println(j));
		
	}
	
	@Test(enabled=false)
	public void usingStreamMap() 
	{
		List<String> ar = new ArrayList<String>();
		ar.add("Aksahay");
		ar.add("Bhagat");
		ar.add("kAl");
		ar.add("Akshay");
		ar.add("Akah");
		
		ar.stream().filter(s-> s.endsWith("y")).map(s-> s.toUpperCase()).forEach(s-> System.out.println(s));
		System.out.println("::::::::::::;");
		ar.stream().map(s-> s.toUpperCase()).sorted().filter(s-> s.startsWith("A")).forEach(s->System.out.println(s));
		System.out.println("::::::::::::;");
		
		List<String> an = Arrays.asList("Akshay", "Bhagat", "Akshay", "Man", "Aksh");
		
		//Merge to string
		Stream<String> newStream = Stream.concat(ar.stream(), an.stream());
//		newStream.sorted().forEach(s-> System.out.println(s));
//		System.out.println("::::::::::::;");
		
		boolean sta = newStream.anyMatch(s-> s.matches("Akshay"));
		Assert.assertTrue(sta);
		System.out.println(sta);
		System.out.println("::::::::::::;");
	}
	
	@Test
	public void usingStreamCollcet() 
	{
		
		List<String> ar = new ArrayList<String>();
		ar.add("Aksahay");
		ar.add("Bhagat");
		ar.add("kAl");
		ar.add("Akshay");
		ar.add("Akah");
		
//		List<String> a = ar.stream().filter(s-> s.startsWith("k")).map(s-> s.toUpperCase()).collect(Collectors.toList());
//		System.out.println(a.get(0));
		
		
		//alternate way of above
		ar.stream().filter(s->s.startsWith("k")).map(s->s.toUpperCase()).limit(1).forEach(s-> System.out.println(s));
		
		
		List<Integer> values = Arrays.asList(6,1,2,3,4,5,5);
		
		values.stream().distinct().sorted().forEach(s-> System.out.println(s));
		
//		long k = values.stream().filter(s-> s>1).count();
//		System.out.println(k);
		
	}
	@Test
	public void desortingByDurga() 
	{
		List<Integer> ar = new ArrayList<Integer>();
		ar.add(2);
		ar.add(25);
		ar.add(26);
		ar.add(62);
		ar.add(72);
		//method of desorting
		System.out.println("------------");
		//ar.stream().sorted().forEach(s->System.out.println(s));
		List<Integer> i= ar.stream().sorted((i1,i2)->((i1<i2)?1:(i1>i2)?-1:0)).collect(Collectors.toList());
		System.out.println(i);
		System.out.println("------------");
		
		//Another method of desorting
		System.out.println("&&&&&&&&&&&");
		//ar.stream().sorted().forEach(s->System.out.println(s));
		List<Integer> k= ar.stream().sorted((i1,i2)->-i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println(k);
		System.out.println("&&&&&&&&&&&");
		
		
		//Another method of desorting
				System.out.println("&&&&&&&&&&&");
				//ar.stream().sorted().forEach(s->System.out.println(s));
				List<Integer> o= ar.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList());
				System.out.println(o);
				System.out.println("&&&&&&&&&&&");
	}
	@Test
	public void desortingOfStringByDurga() 
	{
		List<String> ar = new ArrayList<String>();
		ar.add("Aksahay Bhagat");
		ar.add("Bhagat");
		ar.add("kAl");
		ar.add("Akshay");
		ar.add("Akah");
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
		List<String> o=ar.stream().sorted().collect(Collectors.toList());
		System.out.println(o);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
		
		List<String> l=ar.stream().sorted((s1,s2)-> s2.compareTo(s1)).collect(Collectors.toList());
		System.out.println(l);
		
	}
	
	@Test
	public void sortingByLengthByDurga() 
	{
		List<String> ar = new ArrayList<String>();
		ar.add("Bhagat");
		ar.add("AAA");
		ar.add("AA");
		ar.add("Akshay");
		ar.add("A");
		
		Comparator<String> c= (s1,s2)->
		{
			int l1=s1.length();
			int l2=s2.length();
			if(l1<l2)
				return -1;
			else if(l1>l2)
				return 1;
			else
				return s1.compareTo(s2);
		};
		
		List<String> h = ar.stream().sorted(c).collect(Collectors.toList());
		System.out.println(h);
	}
	
	@Test
	public void minElementInArray() 
	{
		List<Integer> ar = new ArrayList<Integer>();
		ar.add(2);
		ar.add(25);
		ar.add(26);
		ar.add(62);
		ar.add(72);
		
//		Integer min = ar.stream().min((s1,s2)-> s1.compareTo(s2)).get();
//		System.out.println(min);
//		
//		Integer max = ar.stream().max((s1,s2)-> s1.compareTo(s2)).get();
//		System.out.println(max);
//		
		Integer min = ar.stream().min((s1,s2)-> -s1.compareTo(s2)).get();
		System.out.println(min);
		
		Integer max = ar.stream().max((s1,s2)-> -s1.compareTo(s2)).get();
		System.out.println(max);
	}
	@Test
	public void printValuse() 
	{
		List<Integer> ar = new ArrayList<Integer>();
		ar.add(2);
		ar.add(25);
		ar.add(26);
		ar.add(62);
		ar.add(72);
		ar.add(46);
		
		//print as it is value
		ar.stream().forEach(System.out::println);
		
		Consumer<Integer> c= i->{
			System.out.println("The square of "+i+" is "+(i*i));
		};
		ar.stream().forEach(c);
	}
	
	@Test
	public void toArrayConversion() 
	{
		List<Integer> ar = new ArrayList<Integer>();
		ar.add(2);
		ar.add(25);
		ar.add(26);
		ar.add(62);
		ar.add(72);
		ar.add(46);
		
		//Array is too fast************************************************
		Integer[] l= ar.stream().toArray(Integer[]::new);
//		for(Integer i1:l)
//		{
//			System.out.println(i1);
//		}
		
//		for(int i=l.length-1;i>=0;i--)
//		{
//			System.out.println(l[i]);
//		}
		
		Stream.of(l).forEach(System.out::println);
		
		Stream.of(l).sorted((i1,i2)->((i1<i2)?1:(i1>i2)?-1:0)).forEach(System.out::println);
		
		Stream<Integer> s = Stream.of(9,99,999,9999,999);
		s.forEach(System.out::println);

	}
	
	@Test(priority=100)
	public void evenNumbers() 
	{
		System.out.println("This is from naveen");
		List<Integer> y = Stream.of(1,2,3,4,5,6,7,8,9,10).filter(s-> s%2==0).collect(Collectors.toList());
		System.out.println(y.size());
		long g = y.stream().mapToInt(s->s).sum();
		System.out.println(g);
		
		
		int z = Stream.of(1,2,3,4,5,6,7,8,9,10).filter(s-> s%2==0).mapToInt(s->s).sum();
		System.out.println(z);
	}
	
	
	@Test(priority=101)
	public void appendString() 
	{
		Stream.of("Akshay", "Vaibhav").map(s-> s+" Bhagat").forEach(s-> System.out.println(s));
		
		
	}
	
	
	 
		
		
}

package com.ps.redirection.lambda_practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectMethodInStream {
	public static void main(String[] args) {

		 List<Student> students = new ArrayList<>();
	        students.add(new Student("Alice", 24, 80));
	        students.add(new Student("Eve", 22, 96));
	        students.add(new Student("Alice", 20, 90));
	        students.add(new Student("Eve", 22, 94));
	        students.add(new Student("Bob", 22, 91));
	        students.add(new Student("David", 20, 72));
	        students.add(new Student("Charlie", 21, 85));
	        students.add(new Student("Charlies", 22, 96));
	        students.add(null);  // Null entry in List
	        
	        List<Student> filterStudent =students.stream().filter(Objects::nonNull ).collect(Collectors.toList());
	        System.out.println(filterStudent);
	        
	       //this throws java.lang.IllegalStateException: Duplicate key 24 
//		   Map<String,Integer> studentMap = students.stream().filter(Objects::nonNull ).collect(Collectors.toMap(s->s.getName(), s->s.getAge()));

	        //Handled Duplicate key exceptions
	       Map<String,Integer> studentMap = students.stream().filter(Objects::nonNull )
	    		   .collect(Collectors.toMap(s->s.getName(), s->s.getAge(),(oldValue,newValue)->newValue));
	       System.out.println(studentMap);
	       
	       //Grouping by name
	       Map<String,List<Student>> groupingByName= students.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Student::getName));
	       System.out.println("groupingByName - "+groupingByName);
	       
	       //count the no of students by name 
	       Map<String ,Long> studentCountByname = students.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
	       System.out.println("studentCountByname - "+studentCountByname);
	
	       //calculate average marks of student by name
	       Map<String ,Double> studentMarksAvgByname = students.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Student::getName,Collectors.averagingLong(Student::getMarks)));
	       System.out.println("studentMarksAvgByname - "+studentMarksAvgByname);
	
	       //find second highest marks
//	       Integer studentMarksSecondHighest = students.stream().filter(Objects:: nonNull).map(s->s.getMarks()).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

	       //Find that student object which has second highest marks
	       Optional<Student> studentMarksSecondHighest =students.stream()
	       .filter(Objects::nonNull)
	       .collect(Collectors.toCollection(
	           () -> new TreeSet<>(Comparator.comparing(Student::getMarks,Comparator.reverseOrder()))
	       ))
	       .stream().skip(1).findFirst();
	       System.out.println("studentMarksSecondHighest  - "+ studentMarksSecondHighest);
	       
//----------------------------------------OR------------------------------------------
	       //Find that student object which has second highest marks
	       Optional<Student> studentMarksSecondHighest2 =students.stream()
	    	       .filter(Objects::nonNull)
	    	       .collect(Collectors.toCollection(
	    	           () -> new TreeSet<>(  (a,b)->-Integer.valueOf(a.getMarks()).compareTo(Integer.valueOf(b.getMarks())))
	    	    		   ))
	    	       
	    	       .stream().skip(1).findFirst();
	       System.out.println("studentMarksSecondHighest2   ---"+studentMarksSecondHighest2.get());
	       
//		       TreeSet<Student> studentst = new TreeSet<>((a,b)->{
//	    	   Integer a1 = a.getMarks();
//	    	   Integer b1 = b.getMarks();
//	    	   return -a.compareTo(b);
//	       });
//	       TreeSet<Student> studentst = new TreeSet<>(Comparator.comparing(Student::getName,Comparator.reverseOrder()));
//	       studentst.add(new Student("Alice", 24, 80));
//	       studentst.add(new Student("Eve", 22, 96));
//	       studentst.add(new Student("Alice", 20, 90));
//	       studentst.add(new Student("Eve", 22, 94));
//	       studentst.add(new Student("Bob", 22, 91));
//	       studentst.add(new Student("David", 20, 72));
//	       studentst.add(new Student("Charlie", 21, 85));
//	       studentst.add(new Student("Charlies", 22, 96));
//	       System.out.println(studentst);
	    
	     //Find that student object which has second highest marks whose name is Alice
	       Optional<Student> studentMarksSecondHighest4 =students.stream()
	    	       .filter(e-> Objects.nonNull(e) && e.getName() =="Alice"  )
	    	       .collect(Collectors.toCollection(
	    	           () -> new TreeSet<>(  (a,b)->-Integer.valueOf(a.getMarks()).compareTo(Integer.valueOf(b.getMarks())))
	    	    		   ))
	    	       
	    	       .stream().skip(1).findFirst();
	       System.out.println("studentMarksSecondHighest4  -"+studentMarksSecondHighest4.get());
	       
	     //Find that student object which has second highest marks with each name 
		Map<String, Optional<Student>> result = students
				.stream().filter(
						Objects::nonNull)
				.collect(
						Collectors
								.groupingBy(Student::getName,
										Collectors
												.collectingAndThen(
														Collectors
																.toCollection(
																		() -> new TreeSet<>((a,
																				b) -> -Integer.valueOf(a.getMarks())
																						.compareTo(Integer.valueOf(
																								b.getMarks())))),
														set -> set.stream().skip(1).findFirst())));
	System.out.println(result);
	
	}
}

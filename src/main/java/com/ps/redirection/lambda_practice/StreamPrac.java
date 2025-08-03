package com.ps.redirection.lambda_practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ps.lambda.lecture3.StreamPractice.Student;

//class Student {
//	 private String name;
//	    private int age;
//	    private int marks;
//
//	    public Student(String name, int age, int marks) {
//	        this.name = name;
//	        this.age = age;
//	        this.marks = marks;
//	    }
//
//	    public String getName() { return name; }
//	    public int getAge() { return age; }
//	    public int getMarks() { return marks; }
//
//		@Override
//		public String toString() {
//			StringBuilder builder = new StringBuilder();
//			builder.append("Student [name=");
//			builder.append(name);
//			builder.append(", age=");
//			builder.append(age);
//			builder.append(", marks=");
//			builder.append(marks);
//			builder.append("]");
//			return builder.toString();
//		}
//
//
//
//}

class Student implements Comparable<Student>{
	 private String name;
	    private int age;
	    private int marks;

	    public Student(String name, int age, int marks) {
	        this.name = name;
	        this.age = age;
	        this.marks = marks;
	    }

	    public String getName() { return name; }
	    public int getAge() { return age; }
	    public int getMarks() { return marks; }

	    @Override
	    public String toString() {
	        return name + " - Age: " + age + ", Marks: " + marks;
	    }

		@Override
		public int compareTo(Student std) {
			
			return  this.name.compareTo(std.name);
		}
		
		
//		Don't override like this as it will recursively call itself which will give Stack overflow Exception
//		@Override
//		public int compareTo(Student std) {
//			return  this.compareTo(std);
//		}
}

public class StreamPrac {

	public static void main(String[] args) {

		
		 List<Student> students = new ArrayList<>();
	        students.add(new Student("Alice", 24, 85));
	        students.add(new Student("Eve", 22, 96));
	        students.add(new Student("Alice", 20, 90));
	        students.add(new Student("Eve", 22, 94));
	        students.add(new Student("Bob", 22, 91));
	        students.add(new Student("David", 20, 72));
	        students.add(new Student("Charlie", 21, 85));
	        students.add(null);  // Null entry in List
	   


//	        throws ClassCastException: if your Student class doesn't implements Comparable<Student>, because stream().sorted() 
//	        (without arguments) relies on natural ordering — which is defined by implementing the Comparable interface as compareTo method not overridden
//	        List<Student> lstudentsComparator2 = students.stream().sorted().collect(Collectors.toList());
	          
//	        if Student class implements Comparable<Student> with overridden compareTo method, because stream().sorted() 
//	        (without arguments) relies on natural ordering — which is defined by implementing the Comparable interface.
//	        List<Student> lstudentsComparator2 = students.stream().sorted().collect(Collectors.toList()); //this will give null pointer exception as list has null value
//	        System.out.println(lstudentsComparator2);
	        
	        //this handles null pointer exception
//	        List<Student> lstudentsComparator2 = students.stream().sorted(Comparator.nullsFirst(Comparator.naturalOrder())).collect(Collectors.toList());
//	        List<Student> lstudentsComparator2 = students.stream().sorted(Comparator.nullsFirst(Comparator.reverseOrder())).collect(Collectors.toList());
//	        System.out.println(lstudentsComparator2);  
      
//	        // Sort using comparator
//	        Comparator<Student> studentComparator = Comparator
//	                .comparing(Student::getName);//natural sorting by name
//	        students.sort(studentComparator); //this will give null pointer exception as list contains null value
//	        students.sort((a, b) -> a.getName().compareTo(b.getName()));//both are same and this will give null pointer exception
//	        System.out.println("sortedstudents-"+students);

	        //method to avoid Null pointer Exception
//	        Comparator<Student> studentComparator = Comparator
//	                .comparing(Student::getName);//natural sorting by name
//	        students.sort(Comparator.nullsFirst(studentComparator));//this will handle null pointer exception
//	        // Print sorted list
//	        System.out.println("Sorted Students:----------"+ students);
//	        students.forEach(System.out::println);
	        
	        
//          Comparator<Student> studentComparator1 = Comparator
//	                .comparing(Student::getName);//natural sorting by name
          
        //it wont handle null pointer Exception if entry is null in list
//	      List<Student> lstudentsComparator1x = students.stream().sorted(studentComparator1).collect(Collectors.toList()); 
//	      System.out.println(lstudentsComparator1x);
   
          //This will handle null pointer Exception if entry is null in list
//          List<Student> lstudentsComparator1 = students.stream().sorted(Comparator.nullsFirst(studentComparator1)).collect(Collectors.toList());
//	       System.out.println(lstudentsComparator1);
//	
//	       
//	       Comparator<Student> studentComparator1b = Comparator.comparing(Student::getName) //natural sorting by name
//           		.thenComparing(Student::getAge, (s1, s2) -> s1 < s2 ? -1 : s1 > s2 ? 1 : 0);//if names are same then natural sort by age
//	       List<Student> lstudentsComparator1b = students.stream().sorted(Comparator.nullsFirst(studentComparator1b)).collect(Collectors.toList());
//	       System.out.println(lstudentsComparator1b);
	       

//	        Comparator<Student> studentComparator1c = 
//	    		 Comparator.comparing(Student::getName)//natural sorting by name
//	    		 Comparator.comparing(Student::getName, (s1,s2)->-s1.compareTo(s2))//reverse of natural sorting order
//	    		 Comparator.comparing(Student::getName,Comparator.naturalOrder()) // natural sorting order
//	    		 Comparator.comparing(Student::getName,Comparator.reverseOrder())//reverse of natural sorting order
//	    		 .thenComparing(Student::getAge, (s1, s2) -> s1 < s2 ? -1 : s1 > s2 ? 1 : 0)//if names are same then reversed natural sort by age
//          		.thenComparing(Student::getMarks,(s1, s2) -> s1 < s2 ? -1 : s1 > s2 ? 1 : 0);//if names and age both are same then natural sort by marks
//
//	       List<Student> lstudentsComparator1c = students.stream().sorted(Comparator.nullsFirst(studentComparator1c)).collect(Collectors.toList());
//	       System.out.println(lstudentsComparator1c);
//	       
//	       
//	       Comparator<Student> studentComparator2 = Comparator
//	                .comparing(Student::getName)//natural sorting by name
//	                .thenComparing(Student::getAge);//if names are same then natural sort by age
//	       List<Student> lstudentsComparator2 = students.stream().sorted(Comparator.nullsFirst(studentComparator2)).collect(Collectors.toList());
//	       System.out.println(lstudentsComparator2);
//	      
//	       
//	       Comparator<Student> studentComparator3 = Comparator
//	                .comparing(Student::getName)   //natural sorting by name
//	                .thenComparing(Student::getAge)//if names are same then natural sort by age
//	                .thenComparingInt(Student::getMarks);//if names and age both are same then natural sort by marks
//	       List<Student> lstudentsComparator3 = students.stream().sorted(Comparator.nullsFirst(studentComparator3)).collect(Collectors.toList());
//	       System.out.println(lstudentsComparator3);
       
	
	
       
	
	}

}

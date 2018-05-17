package com.rakesh.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentSorting {	
	private static List<Student> stud = null;
	
	private static int compareByCgpa(Student lhs, Student rhs) {
	    if (lhs.cgpa == rhs.cgpa) {
	        return lhs.name.compareTo(rhs.name);	        
	    }	   
	    else if(new Integer(lhs.id).compareTo(new Integer(rhs.id)) > 0)
			  return 1; 
		    else 
		      return -1;   	
	}
	
	private static int compareByName(Student lhs, Student rhs) {
	    if (lhs.name == rhs.name) {
	        return new Integer(lhs.id).compareTo(new Integer(rhs.id));
	    }
	    else if(new Integer(lhs.id).compareTo(new Integer(rhs.id)) > 0)
		  return 1; 
	    else 
	      return -1;		    
	}		
	
	

	public static void main(String[] args) {
		 stud = Arrays.asList(			
				new StudentSorting().new Student(33, "Tina", 3.68),
				new StudentSorting().new Student(85, "Louis", 3.85),
				new StudentSorting().new Student(56, "Samil", 3.75),
				new StudentSorting().new Student(19, "Samar", 3.75),
				new StudentSorting().new Student(22, "Lorry", 3.76)
				);	
		 stud.sort(Comparator.comparing(Student::getId).reversed());			
		 stud.sort(StudentSorting::compareByCgpa);		
		 stud.sort(StudentSorting::compareByName);			
		
		 stud.forEach(System.out::println);
	}	
	
	class Student {
		private int id;
		private String name;
		private double cgpa;		
		
		public Student(int id, String name, double cgpa) {			
			this.id = id;
			this.name = name;
			this.cgpa = cgpa;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getCgpa() {
			return cgpa;
		}

		public void setCgpa(double cgpa) {
			this.cgpa = cgpa;
		}	
		
		@Override
		public String toString() {
			return "Student  Id: " + getId() + ", name: " + getName() + ", CGPA: " + getCgpa();
					
		}		
	}
} 

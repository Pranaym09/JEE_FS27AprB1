package com.doselect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
/*
 * 6. Hiring On!
Description

Specifications:

class Candidate
  data members:
   name: String
   id: int
   age: int
   gender: String
   department: String
   yearOfJoining: int
   salary: double
    visibility: private

  Candidate(int id, String name, int age, String gender, String department, int yearOfJoining, double salary): constructor with public visibility
  Define getter setters with public visibility
  toString() method has been implemented for you 

class Implementation:
 method definition:
  getCount(List<Candidate> list):
   return type: Map<String, Long>
   visibility: public
 
  getAverageAge(List<Candidate> list):
   return type: Map<String, Double>
   visibility: public

  countCandidatesDepartmentWise(List<Candidate> list):
   return type: Map<String, Long>
   visibility: public

  getYoungestCandidateDetails(List<Candidate> list)
   return type: Optional<Candidate> 
   visibility: public
 

Task:

class Candidate:
- define the String variable name
- define the int variable id
- define the int variable age
- define the String variable gender
- define the String variable department
- define the int variable yearOfJoining
- define the double variable salary
-define a constructor and getter setters according to the above specifications
-toString() method has been implemented for you as a part of the code stub
class Implementation:
Implement the below method for this class using in Stream API:
static Map<String, Long> getCount(List<Candidate> list):  get the count of male and female employees from the list, put it into a Map and return the Map
static Map<String, Double> getAverageAge(List<Candidate> list): return the average age of male and female employees
static Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list): count and return the number of employees in each department
static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list): Get the details of youngest male employee in the product development department

Sample Input

 List<Candidate> list = new ArrayList<>();
  list.add(new Candidate(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
  list.add(new Candidate(144, "Scarlet Jhonson", 28, "Male", "Product Development", 2014, 32500.0));
------------------------------------------------
list //Input for all the methdos
 

Sample Output

{Male=1, Female=1}
--------------------------------
{Male=28.0, Female=32.0}
--------------------------------
{Product Development=1, HR=1}
--------------------------------
Optional[Employee [id=144, name=Scarlet Jhonson, age=28, gender=Male, department=Product Development, yearOfJoining=2014, salary=32500.0]]
 
 */

class Candidate{
  //Write Your Code Here..
  private int id;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int yearOfJoining;
	private double salary;
	public Candidate(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
     @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
                + department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
    }
}

class Implementation{
  //Write Your Code Here..
  public static Map<String , Long> getCount(List<Candidate> list){
		return list.stream().collect(Collectors.groupingBy(Candidate::getGender, Collectors.counting()));
	}
	
	public static Map<String , Double> getAverageAge(List<Candidate> list){
		return list.stream().collect(Collectors.groupingBy(Candidate::getGender, Collectors.averagingInt(Candidate::getAge)));
	}
	public static Map<String,Long> countCandidatesDepartmentWise(List<Candidate> list){
		return list.stream().collect(Collectors.groupingBy(Candidate::getDepartment, Collectors.counting()));
	}
	public static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list){
		return list.stream().filter(c->c.getGender().equals("Male")&&c.getDepartment().equalsIgnoreCase("product development")).min(Comparator.comparingInt(Candidate::getAge));
	}
}

public class ExampleSix {
	public static void main(String[] args) {
		List<Candidate> list = new ArrayList<>();
		list.add(new Candidate(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		list.add(new Candidate(144, "Scarlet Jhonson", 28, "Male", "Product Development", 2014, 32500.0));
		System.out.println(Implementation.getCount(list));
		System.out.println(Implementation.getAverageAge(list));
		System.out.println(Implementation.countCandidatesDepartmentWise(list));
		System.out.println(Implementation.getYoungestCandidateDetails(list));
		list.
	}
}

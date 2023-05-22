package com.doselect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import com.doselect.EmployeeInfo.SortMethod;

class Employee{
	
	String name;
	int salary;
	public Employee(String name,int salary) {
		this.name=name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", salary=" + salary + "]";
	}
	
}
class EmployeeInfo{
	public enum SortMethod {
			BYNAME,
			BYSALARY
			
	};
	public List<Employee> sort(List<Employee> emps, final SortMethod method){
		if(method.equals(method.BYNAME)) {
			Collections.sort(emps, (e1,e2)->{return e1.getName().compareTo(e2.getName());});
		}else if(method.equals(method.BYSALARY)) {
			Collections.sort(emps,(e1,e2)->{
                int i =e1.getSalary() - e2.getSalary();
                if(i==0) {
                    return e1.getName().compareTo(e2.getName());
                }
                else {
                    return i;
                }
            });
		}
		return emps;
	}
	public boolean isCharacterPresentInAllNames(Collection<Employee> entities, String character) {
		Predicate<Employee> p1 = e->e.getName().contains(character);
		boolean b = entities.stream().allMatch(p1);
		return b;
	}
}
public class ExampleFive {
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Mickey", 100000));
		emps.add(new Employee("Timmy", 50000));
		emps.add(new Employee("Annny", 40000));
		emps.add(new Employee("Emily", 232334));
		EmployeeInfo ei = new EmployeeInfo();
		System.out.println(ei.isCharacterPresentInAllNames(emps, "E"));
	}
}

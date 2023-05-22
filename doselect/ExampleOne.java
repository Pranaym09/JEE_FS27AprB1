package com.doselect;

import java.util.ArrayList;
import java.util.Collections;

class ArrayListOps{
	public ArrayList<Integer> makeArrayListInt(int n){
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i<n;i++) {
			list.add(0);
		}
		return list;
	}
	
	public ArrayList<Integer> reverseList(ArrayList<Integer> list){
		Collections.reverse(list);
		return list;
	}
	
	public ArrayList<Integer> changeList(ArrayList<Integer> list,int m,int n){
		Collections.replaceAll(list, m, n);
		return list;
	}
}
public class ExampleOne {
public static void main(String[] args) {
	ArrayListOps alo = new ArrayListOps();
	System.out.println(alo.makeArrayListInt(3));
	ArrayList<Integer> list = new ArrayList<>();
	list.add(12);
	list.add(17);
	list.add(31);
	System.out.println(alo.reverseList(list));
	System.out.println(alo.changeList(list, 12, 23));
}
}

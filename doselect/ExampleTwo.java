package com.doselect;

import java.util.ArrayList;
import java.util.HashMap;

class Mobile{
	HashMap <String , ArrayList<String>> mobiles = new HashMap<>();
	
	public String addMobile(String company,String model) {
		ArrayList<String>list;
		if(mobiles.containsKey(company)) {
			list=mobiles.get(company);
		}else {
			list = new ArrayList<String>();
		}
		list.add(model);
		mobiles.put(company, list);
		return "model successfully added";
	}
	public ArrayList<String> getModels(String company){
		if(mobiles.containsKey(company))
			return mobiles.get(company);
		else
			return null;
	}
	public String buyMobile(String company,String model) {
		if(mobiles.containsKey(company)) {
			ArrayList<String> list = mobiles.get(company);
			list.remove(model);
			return "Mobile sold successfully";
		}
		else {
			return "Item not Available";
		}
	}
}
public class ExampleTwo {
	public static void main(String[] args) {
		Mobile obj = new Mobile();
		System.out.println(obj.addMobile("Oppo", "K3")+"\n"+obj.getModels("Oppo")+"\n"+obj.buyMobile("Oppo", "K3"));
	}
}

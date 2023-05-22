package com.doselect;
class Activity{
	  //Implement Activity class here..
	  public String string1;
	  public String string2;
	  public String operator;
	  public Activity(String string1,String string2,String operator){
	    this.string1 = string1;
	    this.string2 = string2;
	    this.operator = operator;
	  }
	}



	public class ExampleThree {
	  //Implement the two function given in description in here...
	  public String handleException(Activity a){
	    try{
	    if(a.string1.equals(null)||a.string2.equals(null)){
	      throw new NullPointerException();
	    }
	    else if(!(a.operator.equals("+")||a.operator.equals("-"))){
	      throw new Exception();
	    }}catch (NullPointerException ne){
	      return "Null values found";
	    }catch (Exception e){
	      return "Default Exception "+ a.operator;
	    }
	    return "No Exception Found";
	  }
	  public String doOperation(Activity a){
	    switch(a.operator){
	      case "+":
	      return a.string1+a.string2;
	      case "-":
	      String str = a.string1.replace(a.string2,"");
	      return str;
	    }
	    return null;
	  }
		// public static void main(String args[] ) throws Exception {
	  //   //Write your own main to check the program...
		// }
	}
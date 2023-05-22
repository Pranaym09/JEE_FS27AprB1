package com.doselect;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class CompanyJobRepository{
public static String getJobPrediction(int age,String highestQualification) throws NotEligibleException{

	if(age<19){
		throw new NotEligibleException("You are underage for any job");
	}else{
	if(age>=26 && highestQualification.equals("M.S")||highestQualification.equals("PhD")){
	return "We have openings for senior developer";
	}
	else if(age>=21 && highestQualification.equals("B.E")){
	return "We have openings for junior developer";
	}else if(age>=19 && !(highestQualification.equals("B.E")||highestQualification.equals("M.S")||highestQualification.equals("PhD"))){
	throw new NotEligibleException("We do not have any job that matches your qualifications");
	}else{
	throw new NotEligibleException("Sorry we have no openings for now");
	}
}

}
}
public class ExampleFour {
 public static void main(String args[] ) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	 ExampleFour ef = new ExampleFour();
	 System.out.println(ef.searchForJob(-3, "PhD"));
 }
public String searchForJob(int age , String highestQualification){
CompanyJobRepository c;
try{
if(age>=200 || age <=0){
throw new NotEligibleException("The age entered is not typical for human being");
}else {
c = new CompanyJobRepository();
return c.getJobPrediction(age,highestQualification);
}
}catch(NotEligibleException e){
return e.getMessage();
}
catch(Exception e){
return e.getMessage();
}
}
}
class NotEligibleException extends Exception {
NotEligibleException(String message){
super(message);
}
}

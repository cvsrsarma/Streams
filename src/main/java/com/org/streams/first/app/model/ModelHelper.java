package com.org.streams.first.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.org.streams.first.app.model.Employee;

public class ModelHelper {
	
	private static int count=0;
	private static List<Employee>arrayList = new ArrayList<Employee>();
	public static List<Employee> getEmployeeList(){
		if(count==0) {
		for(int i=0; i<10; i++) {
			int j= randomInt(3);
			if(j%2==0)
				arrayList.add(getNewMEmp());
			else
				arrayList.add(getNewFEmp());
		}
		}
		return arrayList;
	}
	
	private static Employee getNewMEmp() {
		return new Employee(random(),randomInt(5),randomInt(6),random(),random(),random(),randomInt(2),"M",getDept());
	}
	private static Employee getNewFEmp() {
		return new Employee(random(),randomInt(5),randomInt(6),random(),random(),random(),randomInt(2),"F",getDept());
	}
	private static String getDept() {
		int i= randomInt(9);
		if(i%3==0) {
			return "A";
		} else if(i%3==1) {
			return"B";
		} else {
			return "C";
		}
	}
	static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	static final String AB1="abcdefghijklmnopqrstuvwxyz";
	
	private static String random() {
		
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        salt.append(AB.charAt(rnd.nextInt(AB.length())));
        int length=rnd.nextInt(8);
        if(length<3)
        	length+=3;
        while (salt.length() < length) { // length of the random string.
            int index = rnd.nextInt(AB1.length());
            salt.append(AB1.charAt(index));
        }
        String saltStr = salt.toString();
        
        return saltStr;
	}
	private static int randomInt() {
		String SALTCHARS = "123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) { // length of the random string.
            int index = rnd.nextInt(SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        
        return Integer.parseInt(saltStr);
	}
	private static int randomInt(int s) {
		String SALTCHARS = "123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < s) { // length of the random string.
            int index = rnd.nextInt(SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        
        return Integer.parseInt(saltStr);
	}
	
	public static List<Course> getCourcesList(){
		List<Course> cList = new ArrayList<Course>();
		cList.add(new Course("C1","FrmWrk",89,38373));
		cList.add(new Course("C2","FrmWrk",90,43373));
		cList.add(new Course("C3","Micro",80,858373));
		cList.add(new Course("C4","FrmWrk",83,35373));
		cList.add(new Course("C5","Micro",37,24373));
		cList.add(new Course("C6","Micro",89,56473));
		cList.add(new Course("C7","Micro",96,62373));
		cList.add(new Course("C8","FrmWrk",78,23434));
		cList.add(new Course("C9","FrmWrk",75,453544));
		cList.add(new Course("C10","Micro",72,343456));
		cList.add(new Course("C11","FrmWrk",70,76896));
		cList.add(new Course("C12","Micro",69,64566));
		cList.add(new Course("C13","Micro",79,165745));
		cList.add(new Course("C14","Micro",99,764677));
		return cList;
		
	}
	
	private static List<Student> sList= new ArrayList<Student>();
	
	static {
		for(int i=0; i<21; i++) {
			if(i%3==0)
				sList.add(new Student(random(),i+100,"Maths",randomInt(2)));
			else if(i%3==1)
				sList.add(new Student(random(),i+100,"Physics",randomInt(2)));
			else
				sList.add(new Student(random(),i+100,"Chemistry",randomInt(2)));
		}
	}
	
	public static List<Student> getSList(){
		return sList;
	}
	
}

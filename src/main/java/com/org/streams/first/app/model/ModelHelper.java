package com.org.streams.first.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.org.streams.first.app.model.Employee;

public class ModelHelper {
	
	public static List<Employee> getEmployeeList(){
		List<Employee>arrayList = new ArrayList<Employee>();
		for(int i=0; i<10; i++) {
			arrayList.add(getNewEmp());
		}
		return arrayList;
	}
	
	private static Employee getNewEmp() {
		return new Employee(random(),randomInt(5),randomInt(6),random(),random(),random(),randomInt(2));
	}

	private static String random() {
		String SALTCHARS = "ABCDabcd";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = rnd.nextInt(SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
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
	
	
}

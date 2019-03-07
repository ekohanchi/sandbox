package com.projects.sandbox.solutions;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeClassification {
	
	// name, boss' name, year started, job title
	public static final String employees = 
			"Ann, George, 2009, technical lead\n" +
			"Bob, George,2010, technical lead\n" +
			"Charles, Bob, 2010, developer\n" +
			"Diane, Bob, 2010, developer\n" +
			"Emily, NONE, 2007, CEO\n" +
			"Fred, Emily, 2007, chief marketing officer\n" +
			"George, Emily, 2007, chief technology officer\n" +
			"Harold, Ann, 2014, developer";
	
	// Goal write the code to display the output below based on the employees String above
	// Expected output:
	/*
		Emily: CEO, 2007
		-George: chief technology officer, 2007
		--Ann: technical lead, 2009
		---Harold: developer, 2014
		--Bob: technical lead, 2010
		---Charles: developer, 2010
		---Diane: developer, 2010
		-Fred: chief marketing officer, 2007				
	 */
					
	
	public static void main(String[] args) {
		String[] employeeArray = getEmployeesAsArray();
		Employee boss = buildTee(employeeArray);
		display(boss, 0);		
	}
	
	private static String[] getEmployeesAsArray() {
		String[] employeeArray = employees.split("\\n");
//		for(int i=0; i<employeeArray.length; i++) {
//			System.out.println(employeeArray[i]);
//		}
		return employeeArray;
	}
	
	private static Employee buildTee(String[] employeeArray) {
		HashMap<String, Employee> empMap = new HashMap<String, Employee>();
		Employee ceo = new Employee();
		for(int i=0; i<employeeArray.length; i++) {
			Employee employee = new Employee();
			employee.setName(employeeArray[i].split(",")[0].trim());
			employee.setBoss(employeeArray[i].split(",")[1].trim());
			employee.setYearStarted(Integer.parseInt(employeeArray[i].split(",")[2].trim()));
			employee.setJobTitle(employeeArray[i].split(",")[3].trim());
			empMap.put(employee.getName(), employee);
		}
		
		
		for (Employee child : empMap.values()) {
			String bossName = child.getBoss();
			if (!bossName.equals("NONE")) {
				Employee boss = empMap.get(bossName);
				boss.addChild(child);
			} else {
				ceo = child;
			}
		}
		
		return ceo;
	}
	
	public static void display(Employee emp, int depth) {
		for(int i=0; i<depth; i++) {
			System.out.print("-");
		}
		System.out.print(emp.getName() + ": " + emp.getJobTitle() + ", " + emp.getYearStarted() );
		System.out.println("");
		for (int i=0; i<emp.getChildren().size(); i++) {
			display(emp.getChildren().get(i), depth+1);
		}
	}

}

class Employee {
	String name = "";
	String boss = "";
	int yearStarted;
	String jobTitle = "";
	ArrayList<Employee> children = new ArrayList<Employee>();
	
	public void setName(String nameVal) {
		this.name = nameVal;
	}
	
	public void setBoss(String bossVal) {
		this.boss = bossVal;
	}
	
	public void setYearStarted(int year) {
		this.yearStarted = year;
	}
	
	public void setJobTitle(String jobTitleVal) {
		this.jobTitle = jobTitleVal;
	}

	public String getName() {
		return name;
	}
	
	public String getBoss() {
		return boss;
	}
	
	public int getYearStarted() {
		return yearStarted;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void addChild(Employee child) {
		this.children.add(child);
	}
	
	public ArrayList<Employee> getChildren() {
		return children;
	}
	
	
	
	
}

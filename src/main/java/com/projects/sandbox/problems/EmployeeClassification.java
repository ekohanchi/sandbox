package com.projects.sandbox.problems;

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
		
	}
}

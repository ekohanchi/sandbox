package com.projects.sandbox.problems;

public class EmployeeClassification {
	
	// name, boss' name, year started, job title
	public static final String employees = 
			"Ann, George, 2009, technical lead\n" +
			"Bob, George,2010, technical lead\n" +
			"Charles, Bob, 2010, developer\n" +
			"Diane, Bob, 2010, developer\n" +
			"Emily, NONE, 2007, CEO\n" +
			"Fred, Emily, 2007, cheif marketing officer\n" +
			"George, Emily, 2007, chief technolgoy officer\n" +
			"Harold, Ann, 2014, developer";
	
	// Goal write the code to display the output below based on the employees String above
	// Expected output:
	/*
	 Emily: CEO, 2007
	 -Fred: chief marketing officer, 2008
	 -George: chief technolgoy officer, 2007 
	 --Ann: technical lead, 2009
	 ---Harold: developer, 2014
	 --Bob: technical lead, 2010
	 ---Charles: developer, 2010
	 ---Diane: develop, 2010
	 */
					
	
	public static void main(String[] args) {
		
	}

}

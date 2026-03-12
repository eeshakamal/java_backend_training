package com.ab;
import java.time.LocalDate;
import java.time.Period;
import java.time.LocalTime;
//java Time API
import java.util.Vector;
public class Demo4 {
	public static void main(String[] args) {
		//today date
		//LocalDate today = LocalDate.now();
		//employee joining date
		LocalDate joiningDate = LocalDate.of(2020, 5, 15);
		//System.out.println("Today's date: " + today);
		//System.out.println("Employee Joining Date: " + joiningDate);
		// number of months and year of experience
//		int yearsOfExperience = today.getYear() - joiningDate.getYear();
//		int monthsOfExperience = today.getMonthValue() - joiningDate.getMonthValue();
//		if (monthsOfExperience < 0) {
//			yearsOfExperience--;
//			monthsOfExperience += 12;
//		}
//		System.out.println("Years of Experience: " + yearsOfExperience);
//		System.out.println("Months of Experience: " + monthsOfExperience);
		
		LocalDate today = LocalDate.now();
		Period experience = Period.between(joiningDate, today);
		System.out.println("Exper" + experience.getYears() + "-- years " + experience.getMonths());
		//current date nd time with the predefined 
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current Date: " + currentDate);
		LocalTime currentTime = LocalTime.now();
		System.out.println("Current Time: " + currentTime);
		
			
		
		
		
	}

}
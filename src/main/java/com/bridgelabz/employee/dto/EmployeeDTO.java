package com.bridgelabz.employee.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO 
{
	
	private String employeeName;
	private String employeeGender;
	private String employeeDepartment;
	private double employeeSalary;
	private LocalDate employeeStartDate;
	private String employeeNotes;	
	
}

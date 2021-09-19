package com.bridgelabz.employee.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.bridgelabz.employee.dto.EmployeeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "employee_tbl")
public class EmployeeEntity 
{
	@Id
	@GeneratedValue()
	private int id;
	@Pattern(regexp = "^[A-Z][a-z]{2,15}$")
	private String employeeName;
	@Pattern(regexp = "^[A-Za-z]{3,}$")
	private String employeeGender;
	@Pattern(regexp = "^[A-Z][a-z]{2,15}$")
	private String employeeDepartment;
//	@Pattern(regexp = "^[0-9]{5,}$")
	private double employeeSalary;
	private LocalDate employeeStartDate;
	private String employeeNotes;
	
	public EmployeeEntity(EmployeeDTO dto) {
		super();
		this.employeeName = dto.getEmployeeName();
		this.employeeGender = dto.getEmployeeGender();
		this.employeeDepartment = dto.getEmployeeDepartment();
		this.employeeSalary = dto.getEmployeeSalary();
		this.employeeStartDate = dto.getEmployeeStartDate();
		this.employeeNotes = dto.getEmployeeNotes();
	}	
	
	
}

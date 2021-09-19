package com.bridgelabz.employee.service;

import java.util.List;

import com.bridgelabz.employee.dto.EmployeeDTO;
import com.bridgelabz.employee.model.EmployeeEntity;

public interface IEmployeeService
{
	public abstract List<EmployeeEntity> getEmployeePayRollData();
	public abstract EmployeeEntity getEmployeePayRollData(int id);
	public abstract EmployeeEntity addRecord(EmployeeDTO dto);
	public abstract EmployeeEntity updateRecord(int id,EmployeeDTO dto);
	public abstract EmployeeEntity deleteRecord(int id);
}

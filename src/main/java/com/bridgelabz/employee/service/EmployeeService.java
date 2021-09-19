package com.bridgelabz.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employee.dto.EmployeeDTO;
import com.bridgelabz.employee.exception.ChangesNotAppliedException;
import com.bridgelabz.employee.exception.CustomException;
import com.bridgelabz.employee.exception.EmptyRecordsException;
import com.bridgelabz.employee.exception.NotFoundException;
import com.bridgelabz.employee.model.EmployeeEntity;
import com.bridgelabz.employee.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeEntity> getEmployeePayRollData() 
	{
		long numberOfRecords = employeeRepository.count();
		if (numberOfRecords == 0) 
		{
			throw new EmptyRecordsException("There is no data present:");
		}
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeEntity getEmployeePayRollData(int id)
	{
		return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found NoSuchElementExption"));
	}

	@Override
	public EmployeeEntity addRecord(EmployeeDTO dto) 
	{
		List<EmployeeEntity> employee = employeeRepository.findAll();
		EmployeeEntity entity = new EmployeeEntity(dto);
	
		if (employee.contains(entity.getId())) 
		{
			throw new ChangesNotAppliedException("The Employee Id has already been exist");
		}
		
		else
		{
			EmployeeEntity employeeEntity = new EmployeeEntity(dto);
			employeeRepository.save(employeeEntity);
			return null;
		}
	}

	@Override
	public EmployeeEntity updateRecord(int id, EmployeeDTO dto) 
	{
		EmployeeEntity entity = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found NoSuchElementException"));
		if(dto.getEmployeeDepartment().isBlank() && dto.getEmployeeGender().isBlank() && dto.getEmployeeName().isBlank() && dto.getEmployeeNotes().isBlank() && dto.getEmployeeStartDate().equals(null))
		{
			 throw new ChangesNotAppliedException("Some entity remains empty in the record");
		}
		else 
		{
			BeanUtils.copyProperties(dto, entity);
			employeeRepository.save(entity);
		}		
		return null;
	}

	@Override
	public EmployeeEntity deleteRecord(int id) 
	{
		employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found NoSuchElementException"));
		employeeRepository.deleteById(id);
		return null;
	}

}

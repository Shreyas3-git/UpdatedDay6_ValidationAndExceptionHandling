package com.bridgelabz.employee.builder;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bridgelabz.employee.dto.EmployeeDTO;
import com.bridgelabz.employee.model.EmployeeEntity;

@Component
public class EmployeeBuilder 
{
	public EmployeeEntity addBuilder(EmployeeDTO dto)
	{
		EmployeeEntity entity = new EmployeeEntity(dto);
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}

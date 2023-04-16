package com.demoproject.service;

import java.util.List;

import com.demoproject.entities.Registration;
import com.demoproject.payload.RegistrationDto;

public interface DAOService {
	
	public RegistrationDto saveOneRegistration(RegistrationDto registrationDto);

	public List<RegistrationDto> getAllReg();

	public RegistrationDto getById(long id);

	public RegistrationDto updateById(RegistrationDto registrationDto, long id);

	public void deletedRegById(long id);

	public void saveOneReg(Registration registration);

}

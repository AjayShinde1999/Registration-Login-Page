package com.demoproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.demoproject.entities.Registration;
import com.demoproject.payload.RegistrationDto;
import com.demoproject.repositories.RegistrationRepository;

@Service
public class DAOServiceImpl implements DAOService {

	private RegistrationRepository registrationRepo;
	private ModelMapper mapper;

	public DAOServiceImpl(RegistrationRepository registrationRepo, ModelMapper mapper) {
		this.registrationRepo = registrationRepo;
		this.mapper = mapper;
	}

	@Override
	public RegistrationDto saveOneRegistration(RegistrationDto registrationDto) {
		Registration registration = mapToEntity(registrationDto);
		Registration newRegistration = registrationRepo.save(registration);
		RegistrationDto Dto = mapToDto(newRegistration);
		return Dto;
	}
	
	@Override
	public List<RegistrationDto> getAllReg() {
		List<Registration> findAll = registrationRepo.findAll();
		return findAll.stream().map(x->mapToDto(x)).collect(Collectors.toList());
	}
	
	@Override
	public RegistrationDto getById(long id) {
		Optional<Registration> findById = registrationRepo.findById(id);
		
		if(findById.isPresent()) {
			Registration registration = findById.get();
			return mapToDto(registration);
		} else {
			return null;
		}
	}
	
	@Override
	public RegistrationDto updateById(RegistrationDto registrationDto, long id) {
		Optional<Registration> findById = registrationRepo.findById(id);
		Registration registration = findById.get();
		
		registration.setFirstName(registrationDto.getFirstName());
		registration.setLastName(registrationDto.getLastName());
		registration.setEmail(registrationDto.getEmail());
		registration.setPassword(registrationDto.getPassword());
		Registration updatedReg = registrationRepo.save(registration);
		return mapToDto(updatedReg);
	}
	
	@Override
	public void deletedRegById(long id) {
		registrationRepo.deleteById(id);
	}

	public Registration mapToEntity(RegistrationDto registrationDto) {
		return mapper.map(registrationDto, Registration.class);

	}
	
	public RegistrationDto mapToDto(Registration registration) {
		return mapper.map(registration, RegistrationDto.class);
		
	}

	@Override
	public void saveOneReg(Registration registration) {
		registrationRepo.save(registration);
	}

}

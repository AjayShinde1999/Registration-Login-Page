package com.demoproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.payload.RegistrationDto;
import com.demoproject.service.DAOService;

@RestController
@RequestMapping("/api/register")
public class RegistrationRestController {
	
	private DAOService daoService;

	public RegistrationRestController(DAOService daoService) {
		this.daoService = daoService;
	}
	
	// http://localhost:8080/api/register
	@PostMapping
	public ResponseEntity<RegistrationDto> createOneRegistration(@RequestBody RegistrationDto registrationDto){
		RegistrationDto registrationDto1 = daoService.saveOneRegistration(registrationDto);
		return new ResponseEntity<>(registrationDto1,HttpStatus.CREATED);
	}
	
	// http://localhost:8080/api/register
	@GetMapping
	public List<RegistrationDto> getAllRegistration(){
		return daoService.getAllReg();
	}
	
	// http://localhost:8080/api/register/1
	@GetMapping("/{id}")
	public ResponseEntity<RegistrationDto> getRegistrationById(@PathVariable("id") long id){
		RegistrationDto dto = daoService.getById(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	// http://localhost:8080/api/register/1
	@PutMapping("/{id}")
	public ResponseEntity<RegistrationDto> updateRegistrationById(@RequestBody RegistrationDto registrationDto, @PathVariable("id") long id){
		RegistrationDto updateById = daoService.updateById(registrationDto,id);
		return new ResponseEntity<>(updateById, HttpStatus.OK);
	}
	
	// http://localhost:8080/api/register/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRegistrationById(@PathVariable("id") long id){
		daoService.deletedRegById(id);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	}

}

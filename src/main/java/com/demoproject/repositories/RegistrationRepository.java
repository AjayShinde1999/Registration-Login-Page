package com.demoproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	
	Registration findByEmail(String email);

}

package com.jprestes.repositories;

import com.jprestes.domain.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    // Additional query methods can be defined here if needed
}

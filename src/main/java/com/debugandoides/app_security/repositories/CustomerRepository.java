package com.debugandoides.app_security.repositories;

import com.debugandoides.app_security.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, BigDecimal> {

    Optional<CustomerEntity> findByEmail(String email);
}

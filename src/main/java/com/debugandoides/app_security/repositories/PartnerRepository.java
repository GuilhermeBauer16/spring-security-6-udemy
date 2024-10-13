package com.debugandoides.app_security.repositories;

import com.debugandoides.app_security.model.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface PartnerRepository extends JpaRepository<PartnerEntity, BigDecimal> {

    Optional<PartnerEntity> findByClientId(String clientId);
}

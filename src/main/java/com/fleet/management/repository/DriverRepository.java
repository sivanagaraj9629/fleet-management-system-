package com.fleet.management.repository;

import com.fleet.management.entity.Driver;
import com.fleet.management.enums.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    // License number-ஆ வச்சு driver கண்டுபிடிக்கிறது
    Optional<Driver> findByLicenseNumber(String licenseNumber);

    // Status-ஆ வச்சு drivers கண்டுபிடிக்கிறது
    List<Driver> findByStatus(DriverStatus status);

    // License number இருக்கான்னு check பண்ணுறது
    boolean existsByLicenseNumber(String licenseNumber);

    // பெயர்ல search பண்ணுறது (case-insensitive)
    List<Driver> findByNameContainingIgnoreCase(String name);
}
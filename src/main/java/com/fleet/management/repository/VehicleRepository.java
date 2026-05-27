package com.fleet.management.repository;

import com.fleet.management.entity.Vehicle;
import com.fleet.management.enums.MaintenanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // License plate-ஆ வச்சு vehicle கண்டுபிடிக்கிறது
    Optional<Vehicle> findByLicensePlate(String licensePlate);

    // Maintenance status-ஆ வச்சு vehicles கண்டுபிடிக்கிறது
    List<Vehicle> findByMaintenanceStatus(MaintenanceStatus status);

    // License plate இருக்கான்னு check பண்ணுறது
    boolean existsByLicensePlate(String licensePlate);
}
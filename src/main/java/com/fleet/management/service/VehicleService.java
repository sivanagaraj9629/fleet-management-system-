package com.fleet.management.service;

import com.fleet.management.dto.VehicleDTO;
import com.fleet.management.entity.Vehicle;
import com.fleet.management.enums.MaintenanceStatus;
import com.fleet.management.exception.DuplicateResourceException;
import com.fleet.management.exception.ResourceNotFoundException;
import com.fleet.management.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    /**
     * புதிய vehicle register பண்ணுதல்
     */
    @Transactional
    public Vehicle registerVehicle(VehicleDTO dto) {
        // License plate ஏற்கனவே இருக்கான்னு check
        if (vehicleRepository.existsByLicensePlate(dto.getLicensePlate())) {
            throw new DuplicateResourceException(
                    "Vehicle with license plate " + dto.getLicensePlate() + " already exists"
            );
        }

        // DTO-ஐ Entity-ஆ மாத்துதல்
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setCapacityKg(dto.getCapacityKg());
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setMaintenanceStatus(MaintenanceStatus.ACTIVE);
        vehicle.setLastServiceDate(dto.getLastServiceDate());

        return vehicleRepository.save(vehicle);
    }

    /**
     * எல்லா vehicles-ஐயும் எடுத்துக்குறது
     */
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * ID-ஆ வச்சு vehicle எடுத்துக்குறது
     */
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Vehicle not found with id: " + id
                ));
    }

    /**
     * Available vehicles மட்டும் எடுத்துக்குறது
     */
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findByMaintenanceStatus(MaintenanceStatus.ACTIVE);
    }

    /**
     * Maintenance status-ஐ update பண்ணுதல்
     */
    @Transactional
    public Vehicle updateMaintenanceStatus(Long id, MaintenanceStatus status) {
        Vehicle vehicle = getVehicleById(id);
        vehicle.setMaintenanceStatus(status);
        return vehicleRepository.save(vehicle);
    }

    /**
     * Vehicle-ஐ delete பண்ணுதல்
     */
    @Transactional
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicle not found with id: " + id);
        }
        vehicleRepository.deleteById(id);
    }
}
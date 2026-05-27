package com.fleet.management.controller;

import com.fleet.management.dto.VehicleDTO;
import com.fleet.management.entity.Vehicle;
import com.fleet.management.enums.MaintenanceStatus;
import com.fleet.management.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    /**
     * POST /api/vehicles - புதிய vehicle register பண்ணுதல்
     */
    @PostMapping
    public ResponseEntity<Vehicle> registerVehicle(@Valid @RequestBody VehicleDTO dto) {
        Vehicle vehicle = vehicleService.registerVehicle(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

    /**
     * GET /api/vehicles - எல்லா vehicles-ஐயும் எடுத்துக்குறது
     */
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    /**
     * GET /api/vehicles/{id} - ஒரு vehicle-ஐ ID-ஆ வச்சு எடுத்துக்குறது
     */
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    /**
     * GET /api/vehicles/available - Available vehicles மட்டும்
     */
    @GetMapping("/available")
    public ResponseEntity<List<Vehicle>> getAvailableVehicles() {
        return ResponseEntity.ok(vehicleService.getAvailableVehicles());
    }

    /**
     * PATCH /api/vehicles/{id}/maintenance - Maintenance status update
     */
    @PatchMapping("/{id}/maintenance")
    public ResponseEntity<Vehicle> updateMaintenanceStatus(
            @PathVariable Long id,
            @RequestParam MaintenanceStatus status) {

        Vehicle updated = vehicleService.updateMaintenanceStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /api/vehicles/{id} - Vehicle-ஐ delete பண்ணுதல்
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
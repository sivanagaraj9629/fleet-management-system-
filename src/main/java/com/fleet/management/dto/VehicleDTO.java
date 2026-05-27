package com.fleet.management.dto;

import com.fleet.management.enums.MaintenanceStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long id;

    @NotBlank(message = "License plate is required")
    @Pattern(regexp = "^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$",
            message = "License plate format should be: TN01AB1234")
    private String licensePlate;

    @DecimalMin(value = "0.0", message = "Capacity must be positive")
    private BigDecimal capacityKg;

    @NotBlank(message = "Vehicle type is required")
    private String vehicleType;

    private MaintenanceStatus maintenanceStatus;

    private LocalDate lastServiceDate;
}
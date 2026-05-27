package com.fleet.management.repository;

import com.fleet.management.entity.DeliveryTask;
import com.fleet.management.entity.Driver;
import com.fleet.management.entity.Vehicle;
import com.fleet.management.enums.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryTaskRepository extends JpaRepository<DeliveryTask, Long> {

    // Status-ஆ வச்சு tasks கண்டுபிடிக்கிறது
    List<DeliveryTask> findByStatus(DeliveryStatus status);

    // Vehicle-ஆ வச்சு tasks கண்டுபிடிக்கிறது
    List<DeliveryTask> findByVehicle(Vehicle vehicle);

    // Driver-ஆ வச்சு tasks கண்டுபிடிக்கிறது
    List<DeliveryTask> findByDriver(Driver driver);

    // Multiple IDs மற்றும் status-ஆ வச்சு கண்டுபிடிக்கிறது
    List<DeliveryTask> findByIdInAndStatus(List<Long> ids, DeliveryStatus status);

    // Status-ஆ வச்சு count பண்ணுறது
    long countByStatus(DeliveryStatus status);
}
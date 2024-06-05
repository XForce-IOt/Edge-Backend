package com.xforce.edge.infraestructure.persistence.jpa.repositories;

import com.xforce.edge.domain.model.entities.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
}

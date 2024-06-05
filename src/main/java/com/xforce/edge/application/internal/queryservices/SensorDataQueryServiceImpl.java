package com.xforce.edge.application.internal.queryservices;

import com.xforce.edge.domain.model.entities.SensorData;
import com.xforce.edge.domain.model.queries.GetAllSensorDataQuery;
import com.xforce.edge.domain.model.queries.GetSensorDataByIdQuery;
import com.xforce.edge.domain.services.SensorDataQueryService;
import com.xforce.edge.infraestructure.persistence.jpa.repositories.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorDataQueryServiceImpl implements SensorDataQueryService {
    private final SensorDataRepository sensorDataRepository;

    public SensorDataQueryServiceImpl(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @Override
    public Optional<SensorData> handle(GetSensorDataByIdQuery query) {
        return sensorDataRepository.findById(query.sensorDataId());
    }

    @Override
    public List<SensorData> handle(GetAllSensorDataQuery query) {
        return sensorDataRepository.findAll();
    }
}

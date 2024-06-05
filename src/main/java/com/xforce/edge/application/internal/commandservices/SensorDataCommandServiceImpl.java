package com.xforce.edge.application.internal.commandservices;

import com.xforce.edge.domain.model.commands.CreateSensorDataCommand;
import com.xforce.edge.domain.model.commands.DeleteSensorDataCommand;
import com.xforce.edge.domain.model.entities.SensorData;
import com.xforce.edge.domain.services.SensorDataCommandService;
import com.xforce.edge.infraestructure.persistence.jpa.repositories.SensorDataRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorDataCommandServiceImpl implements SensorDataCommandService {

    private final SensorDataRepository sensorDataRepository;

    public SensorDataCommandServiceImpl(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @Override
    public Long handle(CreateSensorDataCommand command) {
        var sensorData = new SensorData(String.valueOf(command.temperature()),
                String.valueOf(command.humidity()),
                String.valueOf(command.distance()),
                String.valueOf(command.pulse()));
        sensorDataRepository.save(sensorData);
        return sensorData.getId();
    }

    @Override
    public void handle(DeleteSensorDataCommand command) {
        if (!sensorDataRepository.existsById(command.sensorDataId())) {
            throw new IllegalArgumentException("Sensor data not found");
        }
        sensorDataRepository.deleteById(command.sensorDataId());
    }
}

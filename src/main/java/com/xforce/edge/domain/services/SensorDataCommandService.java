package com.xforce.edge.domain.services;

import com.xforce.edge.domain.model.commands.CreateSensorDataCommand;
import com.xforce.edge.domain.model.commands.DeleteSensorDataCommand;

public interface SensorDataCommandService {
    Long handle(CreateSensorDataCommand command);
    void handle(DeleteSensorDataCommand command);
}

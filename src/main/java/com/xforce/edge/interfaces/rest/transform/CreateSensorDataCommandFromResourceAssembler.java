package com.xforce.edge.interfaces.rest.transform;

import com.xforce.edge.domain.model.commands.CreateSensorDataCommand;
import com.xforce.edge.interfaces.rest.resources.CreateSensorDataResource;

public class CreateSensorDataCommandFromResourceAssembler {
    public static CreateSensorDataCommand toCommandFromResource(CreateSensorDataResource resource) {
        double temperature = Double.parseDouble(resource.temperature());
        double humidity = Double.parseDouble(resource.humidity());
        double distance = Double.parseDouble(resource.distance());
        double pulse = Double.parseDouble(resource.pulse());
        return new CreateSensorDataCommand(temperature, humidity, distance, pulse);
    }
}

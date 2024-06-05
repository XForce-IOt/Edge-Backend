package com.xforce.edge.interfaces.rest.transform;

import com.xforce.edge.domain.model.entities.SensorData;
import com.xforce.edge.interfaces.rest.resources.SensorDataResource;

public class SensorDataResourceFromEntityAssembler {
    public static SensorDataResource toResourceFromEntity(SensorData entity) {
        return new SensorDataResource(entity.getId(), String.valueOf(entity.getTemperature()), String.valueOf(entity.getHumidity()), String.valueOf(entity.getDistance()), String.valueOf(entity.getPulse()));
    }
}

package com.xforce.edge.domain.services;

import com.xforce.edge.domain.model.entities.SensorData;
import com.xforce.edge.domain.model.queries.GetAllSensorDataQuery;
import com.xforce.edge.domain.model.queries.GetSensorDataByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SensorDataQueryService {
    Optional<SensorData> handle(GetSensorDataByIdQuery query);
    List<SensorData> handle(GetAllSensorDataQuery query);
}

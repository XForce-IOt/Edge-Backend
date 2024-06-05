package com.xforce.edge.interfaces.rest;

import com.xforce.edge.domain.model.queries.GetAllSensorDataQuery;
import com.xforce.edge.domain.model.queries.GetSensorDataByIdQuery;
import com.xforce.edge.domain.services.SensorDataCommandService;
import com.xforce.edge.domain.services.SensorDataQueryService;
import com.xforce.edge.interfaces.rest.resources.CreateSensorDataResource;
import com.xforce.edge.interfaces.rest.resources.SensorDataResource;
import com.xforce.edge.interfaces.rest.transform.CreateSensorDataCommandFromResourceAssembler;
import com.xforce.edge.interfaces.rest.transform.SensorDataResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/sensor_data", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sensor Data", description = "Sensor Data Management Endpoints")
public class SensorDataController {
    private final SensorDataQueryService sensorDataQueryService;
    private final SensorDataCommandService sensorDataCommandService;

    public SensorDataController(SensorDataQueryService sensorDataQueryService, SensorDataCommandService sensorDataCommandService) {
        this.sensorDataQueryService = sensorDataQueryService;
        this.sensorDataCommandService = sensorDataCommandService;
    }

    @PostMapping
    public ResponseEntity<SensorDataResource> createSensorData(@RequestBody CreateSensorDataResource resource) {
        var createSensorDataCommand = CreateSensorDataCommandFromResourceAssembler.toCommandFromResource(resource);
        var sensorDataId = sensorDataCommandService.handle(createSensorDataCommand);
        if (sensorDataId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSensorDataByIdQuery = new GetSensorDataByIdQuery(sensorDataId);
        var sensorData = sensorDataQueryService.handle(getSensorDataByIdQuery);

        if (sensorData.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var sensorDataResource = SensorDataResourceFromEntityAssembler.toResourceFromEntity(sensorData.get());
        return new ResponseEntity<>(sensorDataResource, HttpStatus.CREATED);
    }
    @GetMapping("/{sensorDataId}")
    public ResponseEntity<SensorDataResource> getSensorDataById(@PathVariable Long sensorDataId) {
        var getSensorDataByIdQuery = new GetSensorDataByIdQuery(sensorDataId);
        var sensorData = sensorDataQueryService.handle(getSensorDataByIdQuery);
        if (sensorData.isEmpty()) return ResponseEntity.badRequest().build();
        var sensorDataResource = SensorDataResourceFromEntityAssembler.toResourceFromEntity(sensorData.get());
        return ResponseEntity.ok(sensorDataResource);
    }
    @GetMapping
    public ResponseEntity<List<SensorDataResource>> getAllSensorData() {
        var getAllSensorDataQuery = new GetAllSensorDataQuery();
        var sensorData = sensorDataQueryService.handle(getAllSensorDataQuery);
        var sensorDataResources = sensorData.stream().map(SensorDataResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(sensorDataResources);
    }
}

package com.xforce.edge.interfaces.rest.resources;

public record SensorDataResource(
        Long id,
        String temperature,
        String humidity,
        String distance,
        String pulse
) {
}

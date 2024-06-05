package com.xforce.edge.interfaces.rest.resources;

public record CreateSensorDataResource(
        String temperature,
        String humidity,
        String distance,
        String pulse
) {
}

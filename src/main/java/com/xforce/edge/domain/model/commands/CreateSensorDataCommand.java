package com.xforce.edge.domain.model.commands;

public record CreateSensorDataCommand(
        double temperature,
        double humidity,
        double distance,
        double pulse) {
}

package com.xforce.edge.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class SensorData extends AbstractAggregateRoot<SensorData> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Column(nullable = false)
    private double temperature;

    @Getter
    @Column(nullable = false)
    private double humidity;

    @Getter
    @Column(nullable = false)
    private double distance;

    @Getter
    @Column(nullable = false)
    private double pulse;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public SensorData(String temperature, String humidity, String distance, String pulse) {
        this.temperature = Double.parseDouble(temperature);
        this.humidity = Double.parseDouble(humidity);
        this.distance = Double.parseDouble(distance);
        this.pulse = Double.parseDouble(pulse);
    }

    public SensorData() {}
}

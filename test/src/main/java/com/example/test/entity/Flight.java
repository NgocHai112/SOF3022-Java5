package com.example.test.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "Flights")
public class Flight {

    @Id
    @Column(name = "FlightID")
    private Integer flightID;

    @Column(name = "Airline")
    private String airline;

    @Column(name = "DepartureCity")
    private String departureCity;

    @Column(name = "ArrivalCity")
    private String arrivalCity;

    @Column(name = "DepartureTime")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date departureTime;

    @Column(name = "ArrivalTime")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date arrivalTime;
}

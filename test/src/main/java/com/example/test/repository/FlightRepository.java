package com.example.test.repository;

import com.example.test.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findAllByAirlineContainingIgnoreCase(String airline);
}

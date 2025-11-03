package com.example.test.service;

import com.example.test.entity.Flight;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> findAll();
    Optional<Flight> findById(Integer id);
    Flight save(Flight flight);
    void deleteById(Integer id);
    List<Flight> search(String keyword);
}

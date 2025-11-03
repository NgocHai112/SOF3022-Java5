package com.example.test.service;

import com.example.test.entity.Flight;
import com.example.test.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository repo;

    @Override
    public List<Flight> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Flight> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Flight save(Flight flight) {
        return repo.save(flight);
    }

    @Override
    public void deleteById(Integer id) {

        repo.deleteById(id);
    }

    @Override
    public List<Flight> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return repo.findAll();
        }
        if (keyword.matches("\\d+")) {
            List<Flight> list = new ArrayList<>();
            repo.findById(Integer.parseInt(keyword)).ifPresent(list::add);
            return list;
        }
        return repo.findAllByAirlineContainingIgnoreCase(keyword);
    }
}

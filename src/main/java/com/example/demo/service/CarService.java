package com.example.demo.service;

import com.example.demo.dto.request.CreateCarRequest;
import com.example.demo.dto.request.UpdateCarRequest;
import com.example.demo.dto.response.CarResponse;

import java.util.List;

public interface CarService {

    CarResponse getById(Integer id);

    List<CarResponse> getAll();

    void create(CreateCarRequest createCarRequest);

    CarResponse update(UpdateCarRequest updateCarRequest);

    void delete(Integer id);
}

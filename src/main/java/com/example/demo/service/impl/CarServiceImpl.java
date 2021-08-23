package com.example.demo.service.impl;

import com.example.demo.domain.Car;
import com.example.demo.dto.request.CreateCarRequest;
import com.example.demo.dto.request.UpdateCarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.mapper.CarDtoToEntityMapper;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarDtoToEntityMapper carDtoToEntityMapper;

    @Override
    public CarResponse getById(Integer id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car with id " + id + " not found"));
        return carDtoToEntityMapper.carEntityToDto(car);
    }

    @Override
    public List<CarResponse> getAll() {
        List<Car> list = carRepository.findAll();
        List<CarResponse> all = new ArrayList<>();
        for(Car car : list) {
            all.add(carDtoToEntityMapper.carEntityToDto(car));
        }
        return all;
    }

    @Override
    public void create(CreateCarRequest createCarRequest) {
        Car newCar = carDtoToEntityMapper.carDtoToEntity(createCarRequest);
        carRepository.save(newCar);
    }

    @Override
    public CarResponse update(UpdateCarRequest updateCarRequest) {
        Car car = carRepository.findById(updateCarRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Car with id " + updateCarRequest.getId() + " not found"));
        car.setFuel(updateCarRequest.getFuel());
        car.setMilage(updateCarRequest.getMilage());
        carRepository.save(car);
        return carDtoToEntityMapper.carEntityToDto(car);
    }

    @Override
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}

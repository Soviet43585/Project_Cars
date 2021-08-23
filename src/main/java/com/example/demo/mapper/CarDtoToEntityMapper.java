package com.example.demo.mapper;

import com.example.demo.domain.Car;
import com.example.demo.dto.request.CreateCarRequest;
import com.example.demo.dto.response.CarResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDtoToEntityMapper {

    Car carDtoToEntity(CreateCarRequest createCarRequest);

    CarResponse carEntityToDto(Car car);
}

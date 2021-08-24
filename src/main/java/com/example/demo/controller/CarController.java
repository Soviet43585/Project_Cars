package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.request.CreateCarRequest;
import com.example.demo.dto.request.UpdateCarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.security.UserPrincipal;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class CarController {

    private final CarService carService;

    @GetMapping("/all")
    public List<CarResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(carService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarResponse> add(@RequestBody CreateCarRequest createCarRequest) {
        if (createCarRequest == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            carService.create(createCarRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<CarResponse> update(@RequestBody UpdateCarRequest updateCarRequest) {
        return new ResponseEntity<>(carService.update(updateCarRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarResponse> delete(@PathVariable Integer id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

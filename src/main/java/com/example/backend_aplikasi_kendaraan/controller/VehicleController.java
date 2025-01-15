package com.example.backend_aplikasi_kendaraan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_aplikasi_kendaraan.dto.VehicleDto;
import com.example.backend_aplikasi_kendaraan.service.VehicleService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public List<VehicleDto> getMethodName() {
        List<VehicleDto> listVehicle = vehicleService.getVehicles();

        return listVehicle;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> postVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto vehicleSaved = vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>(vehicleSaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{registrationNumber}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String registrationNumber) {
        vehicleService.DeleteVehicle(registrationNumber);
        return new ResponseEntity<>("vehicle successfull deleted", HttpStatus.OK);
    }

    @GetMapping("/{registrationNumber}")
    public ResponseEntity<VehicleDto> getMethodName(@PathVariable String registrationNumber) {
        VehicleDto vehicle = vehicleService.getVehicleById(registrationNumber);
        if (vehicle == null) {
            throw new RuntimeException("Vehicle not found for id: " + registrationNumber);
        }
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

}

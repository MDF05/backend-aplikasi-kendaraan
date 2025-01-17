package com.example.backend_aplikasi_kendaraan.controller;

import java.time.Year;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_aplikasi_kendaraan.dto.VehicleDto;
import com.example.backend_aplikasi_kendaraan.service.VehicleService;

import lombok.RequiredArgsConstructor;

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
        int year = Year.now().getValue();

        System.out.println(year);

        if (vehicleDto.getYear() > year)
            throw new RuntimeException("Vehicle dto must under 2025");
        if (vehicleDto.getYear() < 1000)
            throw new RuntimeException("Vehicle dto must up to 1000 years");

        VehicleDto existVehicle = vehicleService.getVehicleById(vehicleDto.getRegistrationNumber());
        if (existVehicle != null)
            throw new RuntimeException("Vehicle already exists");

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

package com.example.backend_aplikasi_kendaraan.controller;

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
        VehicleDto vehicleSaved = vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>(vehicleSaved, HttpStatus.CREATED);
    }
}

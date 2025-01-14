package com.example.backend_aplikasi_kendaraan.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_aplikasi_kendaraan.service.VehicleService;

import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private VehicleService vehicleService;

    public String getMethodName() {
        return new String("asu");
    }

}

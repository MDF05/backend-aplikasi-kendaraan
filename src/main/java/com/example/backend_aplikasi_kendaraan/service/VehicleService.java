package com.example.backend_aplikasi_kendaraan.service;

import java.util.List;

import com.example.backend_aplikasi_kendaraan.dto.VehicleDto;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);

    List<VehicleDto> getVehicles();

    VehicleDto DeleteVehicle(String registrationNumber);

}

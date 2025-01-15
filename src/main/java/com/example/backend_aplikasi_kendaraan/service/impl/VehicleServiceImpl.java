package com.example.backend_aplikasi_kendaraan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.backend_aplikasi_kendaraan.dto.VehicleDto;
import com.example.backend_aplikasi_kendaraan.entity.Vehicle;
import com.example.backend_aplikasi_kendaraan.mapper.VehicleMapper;
import com.example.backend_aplikasi_kendaraan.repository.VehicleRepository;
import com.example.backend_aplikasi_kendaraan.service.VehicleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto);
        Vehicle vehicleSaved = vehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDto(vehicleSaved);
    }

    @Override
    public List<VehicleDto> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(VehicleMapper::mapToVehicleDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto DeleteVehicle(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be null or empty.");
        }

        Vehicle vehicle = vehicleRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Vehicle with registration number " + registrationNumber + " does not exist."));

        vehicleRepository.delete(vehicle);

        return VehicleMapper.mapToVehicleDto(vehicle);
    }

    @Override
    public VehicleDto getVehicleById(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be null or empty.");
        }

        Vehicle vehicle = vehicleRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Vehicle with registration number " + registrationNumber + " does not exist."));

        return VehicleMapper.mapToVehicleDto(vehicle);

    }

}

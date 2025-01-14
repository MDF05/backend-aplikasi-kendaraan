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

    private VehicleRepository vehicleRepository;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto);
        Vehicle vehicleSaved = vehicleRepository.save(vehicle);

        return VehicleMapper.mapToVehicleDto(vehicleSaved);
    }

    @Override
    public List<VehicleDto> getVehicles() {
        // Ambil semua entitas Vehicle dari repository
        List<Vehicle> vehicles = vehicleRepository.findAll();

        // Konversi dari List<Vehicle> ke List<VehicleDto> menggunakan Stream API
        return vehicles.stream()
                .map(VehicleMapper::mapToVehicleDto) // Mapping menggunakan VehicleMapper
                .collect(Collectors.toList());
    }

}

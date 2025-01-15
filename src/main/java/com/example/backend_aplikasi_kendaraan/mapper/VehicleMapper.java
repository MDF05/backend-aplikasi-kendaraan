package com.example.backend_aplikasi_kendaraan.mapper;

import com.example.backend_aplikasi_kendaraan.dto.VehicleDto;
import com.example.backend_aplikasi_kendaraan.entity.Vehicle;

public class VehicleMapper {
    public static VehicleDto mapToVehicleDto(Vehicle vehicle) {
        return new VehicleDto(
                vehicle.getRegistrationNumber(),
                vehicle.getOwnerName(),
                vehicle.getAddress(),
                vehicle.getVehicleMerk(),
                vehicle.getYear(),
                vehicle.getCylinderCapacity(),
                vehicle.getFuelType(),
                vehicle.getColor());

    }

    public static Vehicle mapToVehicle(VehicleDto vehicle) {
        return new Vehicle(
                vehicle.getRegistrationNumber(),
                vehicle.getOwnerName(),
                vehicle.getAddress(),
                vehicle.getVehicleMerk(),
                vehicle.getYear(),
                vehicle.getCylinderCapacity(),
                vehicle.getFuelType(),
                vehicle.getColor());

    }
}

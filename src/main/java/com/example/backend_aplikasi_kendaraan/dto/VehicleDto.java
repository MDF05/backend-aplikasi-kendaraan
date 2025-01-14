package com.example.backend_aplikasi_kendaraan.dto;

import com.example.backend_aplikasi_kendaraan.entity.Vehicle.Color;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private String registrationNumber;
    private String ownerName;
    private String address;
    private int year;
    private int cylinderCapacity;
    private String fuelType;
    private Color color;
}

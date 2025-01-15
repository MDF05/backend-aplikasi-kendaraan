package com.example.backend_aplikasi_kendaraan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")

public class Vehicle {
    public enum Color {
        red, black, blue, grey
    }

    @Id
    @Column(name = "registration_number", nullable = false, unique = true)
    private String registrationNumber;
    @Column(name = "owner_name")
    private String ownerName;
    private String address;
    @Column(name = "vehicle_merk")
    private String vehicleMerk;
    @Column(name = "year_realese")
    private int year;
    @Column(name = "cylinder_capacity")
    private int cylinderCapacity;
    private String fuelType;
    private Color color;

}
package com.example.backend_aplikasi_kendaraan.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.backend_aplikasi_kendaraan.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
        

}

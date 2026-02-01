package com.example.SmartPark.repository;

import com.example.SmartPark.model.ParkingLot;
import com.example.SmartPark.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ParkingDataStore {

    public final Map<String, ParkingLot> parkingLots = new HashMap<>();
    public final Map<String, Vehicle> vehicles = new HashMap<>();
    public final Map<String, String> parkedVehicles = new HashMap<>();
}

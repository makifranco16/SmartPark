package com.example.SmartPark.service;

import com.example.SmartPark.model.ParkingLot;
import com.example.SmartPark.model.Vehicle;
import com.example.SmartPark.repository.ParkingDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    @Autowired
    private final ParkingDataStore store;

    public ParkingService(ParkingDataStore store) {
        this.store = store;
    }

    public void registerParkingLot(ParkingLot lot) {
        store.parkingLots.put(lot.getLotId(), lot);
    }

    public void registerVehicle(Vehicle vehicle) {
        store.vehicles.put(vehicle.getLicensePlate(), vehicle);
    }

    public void checkIn(String lotId, String licensePlate) {
        ParkingLot lot = store.parkingLots.get(lotId);

        if (lot == null)
            throw new RuntimeException("Parking lot not found");

        if (lot.getAvailableSpaces() == 0)
            throw new RuntimeException("Parking lot is full");

        if (store.parkedVehicles.containsKey(licensePlate))
            throw new RuntimeException("Vehicle already parked");

        lot.setOccupiedSpaces(lot.getOccupiedSpaces() + 1);
        store.parkedVehicles.put(licensePlate, lotId);
    }

    public void checkOut(String licensePlate) {
        String lotId = store.parkedVehicles.remove(licensePlate);

        if (lotId == null)
            throw new RuntimeException("Vehicle not parked");

        ParkingLot lot = store.parkingLots.get(lotId);
        lot.setOccupiedSpaces(lot.getOccupiedSpaces() - 1);
    }

    public ParkingLot getLotStatus(String lotId) {
        return store.parkingLots.get(lotId);
    }

    public List<Vehicle> getVehiclesInLot(String lotId) {
        return store.parkedVehicles.entrySet().stream()
                .filter(e -> e.getValue().equals(lotId))
                .map(e -> store.vehicles.get(e.getKey()))
                .collect(Collectors.toList());
    }

}

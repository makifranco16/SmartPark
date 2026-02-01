package com.example.SmartPark.controller;

import com.example.SmartPark.model.ParkingLot;
import com.example.SmartPark.model.Vehicle;
import com.example.SmartPark.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class SmartParkController {

    @Autowired
    private ParkingService service;

//    public void ParkingController(ParkingService service) {
//        this.service = service;
//    }
//
//    public SmartParkController(ParkingService service) {
//        this.service = service;
//    }

    @GetMapping("/test")
    public String test() {
        return "Test working API";
    }

    @PostMapping("/lot")
    public void registerLot(@RequestBody ParkingLot lot) {
        service.registerParkingLot(lot);
    }

    @PostMapping("/vehicle")
    public void registerVehicle(@RequestBody Vehicle vehicle) {
        service.registerVehicle(vehicle);
    }

    @PostMapping("/checkin")
    public void checkIn(
            @RequestParam String lotId,
            @RequestParam String licensePlate) {
        System.out.println(lotId + " ??? " +licensePlate);
        service.checkIn(lotId, licensePlate);
    }

    @PostMapping("/checkout")
    public void checkOut(@RequestParam String licensePlate) {
        service.checkOut(licensePlate);
    }

    @GetMapping("/lot/{lotId}")
    public ParkingLot lotStatus(@PathVariable String lotId) {
        return service.getLotStatus(lotId);
    }

    @GetMapping("/lot/{lotId}/vehicles")
    public List<Vehicle> vehiclesInLot(@PathVariable String lotId) {
        return service.getVehiclesInLot(lotId);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();
    }
}

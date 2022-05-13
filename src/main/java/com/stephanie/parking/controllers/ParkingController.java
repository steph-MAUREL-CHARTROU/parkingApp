package com.stephanie.parking.controllers;

import com.stephanie.parking.models.Parking;
import com.stephanie.parking.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping( path="/api/parkings", method = RequestMethod.GET)
    public List<Parking> getListParking() {
        return parkingService.getListParkings();
    }
}

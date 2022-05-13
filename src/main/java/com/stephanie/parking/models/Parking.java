package com.stephanie.parking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parking {
    private String name;
    private int nbPlaces;
    private int nbAvailablePlaces;
    private String status;
    private String updateTime;


}

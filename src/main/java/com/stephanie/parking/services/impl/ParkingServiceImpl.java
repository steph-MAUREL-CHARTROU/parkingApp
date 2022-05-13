package com.stephanie.parking.services.impl;

import com.stephanie.parking.DAO.ParkingAPIDAO;
import com.stephanie.parking.DAO.entities.RecordEntity;
import com.stephanie.parking.DAO.entities.ResponseParkingAPIEntity;
import com.stephanie.parking.models.Parking;
import com.stephanie.parking.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    public ParkingAPIDAO parkingAPIDAO;

    @Override
    public List<Parking> getListParkings() {
        ResponseParkingAPIEntity response = parkingAPIDAO.getListParkings();
        return transformEntityToModel(response);
    }

    private List<Parking> transformEntityToModel(ResponseParkingAPIEntity response) {
        List<Parking> result = new ArrayList<Parking>();
        for (RecordEntity record : response.getRecords()) {
            Parking parking = new Parking();
            parking.setName(record.getFields().getGrpNom());
            parking.setStatus(getLibelleStatut(record));
            parking.setNbAvailablePlaces(record.getFields().getDisponibilite());
            parking.setUpdateTime(getTimeParsed(record));
            result.add(parking);
        }
        return result;
    }

    private String getTimeParsed(RecordEntity record) {

        OffsetDateTime timeParsed = OffsetDateTime.parse(record.getFields().getGrpHorodatage());
        OffsetDateTime timeParsedPlus2h = timeParsed.withOffsetSameInstant(ZoneOffset.of("+02:00"));
        return timeParsedPlus2h.getHour() + "h" + timeParsedPlus2h.getMinute();
    }

    private String getLibelleStatut(RecordEntity record) {

        switch (record.getFields().getGrpStatut()) {
            case "1": {
                return "FERME";
            }
            case "2": {
                return "ABONNENEMENT UNIQUEMENT";
            }
            case "5": {
                return "OUVERT";
            }
        }
        return "DONNEES NON DISPONIBLES";
    }
}

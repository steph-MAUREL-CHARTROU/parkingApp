package com.stephanie.parking.DAO.impl;

import com.stephanie.parking.DAO.ParkingAPIDAO;
import com.stephanie.parking.DAO.entities.ResponseParkingAPIEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ParkingAPIDAOImpl implements ParkingAPIDAO {

    @Autowired
    private RestTemplate restTemplate;
    private static final String URL_API_OPENDATA = "https://data.nantesmetropole.fr/api/records/1.0/search/?dataset=244400404_parkings-publics-nantes-disponibilites&q=&facet=grp_nom&facet=grp_statut";

    @Override
    public ResponseParkingAPIEntity getListParkings() {
        return restTemplate.getForEntity(URL_API_OPENDATA, ResponseParkingAPIEntity.class).getBody();
    }
}

package com.stephanie.parking.DAO.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseParkingAPIEntity {
 @JsonProperty(value = "records")
    public List<RecordEntity> records;
}

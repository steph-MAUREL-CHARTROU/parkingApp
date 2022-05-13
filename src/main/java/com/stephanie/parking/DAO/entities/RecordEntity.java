package com.stephanie.parking.DAO.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordEntity {
    @JsonProperty(value = "fields")
    private FieldsEntity fields;


}

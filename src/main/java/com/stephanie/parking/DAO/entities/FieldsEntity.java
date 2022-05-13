package com.stephanie.parking.DAO.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldsEntity {

    @JsonProperty( value = "idobj")
    private String idObj;

    @JsonProperty( value = "grp_nom")
    private String grpNom;

    @JsonProperty( value = "grp_exploitation")
    private int grpExploitation;

    @JsonProperty( value = "disponibilite")
    private int disponibilite;

    @JsonProperty( value = "grp_statut")
    private String grpStatut;

    @JsonProperty( value = "grp_horodatage")
    private String grpHorodatage;

}

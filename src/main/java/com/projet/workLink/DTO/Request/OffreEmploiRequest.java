package com.projet.workLink.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OffreEmploiRequest {

    private String titre;
    private String description;
    private LocalDate dateCreation;
    private LocalDate dateLimiteDepot;
    private UUID idEmployeur;
    private String lieu;
    private String typeEmploi;

}

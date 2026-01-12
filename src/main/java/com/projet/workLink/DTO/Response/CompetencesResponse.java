package com.projet.workLink.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetencesResponse {
    private String titre;
    private String libelle;
    //private UUID idUtilisateur;
}

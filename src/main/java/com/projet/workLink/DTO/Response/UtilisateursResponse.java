package com.projet.workLink.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UtilisateursResponse {
    private UUID trackingId;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
}

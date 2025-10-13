package com.projet.workLink.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Inscription {
    private String nom;
    private String prenom;
    private String email;
    private String motDepasse;
    private String telephone;
}

package com.projet.workLink.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Employeur {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private UUID trackingId;
    private String nomEntreprise;
    //private Secteur secteur;
    private String logo;
    private boolean etat;
}

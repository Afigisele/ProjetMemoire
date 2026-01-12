package com.projet.workLink.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employeur {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID trackingId;
    private String nomEntreprise;
    @Enumerated(EnumType.STRING)
    private Secteur secteur;
    private String logo;
    private UUID idUtilisateurs;
    private boolean etat;
}

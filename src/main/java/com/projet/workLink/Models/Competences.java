package com.projet.workLink.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Competences {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID trackingId;
    private String titre;
    private String libelle;

    private UUID idDemandeur;
}

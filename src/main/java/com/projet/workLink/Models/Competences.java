package com.projet.workLink.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Competences {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID trackingId;
    private String titre;
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "id_demandeur_trackinh_id")
    public Demandeur idDemandeur;
}

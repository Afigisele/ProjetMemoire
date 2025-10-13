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
public class Demandeur {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private UUID trackinhId;
    private String cv;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur_id")
    public Utilisateurs idUtilisateur;
}

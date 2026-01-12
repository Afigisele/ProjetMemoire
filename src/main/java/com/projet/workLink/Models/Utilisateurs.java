package com.projet.workLink.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID trackingId;
    private String nom;
    private String prenom;
    private String email;
    private String motDepasse;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private Roles roles;


}

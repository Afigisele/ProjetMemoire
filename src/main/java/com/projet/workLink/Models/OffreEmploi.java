package com.projet.workLink.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OffreEmploi {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID trackingId;
    private String titre;
    private String description;
    private LocalDate dateCreation;
    private LocalDate dateLimiteDepot;
    private String lieu;
    private String type;
}

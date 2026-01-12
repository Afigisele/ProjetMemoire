package com.projet.workLink.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreEmploieResponse {
    private String titre;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateLimiteDepot;
    private UUID idPublier;
}

package com.projet.workLink.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidatureRequest {
    private UUID idDemandeur;
    private UUID offreEmploi;
}

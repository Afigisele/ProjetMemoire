package com.projet.workLink.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidatureResponse {
    private UUID trackingId;
    private UUID idDemandeur;
    private UUID offreEmploi;
}

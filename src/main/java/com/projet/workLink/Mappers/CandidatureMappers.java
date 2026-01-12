package com.projet.workLink.Mappers;

import com.projet.workLink.DTO.Request.CandidatureRequest;
import com.projet.workLink.DTO.Response.CandidatureResponse;
import com.projet.workLink.Models.Candidature;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CandidatureMappers {

    //Recupere les informations chez l'utilisateur et les enregistrer dans la classe Candidature
    public Candidature toEntity(CandidatureRequest candidatureRequest) {
        if (candidatureRequest == null){
            throw new IllegalArgumentException("La requete de candidature ne peux pas etre null");
        }
        return Candidature.builder()
                .trackingId(UUID.randomUUID())
                .idDemandeur(candidatureRequest.getIdDemandeur())
                .idOffreEmploi(candidatureRequest.getOffreEmploi())
                .build();

    }

    //Recuperer les informations de la classe candidatures et les affiche a l'utilisateur
    public CandidatureResponse toResponse(Candidature candidature) {
        if (candidature == null){
            throw new IllegalArgumentException("La candidature ne peux pas etre null");
        }
        return CandidatureResponse.builder()
                .trackingId(candidature.getTrackingId())
                .idDemandeur(candidature.getIdDemandeur())
                .offreEmploi(candidature.getIdOffreEmploi())
                .build();
    }
}

package com.projet.workLink.Mappers;

import com.projet.workLink.DTO.Request.CompetenceRequest;
import com.projet.workLink.DTO.Response.CompetencesResponse;
import com.projet.workLink.Models.Competences;
import com.projet.workLink.Repositories.CompetencesRepositorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompetencesMappers {

    private final CompetencesRepositorie competencesRepositorie;

    @Autowired
    public CompetencesMappers(CompetencesRepositorie competencesRepositorie){
        this.competencesRepositorie=competencesRepositorie;
    }

    // Request -> Entity
    public static Competences toEntity(CompetenceRequest request) {
        return Competences.builder()
                .trackingId(UUID.randomUUID())
                .titre(request.getTitre())
                .libelle(request.getLibelle())
                .idDemandeur(request.getIdDemandeur())
                .build();
    }

    // Entity -> Response
    public static CompetencesResponse toRequest(Competences competence) {
        return CompetencesResponse.builder()
                .titre(competence.getTitre())
                .libelle(competence.getLibelle())
                .build();
    }
}

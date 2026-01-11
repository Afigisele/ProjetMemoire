package com.projet.workLink.Mappers;

import com.projet.workLink.DTO.Request.Inscriptionrequest;
import com.projet.workLink.DTO.Response.UtilisateursResponse;
import com.projet.workLink.Models.Utilisateurs;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InscriptionMappers {

    //méthode pour mapper les informations récuperer chez l'utilisateur vers l'entité utilisateurs
    public Utilisateurs toEntity (Inscriptionrequest inscriptionrequest){
        if(inscriptionrequest == null){
            throw new RuntimeException("inscription request is null");
        }
        return  Utilisateurs.builder()
                .trackingId(UUID.randomUUID())
                .nom(inscriptionrequest.getNom())
                .prenom(inscriptionrequest.getPrenom())
                .email(inscriptionrequest.getEmail())
                .motDepasse(inscriptionrequest.getMotDepasse())
                .telephone(inscriptionrequest.getTelephone())
                .build();
    }

    // méthode pour mapper les informations d'utilisateurs issue de la base de données
    public UtilisateursResponse toResponse (Utilisateurs utilisateurs){
        if(utilisateurs == null){
            throw new RuntimeException("utilisateurs is null");
        }
        return UtilisateursResponse.builder()
                .trackingId(utilisateurs.getTrackingId())
                .nom(utilisateurs.getNom())
                .prenom(utilisateurs.getPrenom())
                .email(utilisateurs.getEmail())
                .telephone(utilisateurs.getTelephone())
                .build();
    }
}

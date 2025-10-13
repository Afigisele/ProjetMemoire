package com.projet.workLink.Mappers;

import com.projet.workLink.DTO.Request.Inscription;
import com.projet.workLink.DTO.Response.UtilisateursResponse;
import com.projet.workLink.Models.Utilisateurs;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InscriptionMappers {

    public Utilisateurs toEntity(Inscription inscription) {
        Utilisateurs utilisateur = new Utilisateurs();
        utilisateur.setTrackingId(UUID.randomUUID());
        utilisateur.setNom(inscription.getNom());
        utilisateur.setPrenom(inscription.getPrenom());
        utilisateur.setEmail(inscription.getEmail());
        utilisateur.setMotDepasse(inscription.getMotDepasse());
        utilisateur.setTelephone(inscription.getTelephone());
        return utilisateur;
    }

    public UtilisateursResponse toResponse(Utilisateurs utilisateur) {
        UtilisateursResponse response = new UtilisateursResponse();
        response.setTrackingId(utilisateur.getTrackingId());
        response.setNom(utilisateur.getNom());
        response.setPrenom(utilisateur.getPrenom());
        response.setEmail(utilisateur.getEmail());
        response.setTelephone(utilisateur.getTelephone());
        return response;
    }
}

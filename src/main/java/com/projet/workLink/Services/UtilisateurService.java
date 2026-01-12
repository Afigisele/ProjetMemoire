package com.projet.workLink.Services;

import com.projet.workLink.DTO.Request.ConnexionRequest;
import com.projet.workLink.DTO.Request.Inscriptionrequest;
import com.projet.workLink.DTO.Response.ConnexionResponse;
import com.projet.workLink.DTO.Response.UtilisateursResponse;

import java.util.UUID;


import java.util.List;
import java.util.UUID;


public interface UtilisateurService {
   UtilisateursResponse enregistrerDemandeur(Inscriptionrequest utilisateurRequestDTO);
   UtilisateursResponse enregistrerEmployeur(Inscriptionrequest inscriptionrequest);
    ConnexionResponse authentifierUtilisateur(ConnexionRequest authRequest);
    void deconnecterUtilisateur(String token);
    UtilisateursResponse getByTrackingId(UUID trackingId);
    List<UtilisateursResponse> getAll();
    UtilisateursResponse update(UUID trackingId,Inscriptionrequest utilisateurRequestDTO);
    void delete(UUID trackingId);
}

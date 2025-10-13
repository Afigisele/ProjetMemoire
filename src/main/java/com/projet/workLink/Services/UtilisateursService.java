package com.projet.workLink.Services;

import com.projet.workLink.DTO.Request.Inscription;
import com.projet.workLink.DTO.Response.UtilisateursResponse;

import java.util.UUID;

public interface UtilisateursService {

    public void supprimerUtilisateur(UUID idUtilisateur);
    public UtilisateursResponse ajouterUtilisateur(Inscription inscriptionRequest);
}

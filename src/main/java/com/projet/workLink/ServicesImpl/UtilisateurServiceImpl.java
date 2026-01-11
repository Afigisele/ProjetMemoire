package com.projet.workLink.ServicesImpl;


import com.projet.workLink.DTO.Request.ConnexionRequest;
import com.projet.workLink.DTO.Request.Inscriptionrequest;
import com.projet.workLink.DTO.Response.ConnexionResponse;
import com.projet.workLink.DTO.Response.UtilisateursResponse;
import com.projet.workLink.Mappers.InscriptionMappers;
import com.projet.workLink.Models.Roles;
import com.projet.workLink.Models.Utilisateurs;
import com.projet.workLink.Repositories.UtilisateurRepository;
import com.projet.workLink.Services.UtilisateurService;
import com.projet.workLink.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder;
    private InscriptionMappers utilisateurMappers;
    private JwtService jwtService;
    private TokenBlacklistService tokenBlacklistService;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder, InscriptionMappers utilisateurMappers, JwtService jwtService, TokenBlacklistService tokenBlacklistService) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.utilisateurMappers = utilisateurMappers;
        this.jwtService = jwtService;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @Override
    public UtilisateursResponse enregistrerDemandeur(Inscriptionrequest utilisateurRequestDTO) {
        //Mapper le request vers l'entité
        Utilisateurs utilisateurs = utilisateurMappers.toEntity(utilisateurRequestDTO);

        //Affecter un role = DEMANDEUR
        utilisateurs.setRoles(Roles.DEMANDEUR);

        //Sauvegarder l'inscription
        utilisateurRepository.save(utilisateurs);

        //Génerer le token pour la connexion
        String tokenDemandeur = jwtService.generateToken(utilisateurs);



        return null;
    }

    @Override
    public UtilisateursResponse enregistrerEmployeur(Inscriptionrequest inscriptionrequest) {
        return null;
    }


    @Override
    public UtilisateursResponse save(Inscriptionrequest dto) {
        // Utilise le mapper pour convertir le DTO en entité
        Utilisateurs utilisateur = utilisateurMappers.toEntity(dto);

        // Définir le rôle ici si nécessaire, car il ne semble pas venir du DTO
        utilisateur.setRoles(Roles.DEMANDEUR);

        // Persiste l'entité
        Utilisateurs saved = utilisateurRepository.save(utilisateur);

        // Génère le token JWT
        String token = jwtService.generateToken(saved);

        // Utilise le mapper pour convertir l'entité en réponse DTO
        UtilisateursResponse responseDTO = utilisateurMappers.toResponse(saved);

        // Si tu veux inclure le token, ajoute-le au DTO (il te faudra un champ dans UtilisateursResponse)
        // responseDTO.setToken(token); // Assure-toi que ce champ existe

        return responseDTO;
    }


    @Override
    public ConnexionResponse authentifierUtilisateur(ConnexionRequest authRequest) {
        Utilisateurs utilisateur = utilisateurRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Email incorrect"));

        if (!passwordEncoder.matches(authRequest.getMotDepasse(), utilisateur.getMotDepasse())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        String token = jwtService.generateToken(utilisateur);

        UtilisateursResponse utilisateurResponse = mapToDTO(utilisateur);

        return new ConnexionResponse(token);
    }


    @Override
    public void deconnecterUtilisateur(String token) {
        tokenBlacklistService.blacklistToken(token);
    }

    @Override
    public UtilisateursResponse getByTrackingId(UUID trackingId) {
        Utilisateurs utilisateur = utilisateurRepository.findByTrackingId(trackingId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        return mapToDTO(utilisateur);
    }

    @Override
    public List<UtilisateursResponse> getAll() {
        return utilisateurRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public UtilisateursResponse update(UUID trackingId, Inscriptionrequest dto) {
        Utilisateurs utilisateur = utilisateurRepository.findByTrackingId(trackingId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMotDepasse(passwordEncoder.encode(dto.getMotDepasse()));
        utilisateur.setTelephone(dto.getTelephone());

        Utilisateurs updated = utilisateurRepository.save(utilisateur);
        return mapToDTO(updated);
    }

    @Override
    public void delete(UUID trackingId) {
        Utilisateurs utilisateur = utilisateurRepository.findByTrackingId(trackingId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        utilisateurRepository.delete(utilisateur);
    }

    //    private UtilisateursResponse mapToDTO(Utilisateurs utilisateur, String token) {
//        UtilisateursResponse dto = new UtilisateursResponse();
//        dto.setNom(utilisateur.getNom());
//        dto.setPrenom(utilisateur.getPrenom());
//        dto.setEmail(utilisateur.getEmail());
//        dto.setTelephone(utilisateur.getTelephone());
//        dto.setTrackingId(utilisateur.getTrackingId());
//        return dto;
//    }

//    private UtilisateursResponse mapToDTO(Utilisateurs utilisateur) {
//        return mapToDTO(utilisateur, null);
//    }

}

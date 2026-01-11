package com.projet.workLink.Controllers;

import com.projet.workLink.DTO.Request.ConnexionRequest;
import com.projet.workLink.DTO.Request.Inscriptionrequest;
import com.projet.workLink.DTO.Response.ConnexionResponse;
import com.projet.workLink.DTO.Response.UtilisateursResponse;
import com.projet.workLink.ServicesImpl.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin("*")
public class UtilisateurController {

    @Autowired
    private UtilisateurServiceImpl utilisateurService;

    @PostMapping("/inscription")
    public ResponseEntity<UtilisateursResponse> inscrire(@RequestBody Inscriptionrequest dto) {
        return ResponseEntity.ok(utilisateurService.save(dto));
    }

    @PostMapping("/connexion")
    public ResponseEntity<ConnexionResponse> connexion(@RequestBody ConnexionRequest authRequest) {
        return ResponseEntity.ok(utilisateurService.authentifierUtilisateur(authRequest));
    }

    @PostMapping("/deconnexion")
    public ResponseEntity<Void> deconnexion(@RequestHeader("Authorization") String bearerToken) {
        String token = bearerToken.startsWith("Bearer ") ? bearerToken.substring(7) : bearerToken;
        utilisateurService.deconnecterUtilisateur(token);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tracking/{trackingId}")
    public ResponseEntity<UtilisateursResponse> getByTrackingId(@PathVariable UUID trackingId) {
        return ResponseEntity.ok(utilisateurService.getByTrackingId(trackingId));
    }

    @GetMapping
    public ResponseEntity<List<UtilisateursResponse>> getAll() {
        return ResponseEntity.ok(utilisateurService.getAll());
    }

    @PutMapping("/{trackingId}")
    public ResponseEntity<UtilisateursResponse> update(
            @PathVariable UUID trackingId,
            @RequestBody Inscriptionrequest dto) {
        return ResponseEntity.ok(utilisateurService.update(trackingId, dto));
    }

    @DeleteMapping("/{trackingId}")
    public ResponseEntity<Void> delete(@PathVariable UUID trackingId) {
        utilisateurService.delete(trackingId);
        return ResponseEntity.noContent().build();
    }
}
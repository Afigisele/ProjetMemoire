package com.projet.workLink.Repositories;

import com.projet.workLink.Models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateurs, Long> {
    Optional<Utilisateurs> findByEmail(String email);
    Optional<Utilisateurs> findByTrackingId(UUID trackingId);
}

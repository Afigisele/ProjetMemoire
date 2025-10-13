package com.projet.workLink.Repositories;

import com.projet.workLink.Models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UtilisateursRepositorie extends JpaRepository<Utilisateurs, Long> {
}

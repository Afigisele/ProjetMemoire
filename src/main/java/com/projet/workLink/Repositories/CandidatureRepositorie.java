package com.projet.workLink.Repositories;

import com.projet.workLink.Models.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepositorie extends JpaRepository<Candidature, Long> {
}

package com.projet.workLink.Repositories;

import com.projet.workLink.Models.Competences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetencesRepositorie extends JpaRepository<Competences, Long> {
}

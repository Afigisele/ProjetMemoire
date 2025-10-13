package com.projet.workLink.Repositories;

import com.projet.workLink.Models.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreEmploiRepositorie extends JpaRepository<OffreEmploi, Long> {
}

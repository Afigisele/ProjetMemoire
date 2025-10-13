package com.projet.workLink.Repositories;

import com.projet.workLink.Models.Demandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeurRepositorie extends JpaRepository<Demandeur, Long> {
}

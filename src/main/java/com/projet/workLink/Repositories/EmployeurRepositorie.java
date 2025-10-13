package com.projet.workLink.Repositories;

import com.projet.workLink.Models.Employeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeurRepositorie extends JpaRepository<Employeur, Long> {
}

package com.championnat.gestion_championnat.repository;

import com.championnat.gestion_championnat.model.Journee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JourneeRepository extends JpaRepository<Journee, Long> {
    // Méthode pour récupérer les journées d'un championnat
    List<Journee> findByChampionnat_Id(Long championnatId);
}

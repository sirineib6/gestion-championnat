package com.championnat.gestion_championnat.repository;

import com.championnat.gestion_championnat.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    // Méthode pour récupérer les équipes d'un championnat
    List<Equipe> findByChampionnats_Id(Long championnatId);
}

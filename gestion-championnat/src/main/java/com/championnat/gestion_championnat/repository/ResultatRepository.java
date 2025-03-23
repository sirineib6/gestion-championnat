package com.championnat.gestion_championnat.repository;

import com.championnat.gestion_championnat.model.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    // Récupérer les résultats d'un championnat
    List<Resultat> findByJournee_Championnat_Id(Long championnatId);

    // Récupérer les résultats d'une journée
    List<Resultat> findByJournee_Id(Long journeeId);
}

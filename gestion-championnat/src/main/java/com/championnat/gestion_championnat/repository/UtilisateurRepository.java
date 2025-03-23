package com.championnat.gestion_championnat.repository;

import com.championnat.gestion_championnat.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findById(Long id);  // Ajout pour récupérer un utilisateur par son ID
}

package com.championnat.gestion_championnat.service;

import com.championnat.gestion_championnat.model.Equipe;
import com.championnat.gestion_championnat.model.Championnat;
import com.championnat.gestion_championnat.repository.EquipeRepository;
import com.championnat.gestion_championnat.repository.ChampionnatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private ChampionnatRepository championnatRepository;

    // 1. Récupérer la liste de toutes les équipes
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    // 2. Récupérer les équipes d'un championnat par ID
    public List<Equipe> getEquipesByChampionnatId(Long championnatId) {
        return equipeRepository.findByChampionnats_Id(championnatId);
    }

    // 3. Récupérer une équipe par son ID
    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Équipe introuvable"));
    }

    // 4. Créer une équipe
    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    // 5. Ajouter une équipe à un championnat
    public Equipe addEquipeToChampionnat(Long equipeId, Long championnatId) {
        Equipe equipe = equipeRepository.findById(equipeId)
                .orElseThrow(() -> new RuntimeException("Équipe introuvable"));
        Championnat championnat = championnatRepository.findById(championnatId)
                .orElseThrow(() -> new RuntimeException("Championnat introuvable"));

        // Ajouter l'équipe au championnat
        equipe.getChampionnats().add(championnat);
        return equipeRepository.save(equipe);
    }

    // 6. Mettre à jour une équipe
    public Equipe updateEquipe(Long id, Equipe equipeDetails) {
        Equipe equipe = equipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Équipe introuvable"));
        equipe.setNom(equipeDetails.getNom());
        equipe.setChampionnats(equipeDetails.getChampionnats()); // Mettre à jour les championnats
        return equipeRepository.save(equipe);
    }

    // 7. Supprimer une équipe
    public void deleteEquipe(Long id) {
        Equipe equipe = equipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Équipe introuvable"));
        equipeRepository.delete(equipe);
    }
}

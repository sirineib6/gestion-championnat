package com.championnat.gestion_championnat.service;

import com.championnat.gestion_championnat.model.Championnat;
import com.championnat.gestion_championnat.repository.ChampionnatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionnatService {

    @Autowired
    private ChampionnatRepository championnatRepository;

    // 1. Récupérer la liste des championnats
    public List<Championnat> getAllChampionnats() {
        return championnatRepository.findAll();
    }

    // 2. Récupérer un championnat par ID
    public Championnat getChampionnatById(Long id) {
        return championnatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Championnat introuvable"));
    }

    // 3. Créer un championnat
    public Championnat createChampionnat(Championnat championnat) {
        return championnatRepository.save(championnat);
    }

    // 4. Mettre à jour un championnat
    public Championnat updateChampionnat(Long id, Championnat championnatDetails) {
        Championnat championnat = championnatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Championnat introuvable"));
        championnat.setNom(championnatDetails.getNom());
        championnat.setEquipes(championnatDetails.getEquipes());
        championnat.setJournees(championnatDetails.getJournees());
        return championnatRepository.save(championnat);
    }

    // 5. Supprimer un championnat
    public void deleteChampionnat(Long id) {
        Championnat championnat = championnatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Championnat introuvable"));
        championnatRepository.delete(championnat);
    }
}

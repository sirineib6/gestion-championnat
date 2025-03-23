package com.championnat.gestion_championnat.service;

import com.championnat.gestion_championnat.model.Journee;
import com.championnat.gestion_championnat.model.Championnat;
import com.championnat.gestion_championnat.repository.JourneeRepository;
import com.championnat.gestion_championnat.repository.ChampionnatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourneeService {

    @Autowired
    private JourneeRepository journeeRepository;

    @Autowired
    private ChampionnatRepository championnatRepository;

    // 1. Récupérer la liste de toutes les journées
    public List<Journee> getAllJournees() {
        return journeeRepository.findAll();
    }

    // 2. Récupérer les journées d'un championnat par ID
    public List<Journee> getJourneesByChampionnatId(Long championnatId) {
        return journeeRepository.findByChampionnat_Id(championnatId);
    }

    // 3. Récupérer une journée par son ID
    public Journee getJourneeById(Long id) {
        return journeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journée introuvable"));
    }

    // 4. Créer une journée pour un championnat
    public Journee createJournee(Long championnatId, Journee journee) {
        Championnat championnat = championnatRepository.findById(championnatId)
                .orElseThrow(() -> new RuntimeException("Championnat introuvable"));
        journee.setChampionnat(championnat); // Associer la journée au championnat
        return journeeRepository.save(journee);
    }

    // 5. Mettre à jour une journée
    public Journee updateJournee(Long id, Journee journeeDetails) {
        Journee journee = journeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journée introuvable"));
        journee.setDate(journeeDetails.getDate());
        journee.setChampionnat(journeeDetails.getChampionnat());
        return journeeRepository.save(journee);
    }

    // 6. Supprimer une journée
    public void deleteJournee(Long id) {
        Journee journee = journeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journée introuvable"));
        journeeRepository.delete(journee);
    }
}

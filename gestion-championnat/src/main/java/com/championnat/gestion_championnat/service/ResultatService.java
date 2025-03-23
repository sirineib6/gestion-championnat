package com.championnat.gestion_championnat.service;

import com.championnat.gestion_championnat.model.Resultat;
import com.championnat.gestion_championnat.model.Journee;
import com.championnat.gestion_championnat.repository.ResultatRepository;
import com.championnat.gestion_championnat.repository.JourneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatService {

    @Autowired
    private ResultatRepository resultatRepository;

    @Autowired
    private JourneeRepository journeeRepository;

    // 1. Récupérer la liste de tous les résultats
    public List<Resultat> getAllResultats() {
        return resultatRepository.findAll();
    }

    // 2. Récupérer la liste des résultats suivant l'ID d'un championnat
    public List<Resultat> getResultatsByChampionnatId(Long championnatId) {
        return resultatRepository.findByJournee_Championnat_Id(championnatId);
    }

    // 3. Récupérer la liste des résultats suivant l'ID d'une journée
    public List<Resultat> getResultatsByJourneeId(Long journeeId) {
        return resultatRepository.findByJournee_Id(journeeId);
    }

    // 4. Récupérer un résultat par son ID
    public Resultat getResultatById(Long id) {
        return resultatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Résultat introuvable"));
    }

    // 5. Créer un résultat pour une journée
    public Resultat createResultat(Long journeeId, Resultat resultat) {
        Journee journee = journeeRepository.findById(journeeId)
                .orElseThrow(() -> new RuntimeException("Journée introuvable"));
        resultat.setJournee(journee); // Associer le résultat à la journée
        return resultatRepository.save(resultat);
    }

    // 6. Mettre à jour un résultat
    public Resultat updateResultat(Long id, Resultat resultatDetails) {
        Resultat resultat = resultatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Résultat introuvable"));
        resultat.setScoreEquipe1(resultatDetails.getScoreEquipe1());
        resultat.setScoreEquipe2(resultatDetails.getScoreEquipe2());
        resultat.setJournee(resultatDetails.getJournee());
        return resultatRepository.save(resultat);
    }

    // 7. Supprimer un résultat
    public void deleteResultat(Long id) {
        Resultat resultat = resultatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Résultat introuvable"));
        resultatRepository.delete(resultat);
    }
}

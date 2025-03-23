package com.championnat.gestion_championnat.controller;

import com.championnat.gestion_championnat.model.Resultat;
import com.championnat.gestion_championnat.service.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultats")
public class ResultatController {

    @Autowired
    private ResultatService resultatService;

    // 1. Récupérer tous les résultats
    @GetMapping("/")
    public List<Resultat> getAllResultats() {
        return resultatService.getAllResultats();
    }

    // 2. Récupérer les résultats d'un championnat par ID
    @GetMapping("/championnat/{championnatId}")
    public List<Resultat> getResultatsByChampionnatId(@PathVariable Long championnatId) {
        return resultatService.getResultatsByChampionnatId(championnatId);
    }

    // 3. Récupérer les résultats d'une journée par ID
    @GetMapping("/journee/{journeeId}")
    public List<Resultat> getResultatsByJourneeId(@PathVariable Long journeeId) {
        return resultatService.getResultatsByJourneeId(journeeId);
    }

    // 4. Récupérer un résultat par son ID
    @GetMapping("/{id}")
    public Resultat getResultatById(@PathVariable Long id) {
        return resultatService.getResultatById(id);
    }

    // 5. Créer un résultat pour une journée
    @PostMapping("/journee/{journeeId}")
    public Resultat createResultat(@PathVariable Long journeeId, @RequestBody Resultat resultat) {
        return resultatService.createResultat(journeeId, resultat);
    }

    // 6. Mettre à jour un résultat
    @PutMapping("/{id}")
    public Resultat updateResultat(@PathVariable Long id, @RequestBody Resultat resultatDetails) {
        return resultatService.updateResultat(id, resultatDetails);
    }

    // 7. Supprimer un résultat
    @DeleteMapping("/{id}")
    public void deleteResultat(@PathVariable Long id) {
        resultatService.deleteResultat(id);
    }
}

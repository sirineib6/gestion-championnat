package com.championnat.gestion_championnat.controller;

import com.championnat.gestion_championnat.model.Equipe;
import com.championnat.gestion_championnat.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    // 1. Récupérer la liste de toutes les équipes
    @GetMapping("/")
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    // 2. Récupérer les équipes d'un championnat par ID
    @GetMapping("/championnat/{championnatId}")
    public List<Equipe> getEquipesByChampionnatId(@PathVariable Long championnatId) {
        return equipeService.getEquipesByChampionnatId(championnatId);
    }

    // 3. Récupérer une équipe par son ID
    @GetMapping("/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeService.getEquipeById(id);
    }

    // 4. Créer une équipe
    @PostMapping("/")
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return equipeService.createEquipe(equipe);
    }

    // 5. Ajouter une équipe à un championnat
    @PostMapping("/{equipeId}/championnat/{championnatId}")
    public Equipe addEquipeToChampionnat(@PathVariable Long equipeId, @PathVariable Long championnatId) {
        return equipeService.addEquipeToChampionnat(equipeId, championnatId);
    }

    // 6. Mettre à jour une équipe
    @PutMapping("/{id}")
    public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe equipeDetails) {
        return equipeService.updateEquipe(id, equipeDetails);
    }

    // 7. Supprimer une équipe
    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
    }
}

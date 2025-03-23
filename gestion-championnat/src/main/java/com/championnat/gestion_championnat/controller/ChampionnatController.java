package com.championnat.gestion_championnat.controller;

import com.championnat.gestion_championnat.model.Championnat;
import com.championnat.gestion_championnat.service.ChampionnatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/championnats")
public class ChampionnatController {

    @Autowired
    private ChampionnatService championnatService;

    // 1. Récupérer tous les championnats
    @GetMapping("/")
    public List<Championnat> getAllChampionnats() {
        return championnatService.getAllChampionnats();
    }

    // 2. Récupérer un championnat par ID
    @GetMapping("/{id}")
    public Championnat getChampionnatById(@PathVariable Long id) {
        return championnatService.getChampionnatById(id);
    }

    // 3. Créer un championnat
    @PostMapping("/")
    public Championnat createChampionnat(@RequestBody Championnat championnat) {
        return championnatService.createChampionnat(championnat);
    }

    // 4. Mettre à jour un championnat
    @PutMapping("/{id}")
    public Championnat updateChampionnat(@PathVariable Long id, @RequestBody Championnat championnatDetails) {
        return championnatService.updateChampionnat(id, championnatDetails);
    }

    // 5. Supprimer un championnat
    @DeleteMapping("/{id}")
    public void deleteChampionnat(@PathVariable Long id) {
        championnatService.deleteChampionnat(id);
    }
}

package com.championnat.gestion_championnat.controller;

import com.championnat.gestion_championnat.model.Journee;
import com.championnat.gestion_championnat.service.JourneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journees")
public class JourneeController {

    @Autowired
    private JourneeService journeeService;

    // 1. Récupérer toutes les journées
    @GetMapping("/")
    public List<Journee> getAllJournees() {
        return journeeService.getAllJournees();
    }

    // 2. Récupérer les journées d'un championnat par ID
    @GetMapping("/championnat/{championnatId}")
    public List<Journee> getJourneesByChampionnatId(@PathVariable Long championnatId) {
        return journeeService.getJourneesByChampionnatId(championnatId);
    }

    // 3. Récupérer une journée par son ID
    @GetMapping("/{id}")
    public Journee getJourneeById(@PathVariable Long id) {
        return journeeService.getJourneeById(id);
    }

    // 4. Créer une journée pour un championnat
    @PostMapping("/{championnatId}")
    public Journee createJournee(@PathVariable Long championnatId, @RequestBody Journee journee) {
        return journeeService.createJournee(championnatId, journee);
    }

    // 5. Mettre à jour une journée
    @PutMapping("/{id}")
    public Journee updateJournee(@PathVariable Long id, @RequestBody Journee journeeDetails) {
        return journeeService.updateJournee(id, journeeDetails);
    }

    // 6. Supprimer une journée
    @DeleteMapping("/{id}")
    public void deleteJournee(@PathVariable Long id) {
        journeeService.deleteJournee(id);
    }
}

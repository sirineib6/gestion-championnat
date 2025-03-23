package com.championnat.gestion_championnat.repository;

import com.championnat.gestion_championnat.model.Championnat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionnatRepository extends JpaRepository<Championnat, Long> {}

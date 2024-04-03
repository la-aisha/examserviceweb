package com.examen.dayfinder.repository;

import com.examen.dayfinder.entity.Historique;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
    List<Historique> findAll();
}

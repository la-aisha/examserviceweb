package com.examen.dayfinder.service;

import com.examen.dayfinder.entity.Historique;
import com.examen.dayfinder.repository.HistoriqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository;

    public List<Historique> findAll() {
        return historiqueRepository.findAll();
    }

    public Historique create(Historique historique) {
        return historiqueRepository.save(historique);
    }
}

package com.example.kaddem.services;

import com.example.kaddem.entities.Departement;
import com.example.kaddem.repositories.IDepartementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DepartementServices implements IDepartementServices{

    private final IDepartementRepository departementRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        List<Departement> d = new ArrayList<>();
        departementRepository.findAll().forEach(d::add);
        return d;
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public void removeDepartement(Integer idDepartement) {
        departementRepository.deleteById(idDepartement);
    }
}

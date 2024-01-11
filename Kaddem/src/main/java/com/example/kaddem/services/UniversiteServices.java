package com.example.kaddem.services;

import com.example.kaddem.entities.Departement;
import com.example.kaddem.entities.Universite;
import com.example.kaddem.repositories.IDepartementRepository;
import com.example.kaddem.repositories.IUniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UniversiteServices implements IUniversiteServices{

    private final IUniversiteRepository universiteRepository;
    private final IDepartementRepository departementRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        List<Universite> universites = new ArrayList<>();
        universiteRepository.findAll().forEach(universites::add);
        return universites;
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if(universite.getDepartements()==null){
            Set<Departement> departements = new HashSet<>();
            departements.add(departement);
            universite.setDepartements(departements);
        }
        else {
            universite.getDepartements().add(departement);
        }
        universiteRepository.save(universite);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        List<Departement> departements = new ArrayList<>();

        for(Departement departement : universite.getDepartements()){
            departements.add(departement);
        }

        return departements;
    }
}

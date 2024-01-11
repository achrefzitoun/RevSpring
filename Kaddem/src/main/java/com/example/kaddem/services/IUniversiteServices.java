package com.example.kaddem.services;

import com.example.kaddem.entities.Departement;
import com.example.kaddem.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (Integer idUniversite);

    void removeUniversite(Integer idUniversite);

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);



}

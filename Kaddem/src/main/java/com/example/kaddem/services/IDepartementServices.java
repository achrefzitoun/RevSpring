package com.example.kaddem.services;

import com.example.kaddem.entities.Departement;

import java.util.List;

public interface IDepartementServices {

    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepart);

    void removeDepartement(Integer idDepartement);
}

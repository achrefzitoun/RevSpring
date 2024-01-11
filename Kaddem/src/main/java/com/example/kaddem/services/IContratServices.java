package com.example.kaddem.services;

import com.example.kaddem.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratServices {
    List<Contrat> retrieveAllContrats();

    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);

    Integer nbContratsValides(Date startDate, Date endDate);

    void retrieveAndUpdateStatusContrat();
}

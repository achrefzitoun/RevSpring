package com.example.kaddem.services;

import com.example.kaddem.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {
    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);

    Etudiant asignEtudToDep(Integer idStudent, Integer idDep);

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    Etudiant findDistinctFirstByNomEAndPrenomE(String nom,String prenom);

    void removeEtudiant(Integer idEtudient);
}

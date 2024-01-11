package com.example.clinique.services;

import com.example.clinique.entities.*;

import java.util.Date;
import java.util.List;

public interface ICliniqueServices {
    public Clinique addClinique (Clinique clinique);
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);

    public Patient addPatient(Patient patient);

    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);

    public int getNbrRendezVousMedecin(Long idMedecin);

    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    public int getRevenuMedecin(Long idMed, Date date1 , Date date2);
}


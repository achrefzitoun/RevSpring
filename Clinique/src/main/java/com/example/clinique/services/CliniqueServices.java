package com.example.clinique.services;

import com.example.clinique.entities.*;
import com.example.clinique.repositories.ICliniqueRepository;
import com.example.clinique.repositories.IMedecinRepository;
import com.example.clinique.repositories.IPatientRepository;
import com.example.clinique.repositories.IRendezVousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CliniqueServices implements ICliniqueServices{

    private final ICliniqueRepository cliniqueRepository;
    private final IMedecinRepository medecinRepository;
    private final IPatientRepository patientRepository;
    private final IRendezVousRepository rendezVousRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }


    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).orElse(null);
        if(clinique.getMedecins()==null){
            Set<Medecin> medecins = new HashSet<>();
            medecins.add(medecin);
            clinique.setMedecins(medecins);
        }
        else {
            clinique.getMedecins().add(medecin);
        }
        return medecinRepository.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        Patient patient = patientRepository.findById(idPatient).orElse(null);

        rdv.setPatient(patient);
        rdv.setMedecin(medecin);

        rendezVousRepository.save(rdv);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        return rendezVousRepository.countByMedecin(medecin);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        Clinique clinique = cliniqueRepository.findById(idClinique).orElse(null);
        List<RendezVous> rendezVousList = new ArrayList<>();
        for(Medecin med : clinique.getMedecins()){
            if(med.getSpecialite().equals(specialite)){
                for(RendezVous rendezVous : med.getRendezVous()){
                    rendezVousList.add(rendezVous);
                }
            }
        }

        return rendezVousList;
    }

    //@Scheduled(cron = "1/5 * * * * *")
    public void retrieveRendezVous() {
        Date d = new Date();
        List<RendezVous> rendezVousList = new ArrayList<>();
        rendezVousRepository.findAll().forEach(rendezVousList::add);
        for(RendezVous rendezVous : rendezVousList){
            if(rendezVous.getDateRDV().after(d)){
                System.out.println("La liste des RendezVous : " + rendezVous.getDateRDV()
                        + " : Medecin : " + rendezVous.getMedecin().getNomMedecin() +
                        " : Patient : " + rendezVous.getPatient().getNomPatient());
            }
        }
    }

    @Override
    public int getRevenuMedecin(Long idMed, Date date1, Date date2) {
        Medecin med = medecinRepository.findById(idMed).orElse(null);
        int a =0;
        for(RendezVous rendezVous : med.getRendezVous()){
            if(rendezVous.getDateRDV().after(date1) && rendezVous.getDateRDV().before(date2)){
                a = a + med.getPrixConsultation();
            }
        }
        return a;
    }
}

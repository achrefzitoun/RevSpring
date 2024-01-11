package com.example.clinique.controllers;

import com.example.clinique.entities.*;
import com.example.clinique.repositories.ICliniqueRepository;
import com.example.clinique.services.ICliniqueServices;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clinique")

public class CliniqueRestController {

    private final ICliniqueServices cliniqueServices;

    private final ICliniqueRepository cliniqueRepository;

    @DeleteMapping("/delete/{id}")
    public void deleteClinique(@PathVariable("id") long id){
        cliniqueRepository.deleteById(id);
    }

    @PostMapping("/add")
    public Clinique addClinique (@RequestBody Clinique clinique){
        return cliniqueServices.addClinique(clinique);
    }

    @PutMapping("/addMedecinAndAssignToClinique/{idclinique}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin,@PathVariable("idclinique") Long cliniqueId) {
        return cliniqueServices.addMedecinAndAssignToClinique(medecin,cliniqueId);
    }

    @PostMapping("/patientadd")
    public Patient addPatient(@RequestBody Patient patient) {
        return cliniqueServices.addPatient(patient);
    }

    @PutMapping("/addRDVAndAssignMedAndPatient/{idmed}/{idpat}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable("idmed") Long idMedecin, @PathVariable("idpat") Long idPatient) {
        cliniqueServices.addRDVAndAssignMedAndPatient(rdv,idMedecin,idPatient);
    }

    @GetMapping("/getNbrRendezVousMedecin/{id}")
    public int getNbrRendezVousMedecin(@PathVariable("id") Long idMedecin) {
        return cliniqueServices.getNbrRendezVousMedecin(idMedecin);
    }

    @GetMapping("/getNbrRendezVousMedecin/{idcl}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable("idcl") Long idClinique, @PathVariable("specialite") Specialite specialite) {
        return cliniqueServices.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @GetMapping("/getRevenuMedecin/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin (
            @PathVariable("idMedecin") Long idMedecin,
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
        return cliniqueServices.getRevenuMedecin(idMedecin, startDate,endDate);
    }

    }

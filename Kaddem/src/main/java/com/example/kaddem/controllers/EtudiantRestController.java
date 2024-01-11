package com.example.kaddem.controllers;

import com.example.kaddem.entities.Etudiant;
import com.example.kaddem.services.IEtudiantServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {

    public final IEtudiantServices etudiantServices;

    @PostMapping("/add")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantServices.addEtudiant(etudiant);
    }

    @PutMapping("/update")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return etudiantServices.updateEtudiant(etudiant);
    }

    @GetMapping("/get/{id}")
    Etudiant getEtudiant(@PathVariable("id") Integer id){

        return etudiantServices.retrieveEtudiant(id);
    }

    @GetMapping("/all")
    List<Etudiant> getAllEtudiant(){

        return etudiantServices.retrieveAllEtudiants();
    }

    @DeleteMapping("/delete/{id}")
    void deleteEtudiant(@PathVariable("id") Integer id){

        etudiantServices.removeEtudiant(id);
    }

    @PutMapping("/asignEtudToDep/{idEtud}/{idDep}")
    public Etudiant asignEtudToDep(@PathVariable("idEtud") Integer idEtud, @PathVariable("idDep") Integer idDep){
        return etudiantServices.asignEtudToDep(idEtud,idDep);
    }

    @PutMapping("/AddEtudContratEquipe/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant etudiant, @PathVariable("idContrat") Integer idContrat, @PathVariable("idEquipe") Integer idEquipe){
        return etudiantServices.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idEquipe);
    }

    @GetMapping("/getByNomAndPrenom/{Nom}/{Prenom}")
    public Etudiant findDistinctFirstByNomEAndPrenomE(@PathVariable("Nom") String nom, @PathVariable("Prenom") String prenom) {
        return etudiantServices.findDistinctFirstByNomEAndPrenomE(nom,prenom);
    }

    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") Integer idDepartement){
        return etudiantServices.getEtudiantsByDepartement(idDepartement);
    }

}

package com.example.kaddem.controllers;

import com.example.kaddem.entities.Contrat;
import com.example.kaddem.services.IContratServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {

    private final IContratServices contratServices;

    @PostMapping("/add")
    Contrat addContrat(@RequestBody Contrat contrat){
        return contratServices.addContrat(contrat);
    }

    @PutMapping("/update")
    Contrat updateUniversite(@RequestBody Contrat contrat){
        return contratServices.updateContrat(contrat);
    }

    @GetMapping("/get/{id}")
    Contrat getContrat(@PathVariable("id") Integer id){

        return contratServices.retrieveContrat(id);
    }

    @GetMapping("/all")
    List<Contrat> getAllContrats(){

        return contratServices.retrieveAllContrats();
    }

    @DeleteMapping("/delete/{id}")
    void deleteContrat(@PathVariable("id") Integer id){

        contratServices.removeContrat(id);
    }

    @PutMapping ("/affectContratToEtudiant/{nomE}/{prenomE}")
    Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable("nomE") String nomE, @PathVariable("prenomE") String prenomE){
        return contratServices.affectContratToEtudiant(ce,nomE,prenomE);
    }

    @GetMapping("/nbContratsValides/{d1}/{d2}")
    Integer nbContratsValides(@PathVariable("d1") Date startDate, @PathVariable("d2") Date endDate){
        return contratServices.nbContratsValides(startDate,endDate);
    }

}

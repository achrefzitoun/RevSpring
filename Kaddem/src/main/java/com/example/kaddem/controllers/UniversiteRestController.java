package com.example.kaddem.controllers;

import com.example.kaddem.entities.Departement;
import com.example.kaddem.entities.Universite;
import com.example.kaddem.services.IUniversiteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    private final IUniversiteServices universiteServices;

    @PostMapping("/add")
    Universite addUniversite(@RequestBody Universite universite){

        return universiteServices.addUniversite(universite);

    }

    @PutMapping("/update")
    Universite updateUniversite(@RequestBody Universite universite){

        return universiteServices.updateUniversite(universite);

    }

    @GetMapping("/get/{id}")
    Universite getUniversite(@PathVariable("id") Integer id){

        return universiteServices.retrieveUniversite(id);
    }

    @GetMapping("/all")
    List<Universite> getAllUniversites(){
        return universiteServices.retrieveAllUniversites();
    }

    @DeleteMapping("/delete/{id}")
    void deleteUniversite(@PathVariable("id") Integer id){
        universiteServices.removeUniversite(id);
    }

    @PutMapping("/assignUnivToDep/{idUniversite}/{idDepartement}")
    void assignUniversiteToDepartement(@PathVariable("idUniversite") Integer idUniversite, @PathVariable("idDepartement") Integer idDepartement) {
        universiteServices.assignUniversiteToDepartement(idUniversite,idDepartement);
    }

    @GetMapping("/retrieveDepartementsByUniversite/{idUniversite}")
    List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniversite") Integer idUniversite){
        return universiteServices.retrieveDepartementsByUniversite(idUniversite);
    }


}

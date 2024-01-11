package com.example.kaddem.controllers;

import com.example.kaddem.entities.Departement;
import com.example.kaddem.services.IDepartementServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departement")

public class DepartementRestController {

    public final IDepartementServices departementServices;

    @PostMapping("/add")
    Departement addDepartement(@RequestBody Departement departement){
        return departementServices.addDepartement(departement);
    }

    @PutMapping("/update")
    Departement updateDepartement(@RequestBody Departement departement){
        return departementServices.updateDepartement(departement);
    }

    @GetMapping("/get/{id}")
    Departement getDepartement(@PathVariable("id") Integer id){

        return departementServices.retrieveDepartement(id);
    }

    @GetMapping("/all")
    List<Departement> getAllDepartement(){

        return departementServices.retrieveAllDepartements();
    }

    @DeleteMapping("/delete/{id}")
    void deleteDepartement(@PathVariable("id") Integer id){
        departementServices.removeDepartement(id);
    }
}

package com.example.kaddem.controllers;

import com.example.kaddem.entities.Equipe;
import com.example.kaddem.services.IEquipeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")

public class EquipeRestController {

    private final IEquipeServices equipeServices;

    @PostMapping("/add")
    Equipe addEquipe(@RequestBody Equipe equipe){
        return equipeServices.addEquipe(equipe);
    }

    @PutMapping("/update")
    Equipe updateEquipe(@RequestBody Equipe equipe){
        return equipeServices.updateEquipe(equipe);
    }

    @GetMapping("/get/{id}")
    Equipe getEquipe(@PathVariable("id") Integer id){
        return equipeServices.retrieveEquipe(id);
    }

    @GetMapping("/all")
    List<Equipe> getAllEquipe(){
        return equipeServices.retrieveAllEquipes();
    }

    @DeleteMapping("/delete/{id}")
    void deleteEquipe(@PathVariable("id") Integer id){
        equipeServices.removeEquipe(id);
    }

    @PutMapping("/addAndAsignEquipe")
    public Equipe addAndAsignEquipe(@RequestBody Equipe e) {
        return equipeServices.addAndAsignEquipe(e);
    }

}

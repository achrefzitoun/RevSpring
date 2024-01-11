package com.example.datacenter.controllers;

import com.example.datacenter.entities.Datacenter;
import com.example.datacenter.entities.Utilisateur;
import com.example.datacenter.entities.VirtualMachine;
import com.example.datacenter.services.IUtilisateurServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/utilisateur")
public class UtilisateurRestController {
    private final IUtilisateurServices utilisateurServices;

    @PostMapping("/add")
    public void ajouterUser(@RequestBody Utilisateur user) {
        utilisateurServices.ajouterUser(user);
    }

    @PostMapping("/dcadd")
    public void ajouterDc(@RequestBody Datacenter dc) {
        utilisateurServices.ajouterDc(dc);
    }

    @PostMapping("/vmadd")
    public int ajouterVm(@RequestBody VirtualMachine vm) {
        return utilisateurServices.ajouterVm(vm);
    }

    @PutMapping("/affecterVmUser/{idvm}/{iduser}")
    public void affecterVmUser(@PathVariable("idvm") int idvm, @PathVariable("iduser") int iduser) {
        utilisateurServices.affecterVmUser(idvm,iduser);
    }

    @PutMapping("/affecterVm/{idvm}")
    public void affecterVm(@PathVariable("idvm") int idVm) {
        utilisateurServices.affecterVm(idVm);
    }

    @PutMapping("/demarrerInstanceUser/{idvm}")
    public void demarrerInstanceUser(@PathVariable("idvm") int idvm) {
        utilisateurServices.demarrerInstanceUser(idvm);
    }

    @PutMapping("/arreterInstanceUser/{idvm}")
    public void arreterInstanceUser(@PathVariable("idvm") int idvm){
        utilisateurServices.arreterInstanceUser(idvm);
    }




}

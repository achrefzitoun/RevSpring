package com.example.centrecommercial.contollers;

import com.example.centrecommercial.entities.Boutique;
import com.example.centrecommercial.entities.Categorie;
import com.example.centrecommercial.entities.CentreCommercial;
import com.example.centrecommercial.entities.Client;
import com.example.centrecommercial.services.IServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/centre")
public class Controller {
    private final IServices services;

    @PostMapping("/centreadd")
    public void ajoutCentre(@RequestBody CentreCommercial centre) {
        services.ajoutCentre(centre);
    }

    @PostMapping("/boutiqueadd")
    public void ajoutBoutique(@RequestBody Boutique boutique) {
        services.ajoutBoutique(boutique);
    }

    @PutMapping("/ajouterEtAffecterlisteBoutiques/{id}")
    public void ajouterEtAffecterlisteBoutiques(@RequestBody List<Boutique> lb, @PathVariable("id") Long idCentre) {
        services.ajouterEtAffecterlisteBoutiques(lb,idCentre);
    }

    @PutMapping("/ajouterEtAffecterClientBoutiques/{lb}")
    public void ajouterEtAffecterClientBoutiques(@RequestBody Client client,@PathVariable("lb") List<Long> idBoutiques) {
        services.ajouterEtAffecterClientBoutiques(client,idBoutiques);
    }

    @GetMapping("/listeClients/{id}")
    public List<Client> listeClients(@PathVariable("id") Long idBoutique) {
        return services.listeClients(idBoutique);
    }

    @GetMapping("/listeBoutiques/{id}")
    public List<Boutique> listeBoutiques(@PathVariable("id") Long idCentre) {
        return services.listeBoutiques(idCentre);
    }

    @GetMapping("/listeDeClientsParCategorie/{cat}")
    public List<Client> listeDeClientsParCategorie(@PathVariable("cat") Categorie categorie) {
        return services.listeDeClientsParCategorie(categorie);
    }

    }

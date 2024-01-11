package com.example.voyage.controllers;

import com.example.voyage.entities.Train;
import com.example.voyage.entities.Ville;
import com.example.voyage.entities.Voyage;
import com.example.voyage.entities.Voyageur;
import com.example.voyage.services.IServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voyage")
public class Controller {
    private final IServices services;

    @PostMapping("/ajouterVoyage")
    public void ajouterVoyage(@RequestBody Voyage v) {
        services.ajouterVoyage(v);
    }

    @PostMapping("/ajouterTrain")
    public void ajouterTrain(@RequestBody Train train) {
        services.ajouterTrain(train);
    }

    @PutMapping("/affecterTrainAVoyage/{idtrain}/{idvoyage}")
    public void affecterTrainAVoyage(@PathVariable("idtrain") Long idTrain, @PathVariable("idvoyage") Long idVoyage) {
        services.affecterTrainAVoyage(idTrain,idVoyage);
    }

    @PostMapping("/ajouterVoyageur")
    public void ajouterVoyageur(@RequestBody Voyageur v) {
        services.ajouterVoyageur(v);
    }

    @PutMapping("/affecterTrainAVoyageur/{idVoyageur}/{nomGareDepart}/{nomGareArrivee}/{heureDepart}")
    public void affecterTrainAVoyageur(@PathVariable("idVoyageur") Long idVoyageur,
                                       @PathVariable("nomGareDepart") Ville nomGareDepart,
                                       @PathVariable("nomGareArrivee") Ville nomGareArrivee,
                                       @PathVariable("heureDepart") double heureDepart) {
        services.affecterTrainAVoyageur(idVoyageur, nomGareDepart, nomGareArrivee, heureDepart);
    }

    @GetMapping("/trainPlacesLibres/{nomGareDepart}")
    public int trainPlacesLibres(@PathVariable("nomGareDepart") Ville nomGareDepart) {
        return services.trainPlacesLibres(nomGareDepart);
    }

    @PutMapping("/desaffecterVoyageursTrain/{nomGareDepart}/{nomGareArrivee}/{heureDepart}")
    public void desaffecterVoyageursTrain(@PathVariable("nomGareDepart") Ville nomGareDepart,
                                          @PathVariable("nomGareArrivee") Ville nomGareArrivee,
                                          @PathVariable("heureDepart") double heureDepart) {
        services.desaffecterVoyageursTrain(nomGareDepart, nomGareArrivee, heureDepart);
    }

}

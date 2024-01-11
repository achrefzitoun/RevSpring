package com.example.voyage.services;

import com.example.voyage.entities.Train;
import com.example.voyage.entities.Ville;
import com.example.voyage.entities.Voyage;
import com.example.voyage.entities.Voyageur;

public interface IServices {
    public void ajouterVoyage(Voyage v);

    public void ajouterTrain(Train train);

    public void affecterTrainAVoyage(Long idTrain, Long idVoyage);

    public void ajouterVoyageur(Voyageur v);

    public void affecterTrainAVoyageur(Long idVoyageur, Ville nomGareDepart, Ville nomGareArrivee, double heureDepart);

    public int trainPlacesLibres(Ville nomGareDepart);

    public void desaffecterVoyageursTrain(Ville nomGareDepart, Ville nomGareArrivee, double heureDepart);

    public void trainsEnGare();
}

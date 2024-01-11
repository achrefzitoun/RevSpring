package com.example.voyage.services;

import com.example.voyage.entities.Train;
import com.example.voyage.entities.Ville;
import com.example.voyage.entities.Voyage;
import com.example.voyage.entities.Voyageur;
import com.example.voyage.repositories.ITrainRepository;
import com.example.voyage.repositories.IVoyageRepository;
import com.example.voyage.repositories.IVoyageurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.lang.ELSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class Services implements IServices{
    @Autowired
    private final ITrainRepository trainRepository;
    @Autowired
    private final IVoyageRepository voyageRepository;
    @Autowired
    private final IVoyageurRepository voyageurRepository;

    @Override
    public void ajouterVoyage(Voyage v) {
        voyageRepository.save(v);
    }

    @Override
    public void ajouterTrain(Train train) {
        trainRepository.save(train);
    }

    @Override
    public void affecterTrainAVoyage(Long idTrain, Long idVoyage) {
        Train train = trainRepository.findById(idTrain).orElse(null);
        Voyage voyage = voyageRepository.findById(idVoyage).orElse(null);

        voyage.setTrain(train);

        voyageRepository.save(voyage);
    }

    @Override
    public void ajouterVoyageur(Voyageur v) {
        voyageurRepository.save(v);
    }

    @Override
    public void affecterTrainAVoyageur(Long idVoyageur, Ville nomGareDepart, Ville nomGareArrivee, double heureDepart) {
        Voyageur voyageur = voyageurRepository.findById(idVoyageur).orElse(null);
        Voyage voyage = voyageRepository.findByGareDepartAndGareArriveeAndHeureDepart(nomGareDepart,nomGareArrivee,heureDepart);
        if(voyage.getTrain().getNbPlaceLibre()>2) {
            if (voyage.getVoyageurs() == null) {
                Set<Voyageur> voyageurs = new HashSet<>();
                voyageurs.add(voyageur);
                voyage.setVoyageurs(voyageurs);
            } else {
                voyage.getVoyageurs().add(voyageur);
            }
            voyage.getTrain().setNbPlaceLibre(voyage.getTrain().getNbPlaceLibre()-1);
            trainRepository.save(voyage.getTrain());
        }
        else {
            System.out.println("Non disponnible");
        }
        voyageRepository.save(voyage);
    }

    @Override
    public int trainPlacesLibres(Ville nomGareDepart) {
        List<Voyage> voyages = voyageRepository.findByGareDepart(nomGareDepart);
        int moyenne=0;
        int somme=0;
        int i=0;
        for(Voyage v : voyages){
            somme = somme + v.getTrain().getNbPlaceLibre();
            i++;
        }
        moyenne = somme / i ;
        return moyenne;
    }

    @Override
    public void desaffecterVoyageursTrain(Ville nomGareDepart, Ville nomGareArrivee, double heureDepart) {
        Voyage voyage = voyageRepository.findByGareDepartAndGareArriveeAndHeureDepart(nomGareDepart,nomGareArrivee,heureDepart);
        voyage.getTrain().setNbPlaceLibre(voyage.getTrain().getNbPlaceLibre()+1);
        trainRepository.save(voyage.getTrain());
    }

    @Override
    @Scheduled(cron = "30 * * * * *")
    @Transactional
    public void trainsEnGare() {
        Date d = new Date();
        List<Voyage> voyages = voyageRepository.findByDateArriveeIsBefore(d);
        for(Voyage v : voyages){
            System.out.println(v.getTrain());
        }
    }
}

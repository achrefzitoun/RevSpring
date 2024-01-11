package com.example.centrecommercial.services;

import com.example.centrecommercial.entities.*;
import com.example.centrecommercial.repositories.IBoutiqueRepository;
import com.example.centrecommercial.repositories.ICentreCommercialRepository;
import com.example.centrecommercial.repositories.IClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class Services implements IServices {
    @Autowired
    private final IBoutiqueRepository boutiqueRepository;
    @Autowired
    private final IClientRepository clientRepository;
    @Autowired
    private final ICentreCommercialRepository centreCommercialRepository;
    @Override
    public void ajoutCentre(CentreCommercial centre) {
        centreCommercialRepository.save(centre);
        for(Boutique b : centre.getBoutiques()){
            b.setCentreCommercial(centre);
            boutiqueRepository.save(b);
        }

    }

    @Override
    public void ajoutBoutique(Boutique boutique) {
        boutiqueRepository.save(boutique);
    }

    @Override
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
        CentreCommercial centreCommercial = centreCommercialRepository.findById(idCentre).orElse(null);

        for(Boutique boutique: lb){
            boutique.setCentreCommercial(centreCommercial);
            boutiqueRepository.save(boutique);
        }

    }

    @Override
    @Transactional
    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
        clientRepository.save(client);
        for(Long id : idBoutiques){
            Boutique boutique = boutiqueRepository.findById(id).orElse(null);
            if(boutique.getClients()==null){
                Set<Client> clients = new HashSet<>();
                clients.add(client);
                boutique.setClients(clients);
            }
            else{
                boutique.getClients().add(client);
            }
            boutiqueRepository.save(boutique);
        }
    }

    @Override
    public List<Client> listeClients(Long idBoutique) {
        Boutique b = boutiqueRepository.findById(idBoutique).orElse(null);
        List<Client> clients = new ArrayList<>();
        b.getClients().forEach(clients::add);
        return clients;
    }

    @Override
    public List<Boutique> listeBoutiques(Long idCentre) {
        CentreCommercial centreCommercial = centreCommercialRepository.findById(idCentre).orElse(null);
        List<Boutique> boutiques = new ArrayList<>();
        centreCommercial.getBoutiques().forEach(boutiques::add);
        return boutiques;
    }

    @Override
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {
        Boutique b = boutiqueRepository.findByCategorie(categorie);
        List<Client> clients = new ArrayList<>();
        b.getClients().forEach(clients::add);
        return clients;
    }

    @Override
    @Scheduled(cron = "30 * * * * *")
    @Transactional
    public void nbreClientParGenre() {
        System.out.println("=/=/=/=/=/=====================/=/=/=/=/=");
        System.out.println("----------------------------------");
        System.out.println("Hommes : ");
        System.out.println(clientRepository.countByGenre(Genre.MASCULIN));
        System.out.println("----------------------------------");
        System.out.println("Femmes : ");
        System.out.println(clientRepository.countByGenre(Genre.FEMININ));
    }


}

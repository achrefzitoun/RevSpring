package com.example.centrecommercial.services;

import com.example.centrecommercial.entities.Boutique;
import com.example.centrecommercial.entities.Categorie;
import com.example.centrecommercial.entities.CentreCommercial;
import com.example.centrecommercial.entities.Client;

import java.util.List;

public interface IServices {
    void ajoutCentre(CentreCommercial centre);

    public void ajoutBoutique(Boutique boutique);

    void ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);

    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);

    List<Client> listeClients(Long idBoutique);

    List<Boutique> listeBoutiques(Long idCentre);

    List<Client> listeDeClientsParCategorie(Categorie categorie);

    void nbreClientParGenre();

}

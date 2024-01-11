package com.example.centrecommercial.repositories;

import com.example.centrecommercial.entities.Boutique;
import com.example.centrecommercial.entities.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBoutiqueRepository  extends CrudRepository<Boutique, Long> {
    Boutique findByCategorie(Categorie categorie);
}

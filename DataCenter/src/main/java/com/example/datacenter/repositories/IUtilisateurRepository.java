package com.example.datacenter.repositories;

import com.example.datacenter.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
}

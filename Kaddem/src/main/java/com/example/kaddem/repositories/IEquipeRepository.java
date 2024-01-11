package com.example.kaddem.repositories;

import com.example.kaddem.entities.Equipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipeRepository extends CrudRepository<Equipe, Integer> {

}

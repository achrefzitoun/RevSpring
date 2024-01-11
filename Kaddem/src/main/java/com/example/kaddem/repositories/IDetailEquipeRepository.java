package com.example.kaddem.repositories;

import com.example.kaddem.entities.DetailEquipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailEquipeRepository extends CrudRepository<DetailEquipe, Integer> {
}

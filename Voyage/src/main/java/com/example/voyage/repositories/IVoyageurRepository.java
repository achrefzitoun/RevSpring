package com.example.voyage.repositories;

import com.example.voyage.entities.Voyageur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoyageurRepository extends CrudRepository<Voyageur, Long> {
}

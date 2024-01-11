package com.example.voyage.repositories;

import com.example.voyage.entities.Ville;
import com.example.voyage.entities.Voyage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IVoyageRepository extends CrudRepository<Voyage,Long> {
    Voyage findByGareDepartAndGareArriveeAndHeureDepart(Ville villedep, Ville villearr, Double heuredep);
    List<Voyage> findByGareDepart(Ville ville);
    List<Voyage> findByDateArriveeIsBefore(Date d1);
}

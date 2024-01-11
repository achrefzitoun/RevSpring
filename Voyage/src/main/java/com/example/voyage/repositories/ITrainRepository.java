package com.example.voyage.repositories;

import com.example.voyage.entities.Train;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrainRepository extends CrudRepository<Train,Long> {
}

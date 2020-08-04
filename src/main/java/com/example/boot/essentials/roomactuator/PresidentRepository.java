package com.example.boot.essentials.roomactuator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresidentRepository extends CrudRepository<President, Long> {
}

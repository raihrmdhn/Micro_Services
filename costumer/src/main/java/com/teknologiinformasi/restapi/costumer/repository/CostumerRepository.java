package com.teknologiinformasi.restapi.costumer.repository;

import com.teknologiinformasi.restapi.costumer.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}

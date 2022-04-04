package com.endava.demo.repository;

import com.endava.demo.model.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket, String> {
    Optional<Supermarket> findByName(String name);
    Optional<Supermarket> findById(String id);
}
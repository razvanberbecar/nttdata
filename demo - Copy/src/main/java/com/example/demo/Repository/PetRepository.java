package com.example.demo.Repository;

import com.example.demo.Model.Pet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("SELECT p FROM Pet p WHERE p.owner = ?1")
    Optional<Pet> findByOwner(String owner);

    @Query("SELECT p FROM Pet p WHERE p.type = ?1")
    List<Pet> findByType(String type);

    @Query("SELECT p FROM Pet p")
    List<Pet> findAllSorted(Sort sort);}

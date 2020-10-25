package com.example.assignments._3lagen.repository;

import com.example.assignments._3lagen.dao.Klant;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface KlantRepository extends JpaRepository<Klant, Long> {
}

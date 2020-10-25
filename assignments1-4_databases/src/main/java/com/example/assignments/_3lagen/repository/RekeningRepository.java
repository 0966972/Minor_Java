package com.example.assignments._3lagen.repository;

import com.example.assignments._3lagen.dao.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Long> {
}

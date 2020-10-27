package com.example.demo.repository;

import com.example.demo.dao.Klant;
import com.example.demo.dao.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Integer> {
    @Query("SELECT coalesce(max(ch.id), 0) FROM Rekening ch")
    Long getMaxId();
}

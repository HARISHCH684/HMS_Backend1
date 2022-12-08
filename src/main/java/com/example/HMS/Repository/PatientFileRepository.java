package com.example.HMS.Repository;

import com.example.HMS.Entity.PatientFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientFileRepository extends JpaRepository<PatientFile, Integer> {
}
package com.example.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HMS.Entity.Patient;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientDetailsRepository extends JpaRepository<Patient, Integer> {

}
package com.example.HMS.Controller;

import  java.util.ArrayList;
import java.util.List;

import com.example.HMS.Repository.PatientDetailsRepository;
import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.HMS.Entity.Patient;
import com.example.HMS.Entity.PatientFile;
import com.example.HMS.Repository.PatientFileRepository;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;



	@RestController
	@CrossOrigin(origins="http://hmsfrontend.s3-website-us-west-2.amazonaws.com/")
	public class Controller {
		

			@Autowired
			PatientFileRepository patientFileRepo;

			@Autowired
			PatientDetailsRepository patientRepository;

			static String patientname;

			@PostMapping("/PatientIncrement")
			public ResponseEntity<Patient> PatientIncrement(@RequestBody Patient patient) {

				patientname = patient.patientName;
				return new ResponseEntity<>(this.patientRepository.save(patient), HttpStatus.OK);

			}

			@PostMapping("/PatientFileInfo")
			public ResponseEntity<PatientFile> addLoanInfo(@RequestBody PatientFile patientFile) {
	//		@Query("Select p from Patient p where p.patientName = ?1")
				List<Patient> listpatient = patientRepository.findAll();
				for (Patient p : listpatient) {
					String pname = p.patientName;
					if (pname.equals(patientname)) {
						patientFile.patient = p;
					}
				}
				return new ResponseEntity<>(this.patientFileRepo.save(patientFile), HttpStatus.OK);

			}

			@GetMapping("/patientDetails")
			public List<Patient> getPatientDetails() {
				return patientRepository.findAll();
			}

			@GetMapping("/patientInfo")
			public List<PatientFile> getPatientInfo() {
				return patientFileRepo.findAll();
			}




		
	

	

}

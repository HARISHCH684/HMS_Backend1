package com.example.HMS.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.HMS.Entity.Patient;
import com.example.HMS.Entity.PatientFile;
import com.example.HMS.Repository.PatientFileRepository;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;



	@RestController
	@CrossOrigin(origins="*")
	public class Controller {
		

			@Autowired
			PatientFileRepository patientFileRepo;


			@GetMapping("/getPatient")
			public List<PatientFile> getPatientdetails() {

				Patient patient = new Patient();
				patient.patientId = 1;
				patient.patientName = "Harish";
				patient.age = "23";
				patient.phoneNo = "9999999999";

				PatientFile pf = new PatientFile();
				pf.patientFileId = 1;
				pf.healthIssue = "fever";
				pf.prescription = "paracetmol";
				pf.patient = patient;


				PatientFile pf1 = new PatientFile();
				pf1.patientFileId = 2;
				pf1.healthIssue = "bp";
				pf1.prescription = "felodipine";
				pf1.patient = patient;




				List<PatientFile> list = new ArrayList<>();

				list.add(pf);
				list.add(pf1);

		        return patientFileRepo.saveAll(list);
			}

			@GetMapping("patientInfo/{id}")
			public PatientFile getPatientInfo(@PathVariable int id){
				return patientFileRepo.findById(id).get();

			}

		
	

	

}

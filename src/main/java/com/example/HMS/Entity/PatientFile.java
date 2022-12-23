package com.example.HMS.Entity;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
public class PatientFile {

	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	    public int patientFileId;

	    public String healthIssue;

	    public String prescription;

	    @ManyToOne(cascade = {CascadeType.ALL})
	    @NotFound(action = NotFoundAction.IGNORE)
	    public Patient patient;

	}




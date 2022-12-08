package com.example.HMS.Entity;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PatientFile {

	    @Id
	    public int patientFileId;

	    public String healthIssue;

	    public String prescription;

	    @ManyToOne(cascade = {CascadeType.ALL})
	    @NotFound(action = NotFoundAction.IGNORE)
	    public Patient patient;

	}




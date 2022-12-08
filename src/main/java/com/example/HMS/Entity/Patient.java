package com.example.HMS.Entity;


	import javax.persistence.Entity;
	import javax.persistence.Id;


@Entity
//	@Table(name="PatientDetails")
	public class Patient {
		
		
			@Id
			public int patientId;

			public String patientName;

			public String age;

			public String phoneNo;


		}


		


	



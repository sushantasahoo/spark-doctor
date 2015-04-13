package com.health.vo;

import java.sql.Date;
import java.util.List;

public class PatientReport {

	double id;
	Date date;
	String patientId;
	String name;
	int age;
	String gender;
	String symptom;

	public PatientReport(double id, Date date, String patientId, String name,
			int age, String gender, String symptom) {
		this.id = id;
		this.date = date;
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.symptom = symptom;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSymptoms() {
		return symptom;
	}

	public void setSymptoms(String symptoms) {
		this.symptom = symptom;
	}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.Patient.Patient;

/**
 *
 * @author Diya
 */
public class PharmacyWorkRequest extends WorkRequest {
    private String medication; // The medication requested
    private Patient patient;   // The patient associated with the request
private String result;  // Result (e.g., lab result, or status of medication process)
    // Constructor
    public PharmacyWorkRequest(String medication, Patient patient) {
        this.medication = medication;
        this.patient = patient;
       
          this.result = ""; // Default value (empty string)
    }

    // Getter for Medication
    public String getMedication() {
        return medication;
    }

    // Setter for Medication
    public void setMedication(String medication) {
        this.medication = medication;
    }

    // Getter for Patient
    public Patient getPatient() {
        return patient;
    }

    // Setter for Patient
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public String getResult() {
        return result;
    }

    // Setter for Result (e.g., to set the result of a lab test)
    public void setResult(String result) {
        this.result = result;
    }
}

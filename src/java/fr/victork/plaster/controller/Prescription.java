package fr.victork.plaster.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Prescription {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    private static ArrayList<Prescription> listOfPrescription = new ArrayList<>();
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idPrescription;
    private LocalDate datePrescription;
    private Customer customer;
    private Person prescriber;
    private Map<Medication, Integer> listOfMedication;

    //--------------------- CONSTRUCTORS ---------------------------------------

    public Prescription(int idPrescription, LocalDate datePrescription, Customer customer, Person prescriber,
                        Map<Medication, Integer> listOfMedication) {
        this.setIdPrescription(idPrescription);
        this.setDatePrescription(datePrescription);
        this.setCustomer(customer);
        this.setPrescriber(prescriber);

        this.setListOfMedication(listOfMedication);
        Prescription.getListOfPrescription().add(this);
        customer.addPrescriptionToTheList(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    public ArrayList<Prescription> prescriptionListForACustomer(Customer customer) {
        ArrayList<Prescription> prescriptionListForThisCustomer = new ArrayList<>();
        for (Prescription onePrescription : getListOfPrescription()
        ) {
            if (onePrescription.customer == customer) {
                prescriptionListForThisCustomer.add(onePrescription);
            }
        }
        return prescriptionListForThisCustomer;
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    public static ArrayList<Prescription> getListOfPrescription() {
        return listOfPrescription;
    }
    public static void setListOfPrescription(ArrayList<Prescription> listOfPrescription) {
        Prescription.listOfPrescription = listOfPrescription;
    }
    //--------------------- GETTERS - SETTERS ----------------------------------

    public int getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(int idPrescription) {
        this.idPrescription = idPrescription;
    }

    public LocalDate getDatePrescription() {
        return datePrescription;
    }

    public void setDatePrescription(LocalDate datePrescription) {
        this.datePrescription = datePrescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Person getPrescriber() {
        return prescriber;
    }

    public void setPrescriber(Person prescriber) {
        if (prescriber instanceof Specialist || prescriber instanceof Doctor) {
            this.prescriber = prescriber;
        } else {
            throw new IllegalArgumentException("The prescriber must be a doctor or a specialist.");
        }
    }

    public Map<Medication, Integer> getListOfMedication() {
        return listOfMedication;
    }

    public void setListOfMedication(Map<Medication, Integer> listOfMedication) {
        this.listOfMedication = listOfMedication;
    }

    //--------------------- TO STRING METHOD------------------------------------
}

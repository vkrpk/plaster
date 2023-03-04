package fr.victork.plaster.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prescription {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    private static List<Prescription> listOfPrescription = new ArrayList<>();
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idPrescription;
    private LocalDate datePrescription;
    private Customer customer;
    private Person prescriber;
    private List<Medication> listOfMedication = new ArrayList<>();


    //--------------------- CONSTRUCTORS ---------------------------------------

    public Prescription(int idPrescription, LocalDate datePrescription, Customer customer, Person prescriber,
                        ArrayList<Medication> listOfMedication) {
        this.setIdPrescription(idPrescription);
        this.setDatePrescription(datePrescription);
        this.setCustomer(customer);
        this.setPrescriber(prescriber);
        this.setListOfMedication(listOfMedication);
        Prescription.setListOfPrescription(this);
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

    public List<Medication> getListOfMedication() {
        return listOfMedication;
    }

    public void setListOfMedication(List<Medication> listOfMedication) {
        this.listOfMedication = listOfMedication;
    }

    public static List<Prescription> getListOfPrescription() {
        return listOfPrescription;
    }

    public static void setListOfPrescription(Prescription prescription) {
        listOfPrescription.add(prescription);
    }
    //--------------------- TO STRING METHOD------------------------------------
}

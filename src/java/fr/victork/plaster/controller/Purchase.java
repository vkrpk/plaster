package fr.victork.plaster.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Purchase {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    private static ArrayList<Purchase> listOfAllPurchase = new ArrayList<>();
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idPurchase;

    private Map<Medication, Integer> listOfPurchase;
    private Customer customer;

    private Prescription prescription;
    private LocalDate dateOfPurchase;
    //--------------------- CONSTRUCTORS ---------------------------------------

    public Purchase(int idPurchase, Map<Medication, Integer> listOfPurchase, Customer customer, LocalDate dateOfPurchase) {
        this.setIdPurchase(idPurchase);
        this.setListOfPurchase(listOfPurchase);
        this.setCustomer(customer);
        this.setDateOfPurchase(dateOfPurchase);

        Purchase.getListOfAllPurchase().add(this);
    }

    public Purchase(int idPurchase, Prescription prescription, Customer customer, LocalDate dateOfPurchase) {
        this.setIdPurchase(idPurchase);
        this.setPrescription(prescription);
        this.setCustomer(customer);
        this.setDateOfPurchase(dateOfPurchase);

        Purchase.getListOfAllPurchase().add(this);
    }

    public Purchase(int idPurchase, Map<Medication, Integer> listOfPurchase, Prescription prescription, Customer customer,
                    LocalDate dateOfPurchase) {
        this.setIdPurchase(idPurchase);
        this.setListOfPurchase(listOfPurchase);
        this.setPrescription(prescription);
        this.setCustomer(customer);
        this.setDateOfPurchase(dateOfPurchase);

        Purchase.getListOfAllPurchase().add(this);
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    public static ArrayList<Purchase> getListOfAllPurchase() {
        return listOfAllPurchase;
    }

    public static void setListOfAllPurchase(ArrayList<Purchase> listOfAllPurchase) {
        Purchase.listOfAllPurchase = listOfAllPurchase;
    }
    //--------------------- GETTERS - SETTERS ----------------------------------

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Map<Medication, Integer> getListOfPurchase() {
        return listOfPurchase;
    }

    public void setListOfPurchase(Map<Medication, Integer> listOfPurchase) {
        this.listOfPurchase = listOfPurchase;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    //--------------------- TO STRING METHOD------------------------------------
}

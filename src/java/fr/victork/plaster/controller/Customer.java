package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private String securityNumber;
    private LocalDate dateOfBirth;
    private Doctor doctor;
    private Mutual mutual;
    private static List<Customer> listOfCustomer = new ArrayList<>();
    private List<Specialist> listOfSpecialist = new ArrayList<>();
    private List<Prescription> listOfPrescription = new ArrayList<>();



    //--------------------- CONSTRUCTORS ---------------------------------------
    public Customer(
            int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
            String email, String securityNumber, LocalDate dateOfBirth, Doctor doctor, Mutual mutual,
            ArrayList<Specialist> listOfSpecialist) throws ExceptionEntity {
        super(idPerson, name, firstName, postalCode, city, phoneNumber, email);
        this.setSecurityNumber(securityNumber);
        this.setDateOfBirth(dateOfBirth);
        this.setDoctor(doctor);
        this.setMutual(mutual);
        Customer.setListOfCustomer(this);
        this.setListOfSpecialist(listOfSpecialist);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    public void addASpecialistToTheList(Specialist specialist){
        this.getListOfSpecialist().add(specialist);
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        if (checkRegexDigitsLength(securityNumber, 15)) {
            this.securityNumber = securityNumber;
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Mutual getMutual() {
        return mutual;
    }

    public void setMutual(Mutual mutual) {
        this.mutual = mutual;
    }

    public static List<Customer> getListOfCustomer() {
        return listOfCustomer;
    }

    public static void setListOfCustomer(Customer customer) {
        listOfCustomer.add(customer);
    }

    public List<Specialist> getListOfSpecialist() {
        return listOfSpecialist;
    }

    public void setListOfSpecialist(List<Specialist> listOfSpecialist) {
        this.listOfSpecialist = listOfSpecialist;
    }

    public List<Prescription> getListOfPrescription() {
        return listOfPrescription;
    }

    public void addPrescriptionToTheList(Prescription prescription) {
        this.listOfPrescription.add(prescription);
    }

    //--------------------- TO STRING METHOD------------------------------------

    @Override
    public String toString() {
        return "Customer{" +
                "securityNumber='" + securityNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", doctor=" + doctor +
                ", mutual=" + mutual +
                '}';
    }
}

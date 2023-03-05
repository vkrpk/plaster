package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer extends Person {
    //--------------------- CONSTANTS ------------------------------------------
    public static final Comparator<Customer> SORT_BY_NAME =
            Comparator.comparing(Customer::getName);
    public static final Comparator<Customer> SORT_BY_FIRSTNAME =
            Comparator.comparing((Customer::getFirstName));
    //--------------------- STATIC VARIABLES -----------------------------------
    private static ArrayList<Customer> listOfCustomer = new ArrayList<>();
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private String securityNumber;
    private LocalDate dateOfBirth;
    private Doctor doctor;
    private Mutual mutual;
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
        Customer.getListOfCustomer().add(this);
        this.setListOfSpecialist(listOfSpecialist);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    public void addASpecialistToTheList(Specialist specialist){
        this.getListOfSpecialist().add(specialist);
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    public static ArrayList<Customer> getListOfCustomer() {
        return listOfCustomer;
    }

    public static void setListOfCustomer(ArrayList<Customer> listOfCustomer) {
        Customer.listOfCustomer = listOfCustomer;
    }
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

    public List<Specialist> getListOfSpecialist() {
        return listOfSpecialist;
    }

    public void setListOfSpecialist(ArrayList<Specialist> listOfSpecialist) {
        this.listOfSpecialist = listOfSpecialist;
    }

    public List<Prescription> getListOfPrescription() {
        return listOfPrescription;
    }

    public void setListOfPrescription(ArrayList<Prescription> listOfPrescription) {
        this.listOfPrescription = listOfPrescription;
    }

    public void addPrescriptionToTheList(Prescription prescription) {
        this.getListOfPrescription().add(prescription);
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

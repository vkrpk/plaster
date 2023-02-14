package victork.plaster.entity;

import java.time.LocalDate;

public class Customer extends Person {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private String securityNumber;
    private LocalDate dateOfBirth;
    private Doctor doctor;
    private Mutual mutual;

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Customer(
            int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
            String email, String securityNumber, LocalDate dateOfBirth, Doctor doctor, Mutual mutual) {
        super(idPerson, name, firstName, postalCode, city, phoneNumber, email);
        this.setSecurityNumber(securityNumber);
        this.setDateOfBirth(dateOfBirth);
        this.setDoctor(doctor);
        this.setMutual(mutual);

    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
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
    //--------------------- TO STRING METHOD------------------------------------
}

package victork.plaster;

import java.time.LocalDate;

public class Prescription {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idPrescription;
    private LocalDate datePrescription;
    private Customer customer;
    private Person prescriber;
    //--------------------- CONSTRUCTORS ---------------------------------------

    public Prescription(int idPrescription, LocalDate datePrescription, Customer customer, Person prescriber) {
        this.setIdPrescription(idPrescription);
        this.setDatePrescription(datePrescription);
        this.setCustomer(customer);
        this.setPrescriber(prescriber);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
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

    //--------------------- TO STRING METHOD------------------------------------
}

package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person implements Prescribe {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private String approvalNumber;
    private static List<Doctor> listOfDoctor = new ArrayList<>();


    //--------------------- CONSTRUCTORS ---------------------------------------
    public Doctor(
            int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
            String email, String approvalNumber) throws ExceptionEntity {
        super(idPerson, name, firstName, postalCode, city, phoneNumber, email);
        this.setApprovalNumber(approvalNumber);
        Doctor.setListOfDoctor(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        if (checkRegexDigitsLength(approvalNumber, 11)) {
            this.approvalNumber = approvalNumber;
        }
    }

    public static List<Doctor> getListOfDoctor() {
        return listOfDoctor;
    }

    public static void setListOfDoctor(Doctor doctor) {
        listOfDoctor.add(doctor);
    }
    //--------------------- TO STRING METHOD------------------------------------

    @Override
    public String toString() {
        return "Doctor{" +
                "approvalNumber='" + approvalNumber + '\'' +
                '}';
    }
}

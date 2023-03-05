package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person implements Prescribe {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    private static ArrayList<Doctor> listOfDoctor = new ArrayList<>();
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private String approvalNumber;


    //--------------------- CONSTRUCTORS ---------------------------------------
    public Doctor(
            int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
            String email, String approvalNumber) throws ExceptionEntity {
        super(idPerson, name, firstName, postalCode, city, phoneNumber, email);
        this.setApprovalNumber(approvalNumber);
        Doctor.getListOfDoctor().add(this);

    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    public static List<Doctor> getListOfDoctor() {
        return listOfDoctor;
    }
    public static void setListOfDoctor(ArrayList<Doctor> listOfDoctor) {
        Doctor.listOfDoctor = listOfDoctor;
    }
    //--------------------- GETTERS - SETTERS ----------------------------------
    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        if (checkRegexDigitsLength(approvalNumber, 11)) {
            this.approvalNumber = approvalNumber;
        }
    }
    //--------------------- TO STRING METHOD------------------------------------
    @Override
    public String toString() {
        return "Doctor{" +
                "approvalNumber='" + approvalNumber + '\'' +
                '}';
    }
}

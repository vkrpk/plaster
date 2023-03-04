package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.tools.ControlTelephone;
import fr.victork.plaster.tools.Tools;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Mutual implements Tools {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idMutual;
    private String name;
    private String address;
    private String postalCode;
    private String phoneNumber;
    private Department department;
    private static List<Mutual> listOfMutual = new ArrayList<>();

    private static Map<Float, Medication> reimbursementRatePerMedication = new LinkedHashMap<>();

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Mutual(int idMutual, String name, String address, String postalCode, String phoneNumber,
                  Department department) throws ExceptionEntity {
        this.setIdMutual(idMutual);
        this.setName(name);
        this.setAddress(address);
        this.setPostalCode(postalCode);
        this.setPhoneNumber(phoneNumber);
        this.setDepartment(department);
        Mutual.setListOfMutual(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    public int getIdMutual() {
        return idMutual;
    }

    public void setIdMutual(int idMutual) {
        this.idMutual = idMutual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) throws ExceptionEntity {
        if (checkRegexDigitsLength(postalCode, 5)) {
            this.postalCode = postalCode;
        } else {
            throw new ExceptionEntity("ZIP code not good");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) throws ExceptionEntity {
        if (ControlTelephone.controlTelephone(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new ExceptionEntity(phoneNumber+" : Phone is not good");
        }
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static List<Mutual> getListOfMutual() {
        return listOfMutual;
    }

    public static void setListOfMutual(Mutual mutual) {
        listOfMutual.add(mutual);
    }

    public static Map<Float, Medication> getReimbursementRatePerMedication() {
        return reimbursementRatePerMedication;
    }

    public static void addMedicationReimbursementRate(Float rate, Medication medication) {
        reimbursementRatePerMedication.put(rate, medication);
    }
    //--------------------- TO STRING METHOD------------------------------------

    @Override
    public String toString() {
        return "Mutual{" +
                "idMutual=" + idMutual +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department=" + department +
                '}';
    }
}

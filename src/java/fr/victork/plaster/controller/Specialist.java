package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;

import java.util.ArrayList;
import java.util.List;

public class Specialist extends Person implements Prescribe {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    private static ArrayList<Specialist> listOfSpecialist = new ArrayList<>();
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private Speciality speciality;

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Specialist(
            int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
            String email, Speciality speciality) throws ExceptionEntity {
        super(idPerson, name, firstName, postalCode, city, phoneNumber, email);
        this.setSpeciality(speciality);
        Specialist.getListOfSpecialist().add(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
    public static List<Specialist> getListOfSpecialist() {
        return listOfSpecialist;
    }

    public static void setListOfSpecialist(ArrayList<Specialist> listOfSpecialist) {
        Specialist.listOfSpecialist = listOfSpecialist;
    }
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }


    //--------------------- TO STRING METHOD------------------------------------

    @Override
    public String toString() {
        return "Specialist{" +
                "speciality=" + speciality +
                '}';
    }
}

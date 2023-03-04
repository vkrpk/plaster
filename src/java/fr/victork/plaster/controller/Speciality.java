package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.tools.ControlString;

import java.util.ArrayList;
import java.util.List;

public class Speciality {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idSpeciality;
    private String label;
    private static List<Speciality> listOfSpeciality = new ArrayList<>();


    //--------------------- CONSTRUCTORS ---------------------------------------
    public Speciality(int idSpeciality, String label) throws ExceptionEntity {
        this.setIdSpeciality(idSpeciality);
        this.setLabel(label);
        Speciality.setListOfSpeciality(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    public int getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) throws ExceptionEntity {
        if (ControlString.controlString(label)) {
            this.label = label;
        } else {
            throw new ExceptionEntity("Input is not good");
        }
    }

    public static List<Speciality> getListOfSpeciality() {
        return listOfSpeciality;
    }

    public static void setListOfSpeciality(Speciality speciality) {
        listOfSpeciality.add(speciality);
    }
    //--------------------- TO STRING METHOD------------------------------------

    @Override
    public String toString() {
        return "Speciality{" +
                "idSpeciality=" + idSpeciality +
                ", label='" + label + '\'' +
                '}';
    }
}

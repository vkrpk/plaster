package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.tools.ControlString;

import java.util.ArrayList;
import java.util.List;

public class Department {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    private static ArrayList<Department> listOfDepartment = new ArrayList<>();
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idDepartment;
    private String label;

    //--------------------- CONSTRUCTORS ---------------------------------------

    public Department(int idDepartment, String label) throws ExceptionEntity {
        this.setIdDepartment(idDepartment);
        this.setLabel(label);
        Department.getListOfDepartment().add(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    public static ArrayList<Department> getListOfDepartment() {
        return listOfDepartment;
    }

    public static void setListOfDepartment(ArrayList<Department> listOfDepartment) {
        Department.listOfDepartment = listOfDepartment;
    }
    //--------------------- GETTERS - SETTERS ----------------------------------

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
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
    //--------------------- TO STRING METHOD------------------------------------
    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", label='" + label + '\'' +
                '}';
    }
}

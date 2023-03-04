package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.tools.ControlString;

import java.util.ArrayList;
import java.util.List;

public class Department {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idDepartment;
    private String label;
    private static List<Department> listOfDepartment = new ArrayList<>();

    //--------------------- CONSTRUCTORS ---------------------------------------

    public Department(int idDepartment, String label) throws ExceptionEntity {
        this.setIdDepartment(idDepartment);
        this.setLabel(label);
        Department.setListOfDepartment(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
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

    public static List<Department> getListOfDepartment() {
        return listOfDepartment;
    }

    public static void setListOfDepartment(Department department) {
        listOfDepartment.add(department);
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
package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.tools.ControlString;

public class Category {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idCategory;
    private String label;
    //--------------------- CONSTRUCTORS ---------------------------------------
    public Category(int idCategory, String label) throws ExceptionEntity {
        this.setIdCategory(idCategory);
        this.setLabel(label);
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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
}

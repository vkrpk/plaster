package fr.victork.plaster.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlTelephone {
    //--------------------- CONSTANTS ------------------------------------------

    //--------------------- STATIC VARIABLES -----------------------------------

    //--------------------- INSTANCE VARIABLES ---------------------------------

    //--------------------- CONSTRUCTORS ---------------------------------------

    //--------------------- STATIC METHODS -------------------------------------
    public static boolean controlTelephone(String telephone) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(telephone);
        return matcher.find();
    };
    //--------------------- INSTANCE METHODS -----------------------------------

    //--------------------- ABSTRACT METHODS -----------------------------------

    //--------------------- STATIC - GETTERS - SETTERS -------------------------

    //--------------------- GETTERS - SETTERS ----------------------------------

    //--------------------- TO STRING METHOD------------------------------------
}

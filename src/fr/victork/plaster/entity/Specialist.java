package victork.plaster.entity;

import java.util.ArrayList;
import java.util.List;

public class Specialist extends Person implements Prescribe {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private Speciality speciality;
    private static List<Specialist> listOfSpecialist = new ArrayList<>();

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Specialist(
            int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
            String email, Speciality speciality) {
        super(idPerson, name, firstName, postalCode, city, phoneNumber, email);
        this.setSpeciality(speciality);
        Specialist.setListOfSpecialist(this);
    }

    //--------------------- STATIC METHODS -------------------------------------
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

    public static List<Specialist> getListOfSpecialist() {
        return listOfSpecialist;
    }

    public static void setListOfSpecialist(Specialist specialist) {
        listOfSpecialist.add(specialist);
    }
    //--------------------- TO STRING METHOD------------------------------------

    @Override
    public String toString() {
        return "Specialist{" +
                "speciality=" + speciality +
                '}';
    }
}

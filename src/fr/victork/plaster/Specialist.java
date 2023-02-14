package victork.plaster;

public class Specialist extends Person {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private Speciality speciality;

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Specialist(
            int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
            String email, Speciality speciality) {
        super(idPerson, name, firstName, postalCode, city, phoneNumber, email);
        this.setSpeciality(speciality);
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
    //--------------------- TO STRING METHOD------------------------------------
}

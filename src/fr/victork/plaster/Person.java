package victork.plaster;

public abstract class Person implements Tools{
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idPerson;
    private String name;
    private String firstName;
    private String postalCode;
    private String city;
    private String phoneNumber;
    private String email;

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Person(int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber, String email) {
        this.setIdPerson(idPerson);
        this.setName(name);
        this.setFirstName(firstName);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
    }
    //--------------------- STATIC METHODS -------------------------------------

    //--------------------- INSTANCE METHODS -----------------------------------

    //--------------------- ABSTRACT METHODS -----------------------------------

    //--------------------- STATIC - GETTERS - SETTERS -------------------------

    //--------------------- GETTERS - SETTERS ----------------------------------
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        if (checkRegexDigitsLength(postalCode, 5)) {
            this.postalCode = postalCode;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (postalCode.matches("\\.@.")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Parameter is invalid.");
        }
    }
    //--------------------- TO STRING METHOD------------------------------------
}

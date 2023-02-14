package victork.plaster;

public class Mutual implements  Tools{
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private int idMutual;
    private String name;
    private String address;
    private String postalCode;
    private String phoneNumber;


    //--------------------- CONSTRUCTORS ---------------------------------------
    public Mutual(int idMutual, String name, String address, String postalCode, String phoneNumber) {
        this.setIdMutual(idMutual);
        this.setName(name);
        this.setAddress(address);
        this.setPostalCode(postalCode);
        this.setPhoneNumber(phoneNumber);
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

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //--------------------- TO STRING METHOD------------------------------------
}

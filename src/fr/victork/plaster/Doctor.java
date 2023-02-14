package victork.plaster;

import java.time.LocalDate;

public class Doctor extends Person {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private String approvalNumber;

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Doctor(
            int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
            String email, String approvalNumber) {
        super(idPerson, name, firstName, postalCode, city, phoneNumber, email);
        this.setApprovalNumber(approvalNumber);
    }

    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        if (checkRegexDigitsLength(approvalNumber, 11)) {
            this.approvalNumber = approvalNumber;
        }
    }
    //--------------------- TO STRING METHOD------------------------------------
}

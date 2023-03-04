package fr.victork.plaster.controller;

import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.tools.ControlString;
import fr.victork.plaster.tools.ControlTelephone;
import fr.victork.plaster.tools.Tools;

import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Tools {
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
    private static List<Person> listOfPerson = new ArrayList<>();

    //--------------------- CONSTRUCTORS ---------------------------------------
    public Person(int idPerson, String name, String firstName, String postalCode, String city, String phoneNumber,
                  String email) throws ExceptionEntity {
        this.setIdPerson(idPerson);
        this.setName(name);
        this.setFirstName(firstName);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        Person.setListOfPerson(this);
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

    public void setName(String name) throws ExceptionEntity {
        if (ControlString.controlString(name)) {
            this.name = name;
        } else {
            throw new ExceptionEntity("Entry cannot be null or empty");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws ExceptionEntity {
        if (ControlString.controlString(firstName)) {
            this.firstName = firstName;
        } else {
            throw new ExceptionEntity("Entry cannot be null or empty");
        }
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) throws ExceptionEntity {
        if (checkRegexDigitsLength(postalCode, 5)) {
            this.postalCode = postalCode;
        } else {
            throw new ExceptionEntity("ZIP code not good");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws ExceptionEntity {
        if (ControlString.controlString(city)) {
            this.city = city;
        } else {
            throw new ExceptionEntity("Input is not good");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws ExceptionEntity {
        if (ControlTelephone.controlTelephone(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new ExceptionEntity(phoneNumber+" : Phone is not good");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.matches(".+@.+")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Parameter " + email + " is invalid.");
        }
    }

    public static List<Person> getListOfPerson() {
        return listOfPerson;
    }

    public static void setListOfPerson(Person person) {
        listOfPerson.add(person);
    }
    //--------------------- TO STRING METHOD------------------------------------

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

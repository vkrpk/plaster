package fr.victork.plaster.main;

import fr.victork.plaster.controller.*;
import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.tools.Tools;
import fr.victork.plaster.view.HomeFrame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main implements Tools {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    //--------------------- CONSTRUCTORS ---------------------------------------
    //--------------------- STATIC METHODS -------------------------------------
    public static void main(String[] args) throws ExceptionEntity {
        initData();
        start();
    }
    public static void start() throws ExceptionEntity {
        new HomeFrame();
    }

    public static void initData() throws ExceptionEntity {
        Main main = new Main();
        try {
            Department moselle = new Department(57, "Moselle");
            Department meuse = new Department(55, "Meuse");
            Speciality cardiologist = new Speciality(1, "Cardiologist");
            Speciality dentist = new Speciality(1, "Dentist");
            Category painkiller = new Category(1, "Painkiller");
            Category antiInflammatory = new Category(2, "Anti inflammatory");
            Category antibiotic = new Category(2, "Antibiotic");
            Specialist doctorCardiologist = new Specialist(
                    2,
                    "LOAN",
                    "Casimir",
                    main.generateStringOfNumbers(5),
                    "Metz",
                    main.generateStringOfNumbers(10),
                    "emailSpecialist@gmail.com",
                    cardiologist
            );
            Specialist doctorDentist = new Specialist(
                    2,
                    "Rollin",
                    "Regis",
                    main.generateStringOfNumbers(5),
                    "Metz",
                    main.generateStringOfNumbers(10),
                    "emailSpecialist@gmail.com",
                    dentist
            );

            ArrayList<Specialist> listOfSpecialist = new ArrayList<>();
            listOfSpecialist.add(doctorCardiologist);
            listOfSpecialist.add(doctorDentist);

            Medication doliprane = new Medication(
                    1,
                    "Doliprane",
                    5,
                    LocalDate.of(1957, 7, 25),
                    2000,
                    painkiller
            );

            Medication aspirin = new Medication(
                    2,
                    "Aspirin",
                    4,
                    LocalDate.of(1960, 1, 12),
                    4000,
                    antiInflammatory
            );

            Map<Medication, Integer> medicationMutualHealth = new HashMap<>();
            medicationMutualHealth.put(doliprane, 1);
            medicationMutualHealth.put(aspirin, 3);

            Mutual mutualHealth = new Mutual(
                    1,
                    "Mutual health",
                    "75 peace street",
                    "75000",
                    "0142578974",
                    moselle,
                    medicationMutualHealth
            );

            Doctor doctorDupont = new Doctor(
                    2,
                    "Dupont",
                    "Pierre-Yves",
                    main.generateStringOfNumbers(5),
                    "Metz",
                    main.generateStringOfNumbers(10),
                    "email@gmail.com",
                    main.generateStringOfNumbers(11)
            );
            Customer daniel = new Customer(
                    Person.autoIdIncremented(),
                    "Michel",
                    "Daniel",
                    main.generateStringOfNumbers(5),
                    "Metz",
                    main.generateStringOfNumbers(10),
                    "email_dnaiel@gmail.com",
                    main.generateStringOfNumbers(15),
                    LocalDate.of(1997, 5, 5),
                    doctorDupont,
                    mutualHealth,
                    null
            );

            Customer pierre = new Customer(
                    Person.autoIdIncremented(),
                    "MINOTI",
                    "Pierre",
                    main.generateStringOfNumbers(5),
                    "Nancy",
                    main.generateStringOfNumbers(10),
                    "email_pierre@gmail.com",
                    main.generateStringOfNumbers(15),
                    LocalDate.of(1995, 2, 12),
                    doctorDupont,
                    mutualHealth,
                    listOfSpecialist
            );

            Map<Medication, Integer> prescriptionForDaniel = new HashMap<>();
            prescriptionForDaniel.put(doliprane, 1);
            prescriptionForDaniel.put(aspirin, 2);

            doctorDupont.giveAPrescription(daniel, doctorDupont, prescriptionForDaniel);

            daniel.setListOfSpecialist(listOfSpecialist);

            Map<Medication, Integer> listOfPurchaseForDaniel = new HashMap<>();
            listOfPurchaseForDaniel.put(doliprane, 1);
            listOfPurchaseForDaniel.put(aspirin, 2);
            Purchase purchaseForDaniel = new Purchase(1,listOfPurchaseForDaniel, daniel,
                    LocalDate.of(2022, 7, 30));

            Map<Medication, Integer> listOfPurchaseForPierre = new HashMap<>();
            listOfPurchaseForPierre.put(doliprane, 3);
            listOfPurchaseForPierre.put(aspirin, 1);
            Purchase purchaseForPierre = new Purchase(2, listOfPurchaseForPierre, pierre,
                    LocalDate.of(2023, 02, 03));
        }
        catch (ExceptionEntity ee)
        {
            System.out.println("There is an error, here it is : " + ee.getMessage());
        }
    }
    //--------------------- INSTANCE METHODS -----------------------------------
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}
package victork.plaster.main;

import victork.plaster.entity.*;
import victork.plaster.entity.Person;
import victork.plaster.tools.Tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main implements Tools {
    public static void main(String[] args) {
        Main main = new Main();
        Department moselle = new Department(57, "Moselle");
        Mutual mutualHealth = new Mutual(
                1,
                "Mutual health",
                "75 peace street",
                "75000",
                "0142578974",
                moselle
        );
        Speciality cardiologist = new Speciality(1, "Cardiologist");
        Doctor doctorDoucet = new Doctor(
                2,
                "DOUCET",
                "Pierre-Yves",
                main.generateStringOfNumbers(5),
                "Amnéville",
                main.generateStringOfNumbers(10),
                "email@gmail.com",
                main.generateStringOfNumbers(11)
        );
        Specialist specialistLoan = new Specialist(
                2,
                "LOAN",
                "Casimir",
                mutualHealth.generateStringOfNumbers(5),
                "Metz",
                mutualHealth.generateStringOfNumbers(10),
                "emailSpecialist@gmail.com",
                cardiologist
        );
        ArrayList<Specialist> listOfSpecialists = new ArrayList<>();
        listOfSpecialists.add(specialistLoan);
        Customer paul = new Customer(
                1,
                "OBAMA",
                "Barack",
                mutualHealth.generateStringOfNumbers(5),
                "Washington",
                mutualHealth.generateStringOfNumbers(10),
                "email@gmail.com",
                mutualHealth.generateStringOfNumbers(15),
                LocalDate.of(1997, 5, 5),
                doctorDoucet,
                mutualHealth,
                listOfSpecialists
        );
        Category painkiller = new Category(1, "Painkiller");
        Category antiInflammatory = new Category(2, "Anti inflammatory");
        Medication doliprane = new Medication(
                1,
                "Doliprane",
                5,
                LocalDate.now(),
                2000,
                painkiller
        );
        Medication aspirin = new Medication(
                2,
                "Aspirin",
                4,
                LocalDate.now(),
                4000,
                painkiller
        );
        ArrayList<Medication> listOfMedications = new ArrayList<>();
        listOfMedications.add(aspirin);
        listOfMedications.add(doliprane);
        specialistLoan.giveAPrescription(paul, specialistLoan, listOfMedications);


        for (Prescription prescription : paul.getListOfPrescription()
        ) {
            for (Medication medication : prescription.getListOfMedication()
            ) {
                System.out.println(medication.getName());
            }
        }
    }
}
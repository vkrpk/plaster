package victork.plaster.main;

import victork.plaster.entity.*;
import victork.plaster.tools.Tools;

import java.time.LocalDate;

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
        String numberAgrement = main.generateStringOfNumbers(11);
        System.out.println(numberAgrement.getClass());
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
                doctorDoucet, mutualHealth
        );
        Category painkiller = new Category(1, "Painkiller");
        Medication doliprane = new Medication(
                1,
                "Medication",
                5,
                LocalDate.now(),
                2000,
                painkiller
        );
        specialistLoan.giveAPrescription(paul, specialistLoan);
    }
}
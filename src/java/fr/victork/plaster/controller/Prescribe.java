package fr.victork.plaster.controller;

import fr.victork.plaster.tools.Tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public interface Prescribe extends Tools {
    default Prescription giveAPrescription(
            Customer customer,
            Person person,
            Map<Medication, Integer> listOfMedication
    ) {
        return new Prescription(
                generateIntBetween(1, 10000),
                LocalDate.now(),
                customer,
                person,
                listOfMedication
        );
    }
}

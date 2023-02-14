package victork.plaster.entity;

import victork.plaster.tools.Tools;

import java.time.LocalDate;

public interface Prescribe extends Tools {
    default Prescription giveAPrescription(Customer customer, Person person){
        return new Prescription(generateIntBetween(1, 10000), LocalDate.now(), customer, person);
    }
}

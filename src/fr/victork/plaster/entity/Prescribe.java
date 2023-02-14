package victork.plaster.entity;

import java.time.LocalDate;

public interface Prescribe {
    default Prescription giveAPrescription(Customer customer, Person person){
        int max = 10000;
        int min = 1;
        return new Prescription( (int)(Math.random()*(max-min+1)+min), LocalDate.now(), customer, person);
    }
}
